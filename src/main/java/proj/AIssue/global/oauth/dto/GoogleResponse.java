package proj.AIssue.global.oauth.dto;

import lombok.RequiredArgsConstructor;
import proj.AIssue.domain.member.entity.Authority;
import proj.AIssue.domain.member.entity.Member;

import java.util.Map;

@RequiredArgsConstructor
public class GoogleResponse implements OAuth2Response {

    private final Map<String, Object> attribute;

    @Override
    public String getProvider() {
        return "google";
    }

    @Override
    public String getProviderId() {
        return attribute.get("sub").toString();
    }

    @Override
    public String getEmail() {
        return attribute.get("email").toString();
    }

    @Override
    public String getName() {
        return attribute.get("name").toString();
    }

    @Override
    public Member toEntity() {
        return Member.builder()
                .provider(getProvider())
                .providerId(getProviderId())
                .email(getEmail())
                .username(getName())
                .authority(Authority.USER)
                .build();
    }
}
