package com.redis.springboot.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.redis.springboot.entity.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

}
 
