package com.basic.MySpringBoot.post;

import com.basic.MySpringBoot.post.entity.AnnouncementEntity;
import com.basic.MySpringBoot.post.repository.AnnouncementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @GetMapping("/add")
    public String showAnnouncementForm(Model model) {
        model.addAttribute("announcement", new AnnouncementEntity());
        return "add-announcement"; // 이 템플릿은 타임리프로 만듭니다.
    }

    @PostMapping("/add")
    public String addAnnouncement(AnnouncementEntity announcement) {
        announcementRepository.save(announcement);
        return "redirect:/announcements/add";
    }
}
