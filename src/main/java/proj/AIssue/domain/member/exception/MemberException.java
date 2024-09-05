package proj.AIssue.domain.member.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import proj.AIssue.global.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public class MemberException extends RuntimeException {

    private final ErrorCode errorCode;
}
