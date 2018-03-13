package com.snilloc.springwebdemo;

import com.snilloc.springwebdemo.controllers.AuthorController;
import com.snilloc.springwebdemo.repositories.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringWebDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringWebDemoApplication.class, args);
		AuthorController authorController = (AuthorController) ctx.getBean("authorController");

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println("Found user: " + fakeDataSource.getUserName());

	}
}
