package proj.AIssue.global.oauth.dto;

import lombok.RequiredArgsConstructor;
import proj.AIssue.domain.member.entity.Member;

import java.util.Map;

@RequiredArgsConstructor
public class KakaoResponse implements OAuth2Response {

    private final Map<String, Object> attribute;

    @Override
    public String getProvider() {
        return "";
    }

    @Override
    public String getProviderId() {
        return "";
    }

    @Override
    public String getEmail() {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public Member toEntity() {
        return null;
    }
}
