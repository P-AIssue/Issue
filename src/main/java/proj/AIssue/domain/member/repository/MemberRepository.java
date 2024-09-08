package proj.AIssue.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.AIssue.domain.member.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<Member> findByEmail(String email);
}
