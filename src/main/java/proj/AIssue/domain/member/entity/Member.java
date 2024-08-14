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

    @Column(nullable = false)
    private String password;

//    private String oauthProvider;  // OAuth2 제공자
//
//    private String oauthId;  // OAuth2 제공자에 따른 사용자 ID

//    private List<Long> likedIssues;  사용자가 좋아요를 누른 이슈들 (Issue ID 목록)





}