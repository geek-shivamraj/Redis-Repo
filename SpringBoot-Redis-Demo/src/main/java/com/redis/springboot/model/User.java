package com.redis.springboot.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
	private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private int age;
}
