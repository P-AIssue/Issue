package proj.AIssue.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long memberId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    private String provider;
    private String providerId;

    @Builder.Default
    private Boolean isDeleted = Boolean.FALSE;

//    private List<Long> likedIssues;  사용자가 좋아요를 누른 이슈들 (Issue ID 목록)
}