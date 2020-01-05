package com.springboot.rest.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.example.exceptionDtos.StudentNotFoundException;
import com.springboot.rest.example.exceptionDtos.StudentShouldExistInDatabaseException;
import com.springboot.rest.example.model.Student;
import com.springboot.rest.example.service.StudentService;

@RestController
@RequestMapping("/home/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/getAllStudents")
	public List<Student> add() {
		List<Student> studentList = studentService.getStudentList();

		return studentList;
	}

	@GetMapping("/studentById/{id}")
	public Student getStudentById(@PathVariable Long id) {

		Student st = studentService.getStudentById(id);
		if (st == null) {
			throw new StudentNotFoundException();
		} else {
			return st;
		}

	}

	@PostMapping("/postStudent")
	Student newStudent(@RequestBody Student newStudent) {
		return studentService.insertStudent(newStudent);
	}

	@DeleteMapping("/deletetStudent/{id}")
	void newStudent(@PathVariable Long id) {
		Student st = studentService.getStudentById(id);
		if (st == null) {
			throw new StudentShouldExistInDatabaseException(
					"Student with mentioned id " + id + " should be present in database in order to delete it.");
		} else {
			studentService.deleteStudent(id);
		}
	}

	@PostMapping("/updateStudent")
	Student updateStudent(@RequestBody Student newStudent) {
		return studentService.updatestudent(newStudent);
	}

}
