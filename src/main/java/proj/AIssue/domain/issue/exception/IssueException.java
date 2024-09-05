package proj.AIssue.domain.issue.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import proj.AIssue.global.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public class IssueException extends RuntimeException {

    private final ErrorCode errorCode;
}
