package proj.AIssue.domain.report.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import proj.AIssue.global.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public class ReportException extends RuntimeException {

    private final ErrorCode errorCode;
}
