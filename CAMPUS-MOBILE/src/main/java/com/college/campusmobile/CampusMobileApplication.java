package com.college.campusmobile;

import javax.validation.metadata.MethodType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.description.modifier.MethodArguments;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
(basePackages="com.college.campusmobile , services, com.college.campusmobile.model,com.college.campusmobile.repository")
@EntityScan(basePackages = {"com.college.campusmobile.model"}) 	
@EnableJpaRepositories ("com.college.campusmobile.repository")
public class CampusMobileApplication  extends SpringBootServletInitializer{
	
	 @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	  return application.sources(CampusMobileApplication.class);
	  }

	public static void main(String[] args) {
		SpringApplication.run(CampusMobileApplication.class, args);
	}
}
