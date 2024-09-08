package proj.AIssue.global.resolver;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import proj.AIssue.global.oauth.JwtUtils;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthArgumentResolverTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JwtUtils jwtUtils;

    /**
     * JwtUtils 모의 설정
     */
    @BeforeEach
    public void setUp() {

        Mockito.when(jwtUtils.extractAccessToken(Mockito.any(HttpServletRequest.class)))
                .thenReturn(Optional.of("mockAccessToken")); // accessToken에서 사용자 id 추출
        Mockito.when(jwtUtils.extractMemberId(Mockito.any(HttpServletRequest.class)))
                .thenReturn(Optional.of(1L)); // id는 1로
    }

    @Test
    @WithMockUser(username = "testuser", roles = {"USER"})
    public void api테스트_성공() throws Exception {
        // when: "/member"로 GET 요청
        mockMvc.perform(get("/member")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}