package proj.AIssue.domain.issue.dto;

import proj.AIssue.domain.issue.entity.Issue;


public record IssueDTO(
        String title, //뉴스 기사 제목
        String sourceUrl, // 기사의 URL
        String description //기사 내용
)
{
    public Issue toEntity() {
        return Issue.builder()
                .title(title)
                .sourceUrl(sourceUrl)
                .description(description)
                .build();
    }
}
