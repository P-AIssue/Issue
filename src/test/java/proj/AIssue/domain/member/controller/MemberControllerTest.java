package proj.AIssue.domain.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import proj.AIssue.domain.member.dto.MemberInfoDTO;
import proj.AIssue.domain.member.entity.Member;
import proj.AIssue.domain.member.service.MemberService;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Autowired
    private ObjectMapper objectMapper;


    private OAuth2User oauth2User;


    @BeforeEach
    public void setUp() {
        // Oauth2User 모의 객체 생성
        oauth2User = Mockito.mock(OAuth2User.class);
        // 로그인된 사용자의 id를 1로 설정
        Mockito.when(oauth2User.getName()).thenReturn("1");

        // SecurityContext에 인증 정보 설정
        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authentication.getPrincipal()).thenReturn(oauth2User);

        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }



    @Test
    @WithMockUser(username = "테스트", roles = {"USER"})
    public void 내정보조회_성공() throws Exception {
        // given: 반환할 회원 정보 설정
        Member member = Member.builder()
                .username("테스트")
                .email("sumin@naver.com")
                .build();
        MemberInfoDTO memberInfoDTO = MemberInfoDTO.builder()
                .member(member)
                .build();

        // 서비스 계층에서 getInfo가 호출될 때 memberInfoDTO를 반환하도록 설정
        given(memberService.getInfo(anyLong())).willReturn(memberInfoDTO);

        // when: "/member"로 GET 요청
        mockMvc.perform(get("/member")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "테스트", roles = {"USER"})
    public void 회원정보조회_성공() throws Exception {
        // given: 반환할 회원 정보 설정
        Member member = Member.builder()
                .username("테스트")
                .email("sumin@naver.com")
                .build();
        MemberInfoDTO memberInfoDTO = MemberInfoDTO.builder()
                .member(member)
                .build();

        // 서비스 계층에서 getInfo가 호출될 때 memberInfoDTO를 반환하도록 설정
        given(memberService.getInfo(anyLong())).willReturn(memberInfoDTO);

        // when: "/member/{id}"로 GET 요청을 보냅니다.
        mockMvc.perform(get("/member/{id}", 1L)  // id가 1인 사용자를 조회
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}