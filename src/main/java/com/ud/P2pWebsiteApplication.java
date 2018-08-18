package com.ud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.ud.base.controller")
@ComponentScan({"com.ud.base.service"})
@EnableJpaRepositories("com.ud.base.dao")
@MapperScan(basePackages="com.ud.base.mapper")
public class P2pWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(P2pWebsiteApplication.class, args);
	}
}
