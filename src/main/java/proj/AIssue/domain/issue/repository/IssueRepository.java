package proj.AIssue.domain.issue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.AIssue.domain.issue.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
