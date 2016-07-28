package com.lezhin.timeline.server.domain.message.repository;

import com.lezhin.timeline.server.domain.base.repository.TimelineJpaRepository;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimelineMessageRepository extends TimelineJpaRepository<TimelineMessageEntity, Long>, TimelineMessageCustomRepository {

	List<TimelineMessageEntity> findAllByAuthorLoginId(String authorLoginId);

	Optional<TimelineMessageEntity> findOneByMessageId(String messageId);

}
