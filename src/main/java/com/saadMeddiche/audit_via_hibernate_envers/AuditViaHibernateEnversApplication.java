package com.saadMeddiche.audit_via_hibernate_envers;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AuditViaHibernateEnversApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditViaHibernateEnversApplication.class, args);
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public AuditReader auditReader(EntityManagerFactory factory) {
		return AuditReaderFactory.get(factory.createEntityManager());
	}

}
