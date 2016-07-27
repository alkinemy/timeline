package com.lezhin.timeline.server.domain.message.repository;

import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimelineMessageRepository extends JpaRepository<TimelineMessageEntity, Long> {
}
