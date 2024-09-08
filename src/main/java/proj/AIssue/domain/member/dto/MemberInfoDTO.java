package proj.AIssue.domain.member.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import proj.AIssue.domain.member.entity.Member;

@Data
@NoArgsConstructor
public class MemberInfoDTO {

    private String username;

    private String email;

    @Builder
    public MemberInfoDTO(Member member) {
        this.username = member.getUsername();
        this.email = member.getEmail();
    }
}
