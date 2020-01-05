package com.springboot.rest.example.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	private String EMP_Name;
	private String EMP_Skill;
	private Date EMP_DOJ;
}

