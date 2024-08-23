package proj.AIssue.domain.feedback.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import proj.AIssue.global.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public class FeedbackException extends RuntimeException{

    private final ErrorCode errorCode;
}
