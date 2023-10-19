package com.basic.MySpringBoot.post.repository;

import com.basic.MySpringBoot.post.entity.AnnouncementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, Long> {
    // 추가적인 메소드가 필요하면 여기에 정의
}
