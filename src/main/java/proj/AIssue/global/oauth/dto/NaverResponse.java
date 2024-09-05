package proj.AIssue.global.oauth.dto;

import lombok.RequiredArgsConstructor;
import proj.AIssue.domain.member.entity.Authority;
import proj.AIssue.domain.member.entity.Member;

import java.util.Map;

@RequiredArgsConstructor
public class NaverResponse implements OAuth2Response {

    private final Map<String, Object> attribute;

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getProviderId() {
        return (String) ((Map<?, ?>) attribute.get("response")).get("id");
    }

    @Override
    public String getEmail() {
        return (String) ((Map<?, ?>) attribute.get("response")).get("email");
    }

    @Override
    public String getName() {
        return (String) ((Map<?, ?>) attribute.get("response")).get("name");
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