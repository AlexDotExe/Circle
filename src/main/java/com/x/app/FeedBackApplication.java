package com.x.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan("com.x")
@EnableJpaRepositories("com.x.repository")
@EntityScan("com.x.model")
public class FeedBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedBackApplication.class, args);
	}

}
