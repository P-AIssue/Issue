package proj.AIssue.global.oauth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import proj.AIssue.domain.member.entity.Authority;
import proj.AIssue.global.oauth.dto.OAuth2Response;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class OAuth2Member implements OAuth2User {

    private final OAuth2Response oAuth2Response;

    @Override
    public Map<String, Object> getAttributes() {
        return Map.of();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(Authority.USER.name()));
    }

    @Override
    public String getName() {
        return oAuth2Response.getName();
    }
}
