package com.example.springbootstarter.student;


import com.example.springbootstarter.exceptions.ApiNotFoundException;
import com.example.springbootstarter.exceptions.ApiRequestException;
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

      try {
         return studentService.getStudents();
      } catch (ApiRequestException handleApiRequestException) {
         throw new ApiRequestException("Oeps... cannot find any students!");
      }
   }


   @GetMapping(path = "{studentId}")
   public Student getStudent(@PathVariable Long studentId) {

      try {
         return studentService.getStudent(studentId);

      } catch (ApiNotFoundException handleApiNotFoundException) {
         throw new ApiRequestException("Oeps... student with id " + studentId + " not found!");

      }
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
