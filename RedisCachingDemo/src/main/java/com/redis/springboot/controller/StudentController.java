package com.redis.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.springboot.entity.Student;
import com.redis.springboot.repo.StudentRepo;
import com.redis.springboot.service.StudentService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/service")
public class StudentController {

  @Autowired
  StudentRepo studentRepo;

  @Autowired
  StudentService studentService;

  @GetMapping("/getallstudent")
  public List<Student> getAllStudent() {
    List<Student> actualList = new ArrayList<>();
    studentRepo.findAll().iterator().forEachRemaining(actualList::add);
    return actualList;
  }

  @PostMapping("/saveStudent")
  public Student saveStudentData(@RequestBody Student student) {

    studentRepo.save(student);
    return student;
  }

  @DeleteMapping("/deleteStudent/{id}")
  public void deleteStudent(@PathVariable("id") Integer id) {
    studentRepo.deleteById(id);
  }

  @GetMapping("/getStudentById/{id}")
  public Student getStudent(@PathVariable("id") Integer id) {
    return studentService.getStudentById(id);
  }

  @PostConstruct
  public void saveStudent() {
    Student student = new Student();
    student.setId(1);
    student.setName("Shivam");
    studentRepo.save(student);
  }
}
