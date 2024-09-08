package proj.AIssue.domain.member.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.AIssue.domain.member.dto.MemberInfoDTO;
import proj.AIssue.domain.member.dto.MemberUpdateDTO;
import proj.AIssue.domain.member.exception.MemberException;
import proj.AIssue.domain.member.service.MemberService;
import proj.AIssue.global.exception.ErrorCode;
import proj.AIssue.global.exception.dto.ResponseVO;
import proj.AIssue.global.resolver.LoginUser;
import proj.AIssue.global.resolver.User;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;


//    /**
//     * 회원 정보 수정
//     */
//    @PutMapping
//    @ResponseStatus(HttpStatus.OK)
//    public void updateInfo(@Valid @RequestBody MemberUpdateDTO memberUpdateDTO, @User LoginUser loginUser) throws Exception {
//
//        // LoginUser 객체에서 memberId를 가져와서 사용
//        Long memberId = loginUser.getMemberId();
//        memberService.update(memberUpdateDTO, memberId);
//    }


    /**
     * 회원 정보 조회
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO getInfo(@Valid @PathVariable("id") Long id) throws Exception {
        MemberInfoDTO info = memberService.getInfo(id);
        return new ResponseVO(info);
    }


    /**
     * 내 정보 조회
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO getMyInfo(@User LoginUser loginUser) throws Exception {

        Long memberId = loginUser.getMemberId();
        if (memberId == null) {
            throw new MemberException(ErrorCode.NOT_FOUND_MEMBER);
        }
        MemberInfoDTO info = memberService.getInfo(memberId);
        return new ResponseVO(info);
    }
}
