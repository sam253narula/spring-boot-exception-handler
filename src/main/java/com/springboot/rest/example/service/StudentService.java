package com.springboot.rest.example.service;

import java.util.List;

import com.springboot.rest.example.model.Student;

public interface StudentService {

	List<Student> getStudentList();

	Student insertStudent(Student student);

	void deleteStudent(Long id);

	Student updatestudent(Student student);

	Student getStudentById(Long id);
}
