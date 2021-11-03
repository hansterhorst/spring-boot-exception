package com.example.springbootstarter.student;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

   @Id
   @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
   private Long id;
   private String name;
   private String email;

   @Transient// ignore the age table in database
   private int age;

   private LocalDate birtDate;

   public Student() {
   }

   public Student(Long id, String name, String email, LocalDate birtDate) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.birtDate = birtDate;
   }

   public Student(String name, String email, LocalDate birtDate) {
      this.name = name;
      this.email = email;
      this.birtDate = birtDate;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Integer getAge() {
      //calculate the age from birtDate and current date
      return Period.between(this.birtDate, LocalDate.now()).getYears();
   }

   public void setAge(Integer age) {
      this.age = age;
   }

   public LocalDate getBirtDate() {
      return birtDate;
   }

   public void setBirtDate(LocalDate birtDate) {
      this.birtDate = birtDate;
   }

   @Override
   public String toString() {
      return "Student{" +
         "id=" + id +
         ", name='" + name + '\'' +
         ", email='" + email + '\'' +
         ", birtDate=" + birtDate +
         '}';
   }
}
