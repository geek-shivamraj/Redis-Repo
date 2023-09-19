package com.redis.springboot.entity;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

/*
 * @RedisHash is mandatory here in order to communicate with redis repository.
 * {@link RedisHash} marks Objects as aggregate roots to be stored in a Redis hash.
 *  
 */

@Data
@RedisHash("Student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Integer id;
	String name;

}
