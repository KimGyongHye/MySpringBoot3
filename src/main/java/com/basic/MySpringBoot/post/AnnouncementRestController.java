package com.basic.MySpringBoot.post;


import com.basic.MySpringBoot.post.entity.AnnouncementEntity;
import com.basic.MySpringBoot.post.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/announcement")
public class AnnouncementRestController {
    @Autowired
    AnnouncementRepository announcementRepository;


    @GetMapping
    public List<AnnouncementEntity> getAnnouncements() {
        return announcementRepository.findAll();
    }

//    @PostMapping
//    public List<AnnouncementEntity> createAnnouncement(@RequestParam("title") String title,
//                                                       @RequestParam("content") String content,
//                                                       @RequestParam("companyLogo") MultipartFile companyLogo,
//                                                       @RequestParam("jobCategory") String jobCategory,
//                                                       @RequestParam("minSalary") String minSalary,
//                                                       @RequestParam("maxSalary") String maxSalary,
//                                                       @RequestParam("experienceLevel") String experienceLevel,
//                                                       @RequestParam("educationLevel") String educationLevel,
//                                                       @RequestParam("contact") String contact,
//                                                       @RequestParam("applicationDeadline") LocalDateTime applicationDeadline) {
//
//        AnnouncementEntity announcement = null;
//        try {
//            announcement = AnnouncementEntity.builder()
//                    .title(title)
//                    .content(content)
//                    .fileUrl(fileUploadService.uploadFile(companyLogo)) // 파일 업로드 처리
//                    .jobCategory(jobCategory)
//                    .minSalary(minSalary)
//                    .maxSalary(maxSalary)
//                    .experienceLevel(experienceLevel)
//                    .educationLevel(educationLevel)
//                    .contact(contact)
//                    .applicationDeadline(applicationDeadline)
//                    .build();
//            announcementRepository.save(announcement);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return announcementRepository.findAll();
//    }
}
