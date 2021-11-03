package com.example.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootStarterApplication {

   public static void main(String[] args) {
      SpringApplication.run(SpringBootStarterApplication.class, args);
   }

}
