package com.example.springbootstarter.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

   @Bean
   CommandLineRunner commandLineRunner(StudentRepository studentRepository) {

      return args -> {
         Student hans = new Student(
            "Hans",
            "hans@mail.com",
            LocalDate.of(2002, 9, 21)
         );
         Student marc = new Student(
            "Marc",
            "marc@mail.com",
            LocalDate.of(2004, 6, 2)
         );

         studentRepository.saveAll(List.of(hans, marc));
      };

   }
}

