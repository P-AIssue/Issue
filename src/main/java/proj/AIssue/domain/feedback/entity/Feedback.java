package proj.AIssue.domain.feedback.entity;


import jakarta.persistence.*;
import lombok.*;
import proj.AIssue.domain.issue.entity.Issue;
import proj.AIssue.domain.member.entity.Member;
import proj.AIssue.global.common.BaseTimeEntity;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Feedback extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @ManyToOne
    @JoinColumn(name = "issue_id", nullable = false)
    private Issue issue;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    private FeedbackType feedbackType;  // 피드백 유형

}
