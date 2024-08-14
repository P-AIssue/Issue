package proj.AIssue.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.AIssue.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
