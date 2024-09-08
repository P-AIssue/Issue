package proj.AIssue.domain.member.dto;

import lombok.Getter;

import java.util.Optional;

public record MemberUpdateDTO(
        Optional<String> username,
        Optional<String> email
) {}
