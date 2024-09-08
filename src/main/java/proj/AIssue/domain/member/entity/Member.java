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
    @Column(name = "member_id", unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Authority authority; // ADMIN, USER, SIGN_OUT

    private String provider;
    private String providerId;

    @Builder.Default
    private Boolean isDeleted = Boolean.FALSE;

    //== 회원 정보 수정 ==//
    public void updateUserName(String username) {

        this.username = username;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    //== 회원 가입 시에 USER 권한을 부여 ==//
    public void addUserAuthority() {
        this.authority = Authority.USER;
    }

    //    private List<Long> likedIssues;  사용자가 좋아요를 누른 이슈들 (Issue ID 목록)
}