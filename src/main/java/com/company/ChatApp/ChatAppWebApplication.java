package com.company.ChatApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.company"})
public class ChatAppWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatAppWebApplication.class, args);
	}

}
