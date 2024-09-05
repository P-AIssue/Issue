package proj.AIssue.domain.report.entity;

import jakarta.persistence.*;
import lombok.*;
import proj.AIssue.domain.issue.entity.Issue;
import proj.AIssue.domain.member.entity.Member;
import proj.AIssue.global.common.BaseTimeEntity;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "issue_id", nullable = false)
    private Issue issue;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String reason;  // 신고 이유

    @Enumerated(EnumType.STRING)
    private ReportStatus reportStatus; //대기, 처리, 처리완료
}
