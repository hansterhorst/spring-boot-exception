package com.example.springbootstarter.student;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {


   private final StudentRepository studentRepository;


   public StudentService(StudentRepository studentRepository) {
      this.studentRepository = studentRepository;
   }


   @Transactional
   public List<Student> getStudents() {
      return studentRepository.findAll();
   }


   public Student getStudent(Long studentId) {

      boolean studentExists = studentRepository.existsById(studentId);
      if (!studentExists) {
         throw new IllegalStateException("Student with id " + studentId + " does not exists!");
      }

      System.out.println(studentRepository.findStudentById(studentId));
      return studentRepository.findStudentById(studentId);
   }


   public void addNewStudent(Student student) {

      System.out.println(student);

      Optional<Student> studentOptionalEmail = studentRepository.findStudentByEmail(student.getEmail());

      if (studentOptionalEmail.isPresent()) {
         throw new IllegalStateException("Email already taken!");
      }

      studentRepository.save(student);
   }

   public void deleteStudent(Long studentId) {

      boolean studentExists = studentRepository.existsById(studentId);

      if (!studentExists) {
         throw new IllegalStateException("Student with id " + studentId + " does not exists!");
      }

      studentRepository.deleteById(studentId);

   }

   @Transactional
   public void updateStudent(Long studentId, String name, String email) {

      System.out.println(studentId + name + email);

      Student student = studentRepository.findById(studentId).orElseThrow(() ->
         new IllegalStateException("Student with id " + studentId + " does not exists!"));


      if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
         System.out.println(name);
         student.setName(name);
      }

      if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {

         Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
         if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already taken!");
         }
         System.out.println(email);
         student.setEmail(email);
      }
      System.out.println(student);
   }
}
