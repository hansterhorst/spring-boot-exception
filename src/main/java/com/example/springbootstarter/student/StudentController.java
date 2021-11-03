package com.example.springbootstarter.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

   private final StudentService studentService;

   @Autowired
   public StudentController(StudentService studentService) {
      this.studentService = studentService;
   }


   @GetMapping
   public List<Student> getStudents() {
      return studentService.getStudents();
   }


   @GetMapping(path = "{studentId}")
   public Student getStudent(@PathVariable Long studentId) {

      System.out.println(studentService.getStudent(studentId));
      return studentService.getStudent(studentId);
   }


   @PostMapping
   public void addNewStudent(@RequestBody Student student) {
      studentService.addNewStudent(student);
   }


   @DeleteMapping(path = "{studentId}")
   public void deleteStudent(@PathVariable(value = "studentId") Long id) {
      studentService.deleteStudent(id);
   }


   @PutMapping(path = "{studentId}")
   public void updateStudent(
      @PathVariable(value = "studentId") Long studentId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String email) {
      studentService.updateStudent(studentId, name, email);
   }
}
