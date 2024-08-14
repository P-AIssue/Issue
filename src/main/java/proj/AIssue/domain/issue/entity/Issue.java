package proj.AIssue.domain.issue.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueId;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdAt;  // 이슈 생성 시각

    @Column(nullable = false)
    private LocalDateTime updatedAt;  // 이슈 수정 시각

    @Column(nullable = false, length = 512)
    private String sourceUrl;  // 이슈 출처 URL

    @Enumerated(EnumType.STRING)
    private Category category;

}