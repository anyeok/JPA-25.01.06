package com.ll.sb_25_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // @CreateDate, @LastModifiedDate를 사용하기 위해 필요
public class Sb2501Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb2501Application.class, args);
	}

}
