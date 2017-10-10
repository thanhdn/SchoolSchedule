package com.tlsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan( basePackages = {"com.tlsoft.entities"} )
//@FiScan (basePackages = {"com.tlsoft.filter"})
public class SchoolScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolScheduleApplication.class, args);
	}
}
