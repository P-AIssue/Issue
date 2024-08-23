package proj.AIssue.domain.issue.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import proj.AIssue.domain.issue.dto.IssueDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {

    @Value("${naver.api.clientId}")
    private String clientId;

    @Value("${naver.api.clientSecret}")
    private String clientSecret;

    @Value("${naver.api.url}")
    private String apiUrl;

    private final ObjectMapper objectMapper;

    public List<IssueDTO> searchNews(String query) {
        String urlStr = apiUrl + "?query=" + URLEncoder.encode(query, StandardCharsets.UTF_8);

        HttpURLConnection urlConnection = null;
        InputStream stream = null;
        String result = null;

        try {
            URL url = new URL(urlStr);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("X-Naver-Client-Id", clientId);
            urlConnection.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            urlConnection.setConnectTimeout(3000);
            urlConnection.setReadTimeout(3000);

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                stream = urlConnection.getInputStream();
                result = readStreamToString(stream);
            } else {
                throw new IOException("HTTP error code : " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) try { stream.close(); } catch (IOException e) { e.printStackTrace(); }
            if (urlConnection != null) urlConnection.disconnect();
        }

        // JSON 응답을 IssueDTO 리스트로 변환
        List<IssueDTO> issueDTOs = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(result);
            JsonNode items = root.path("items");

            for (JsonNode item : items) {
                String title = item.path("title").asText();
                String sourceUrl = item.path("originallink").asText();
                String description = item.path("description").asText();

                IssueDTO issueDTO = new IssueDTO(title, sourceUrl, description);
                issueDTOs.add(issueDTO);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return issueDTOs;
    }

    private String readStreamToString(InputStream stream) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
        String readLine;
        while ((readLine = br.readLine()) != null) {
            result.append(readLine).append("\n");
        }
        br.close();
        return result.toString();
    }
}

