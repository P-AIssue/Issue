package proj.AIssue.domain.comment.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import proj.AIssue.global.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public class CommentException extends RuntimeException {

    private final ErrorCode errorCode;
}
