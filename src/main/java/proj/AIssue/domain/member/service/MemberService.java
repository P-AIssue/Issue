package proj.AIssue.domain.member.service;

import proj.AIssue.domain.member.dto.MemberInfoDTO;
import proj.AIssue.domain.member.dto.MemberUpdateDTO;
import proj.AIssue.domain.member.entity.Member;

import java.util.List;

public interface MemberService {

    // 회원 정보 수정
    void update(MemberUpdateDTO memberUpdateDTO, Long memberId) throws Exception;

    //회원탈퇴
    void withdraw(String password) throws Exception;

    //해당 회원의 정보
    MemberInfoDTO getInfo(Long id) throws Exception;

    List<Member> getMembers();
    Member getOne(Long id);
}
