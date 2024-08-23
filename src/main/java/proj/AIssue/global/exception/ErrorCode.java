package proj.AIssue.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

        /* 사용자 */
        ALREADY_EXIST_MEMBER(00, "이미 존재하는 사용자입니다."),
        NOT_FOUND_MEMBER(00, "사용자를 찾을 수 없습니다."),
        MISMATCH_PASSWORD(00, "비밀번호가 일치하지 않습니다."),
        OAUTH2_LOGIN_FAILED(00, "로그인에 실패했습니다."),
        OAUTH2_REGISTRATION_FAILED(00, "회원가입에 실패했습니다."),

        /* 이슈 관련 */
        NOT_FOUND_ISSUE(00, "이슈를 찾을 수 없습니다."),
        FAILED_TO_LOAD_ISSUES(00, "이슈들을 불러오는 데 실패했습니다."),
        ISSUE_ALREADY_REPORTED(00, "이미 신고된 이슈입니다."),
        INVALID_ISSUE_CATEGORY(00, "유효하지 않은 이슈 카테고리입니다."),

        /* 피드백 및 댓글 */
        COMMENT_NOT_FOUND(00, "댓글을 찾을 수 없습니다."),
        INVALID_COMMENT(00, "유효하지 않은 댓글입니다."),

        /* 좋아요, 싫어요, 스크랩 */
        LIKE_ALREADY_EXISTS(00, "이미 좋아요를 누른 상태입니다."),
        DISLIKE_ALREADY_EXISTS(00, "이미 싫어요를 누른 상태입니다."),
        SCRAP_ALREADY_EXISTS(00, "이미 스크랩한 상태입니다."),

        /* 보고서 */
        REPORT_SAVE_FAILED(00, "신고 저장에 실패했습니다."),
        REPORT_ALREADY_EXISTS(00, "이미 신고한 상태입니다."),

        /* 공용 */
        NOT_FOUND_ACCESS_TOKEN(00, "토큰을 찾을 수 없습니다."),
        EXPIRED_ACCESS_TOKEN(403, "토큰의 유효시간이 만료되었습니다."),
        INVALID_ACCESS_TOKEN(00, "유효하지 않은 토큰입니다.");

        private final int errorCode;
        private final String message;
}
