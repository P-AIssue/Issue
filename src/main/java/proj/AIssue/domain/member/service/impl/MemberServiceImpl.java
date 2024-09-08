package proj.AIssue.domain.member.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.AIssue.domain.member.dto.MemberInfoDTO;
import proj.AIssue.domain.member.dto.MemberUpdateDTO;
import proj.AIssue.domain.member.entity.Member;
import proj.AIssue.domain.member.repository.MemberRepository;
import proj.AIssue.domain.member.service.MemberService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;


    @Override
    public void update(MemberUpdateDTO memberUpdateDTO, Long memberId) throws Exception {

        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new Exception("회원이 존재하지 않습니다."));

        memberUpdateDTO.username().ifPresent(member::updateUserName);
        memberUpdateDTO.email().ifPresent(member::updateEmail);

        //필요한 필드 추가 가능
    }

    @Override
    public MemberInfoDTO getInfo(Long id) throws Exception {

        Member findMember = memberRepository.findById(id).orElseThrow(
                () -> new Exception("회원이 존재하지 않습니다."));

        return new MemberInfoDTO(findMember);
    }


    @Override
    public List<Member> getMembers() {
        return List.of();
    }

    @Override
    public Member getOne(Long id) {
        return null;
    }

    @Override
    public void withdraw(String password) throws Exception {
    }
}
