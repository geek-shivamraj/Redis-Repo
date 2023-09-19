package com.redis.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.redis.springboot.entity.Student;
import com.redis.springboot.repo.StudentRepo;

@Service
public class StudentService {

  @Autowired
  StudentRepo studentRepo;

  @Cacheable(value = "studentCache")
  public Student getStudentById(Integer id) {
    System.out.println("Calling repo for student");
    return studentRepo.findById(id).orElse(null);
  }

}
