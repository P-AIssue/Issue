package proj.AIssue.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.AIssue.domain.member.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
}
