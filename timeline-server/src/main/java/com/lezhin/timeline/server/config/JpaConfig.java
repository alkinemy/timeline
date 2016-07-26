package com.lezhin.timeline.server.config;

import com.lezhin.timeline.server.domain.TimelineServerDomains;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackageClasses = { TimelineServerDomains.class })
@EntityScan(basePackageClasses = { TimelineServerDomains.class, Jsr310JpaConverters.class })
@EnableTransactionManagement
@EnableJpaAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
@Configuration
public class JpaConfig {
}
