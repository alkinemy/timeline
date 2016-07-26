package com.lezhin.timeline.server.domain.user.repository;

import com.lezhin.timeline.server.domain.user.model.TimelineUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimelineUserRepository extends JpaRepository<TimelineUser, Long> {
}
