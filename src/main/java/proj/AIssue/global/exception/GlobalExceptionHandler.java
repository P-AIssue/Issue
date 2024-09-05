package proj.AIssue.global.exception;

import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import proj.AIssue.domain.comment.exception.CommentException;
import proj.AIssue.domain.feedback.exception.FeedbackException;
import proj.AIssue.domain.issue.exception.IssueException;
import proj.AIssue.domain.member.exception.MemberException;
import proj.AIssue.domain.report.exception.ReportException;
import proj.AIssue.global.exception.dto.ErrorResponseVO;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CommentException.class)
    public ErrorResponseVO handleCommentException(CommentException e) {
        ErrorCode errorCode = e.getErrorCode();

        return getErrorResponse(errorCode);
    }

    @ExceptionHandler(FeedbackException.class)
    public ErrorResponseVO handleFeedbackException(FeedbackException e) {
        ErrorCode errorCode = e.getErrorCode();

        return getErrorResponse(errorCode);
    }

    @ExceptionHandler(IssueException.class)
    public ErrorResponseVO handleIssueException(IssueException e) {
        ErrorCode errorCode = e.getErrorCode();

        return getErrorResponse(errorCode);
    }

    @ExceptionHandler(MemberException.class)
    public ErrorResponseVO handleMemberException(MemberException e) {
        ErrorCode errorCode = e.getErrorCode();

        return getErrorResponse(errorCode);
    }

    @ExceptionHandler(ReportException.class)
    public ErrorResponseVO handleReportException(ReportException e) {
        ErrorCode errorCode = e.getErrorCode();

        return getErrorResponse(errorCode);
    }

    @ResponseStatus(org.springframework.http.HttpStatus.FORBIDDEN)
    @ExceptionHandler(TokenExpiredException.class)
    public ErrorResponseVO handleTokenExpiredException(TokenExpiredException ex) {
        return ErrorResponseVO.builder()
                .name(ErrorCode.EXPIRED_ACCESS_TOKEN.name())
                .errorCode(ErrorCode.EXPIRED_ACCESS_TOKEN.getErrorCode())
                .message(ErrorCode.EXPIRED_ACCESS_TOKEN.getMessage()).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseVO handleValidationException(MethodArgumentNotValidException ex) {
        return ErrorResponseVO.builder()
                .name("VALIDATION_ERROR")
                .errorCode(ex.getStatusCode().value())
                .message(Objects.requireNonNull(ex.getFieldError()).getDefaultMessage()).build();
    }

    private ErrorResponseVO getErrorResponse(ErrorCode errorCode) {
        return ErrorResponseVO.builder()
                .name(errorCode.name())
                .errorCode(errorCode.getErrorCode())
                .message(errorCode.getMessage()).build();
    }
}
