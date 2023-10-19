package com.basic.MySpringBoot.post.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "announcement")
public class AnnouncementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;       // 제목

    @Column(unique = true, nullable = false)
    private String content;     // 상세 내용

    @Column(unique = true, nullable = false)
    private String fileUrl;     // 이미지

    @Column(nullable = false)
    private String jobCategory; // 채용 직종

    @Column(nullable = false)
    private String minSalary ; // 최소 연봉

    @Column
    private String maxSalary ; // 최대 연봉

    @Column(nullable = false)
    private String experienceLevel ; // 경력 수준

    @Column(nullable = false)
    private String educationLevel; // 학력 요구사항

    @Column(nullable = false)
    private String contact; // 지원자가 연락할 수 있는 연락처 정보

    @Column(nullable = false)
    private LocalDateTime applicationDeadline ; // 지원 마감일

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now(); // 게시글 생성일

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedAt  = LocalDateTime.now(); // 게시글 업데이트 일

}