package com.yash.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.synechron.*")
public class EmployeeDbh2RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDbh2RestApplication.class, args);
	}

}
