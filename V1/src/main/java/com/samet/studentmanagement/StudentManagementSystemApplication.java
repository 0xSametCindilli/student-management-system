package com.samet.studentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =
				SpringApplication.run(StudentManagementSystemApplication.class, args);

		StudentMenu menu = context.getBean(StudentMenu.class);
		for (int i = 0; i < 100; i++) {System.out.println();} // Clear Screen
		menu.LoginMenu();

	}


}
