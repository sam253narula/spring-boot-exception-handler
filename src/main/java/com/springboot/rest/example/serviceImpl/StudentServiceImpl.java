package com.springboot.rest.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.example.exceptionDtos.StudentNotFoundException;
import com.springboot.rest.example.model.Student;
import com.springboot.rest.example.repository.StudentRepository;
import com.springboot.rest.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getStudentList() {
		return studentRepository.findAll();
	}

	@Override
	public Student insertStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.delete(id);
	}

	@Override
	public Student updatestudent(Student student) {
		return studentRepository.saveAndFlush(student);
	}

	public Student getStudentById(Long id) throws StudentNotFoundException {
		return studentRepository.findStuudentById(id);
	}
}
