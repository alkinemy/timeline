package al.timeline.member.config;

import al.timeline.common.domain.base.TimelineCommons;
import al.timeline.member.domain.TimelineMemberDomains;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackageClasses = { TimelineCommons.class, TimelineMemberDomains.class })
@EntityScan(basePackageClasses = { TimelineMemberDomains.class, Jsr310JpaConverters.class })
@EnableTransactionManagement
@EnableJpaAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
@Configuration
public class JpaConfig {
}
