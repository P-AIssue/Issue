package proj.AIssue.global.oauth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import proj.AIssue.domain.member.repository.MemberRepository;
import proj.AIssue.global.oauth.dto.GoogleResponse;
import proj.AIssue.global.oauth.dto.NaverResponse;
import proj.AIssue.global.oauth.dto.OAuth2Response;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OAuth2MemberService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("memberInfo = {}", oAuth2User.getAttributes());

        OAuth2Response oAuth2Response = getOAuth2Response(userRequest, oAuth2User)
                .orElseThrow(() -> new OAuth2AuthenticationException(
                        "Unsupported provider: " + userRequest.getClientRegistration().getRegistrationId()));

        // 해당 Response로 Member 객체 찾아와서 accessToken 생성

        return new OAuth2Member(oAuth2Response);
    }

    private Optional<OAuth2Response> getOAuth2Response(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response;

        if ("naver".equals(registrationId)) {
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        } else if ("google".equals(registrationId)) {
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        } else {
            oAuth2Response = null;
        }

        return Optional.ofNullable(oAuth2Response);
    }
}
