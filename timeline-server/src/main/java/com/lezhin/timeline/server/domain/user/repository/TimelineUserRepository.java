package com.lezhin.timeline.server.domain.user.repository;

import com.lezhin.timeline.server.domain.user.model.TimelineUser;
import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimelineUserRepository extends JpaRepository<TimelineUserEntity, Long> {

	TimelineUser findOneByLoginId(String loginId);

}
