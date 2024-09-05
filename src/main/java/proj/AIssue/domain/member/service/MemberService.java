package proj.AIssue.domain.member.service;

import proj.AIssue.domain.member.entity.Member;

import java.util.List;

public interface MemberService {

    void register(Member member);
    void update(Member member);
    void delete(Member member);
    List<Member> getMembers();
    Member getOne(Long id);
}
