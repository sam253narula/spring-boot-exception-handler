package com.springboot.rest.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {

	private String name;
	private String passportNumber;
	@Id
	@GeneratedValue
	private Long id;
	public Student() {
	}
	public Student(Long id, String name, String passportNumber) {
		super();
		this.id = id;
		this.name = name;
		this.passportNumber = passportNumber;
	}


}
