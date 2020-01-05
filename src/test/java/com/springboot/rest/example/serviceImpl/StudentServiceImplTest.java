package com.springboot.rest.example.serviceImpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.springboot.rest.example.model.Student;
import com.springboot.rest.example.repository.StudentRepository;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

	@Mock
	StudentRepository studentRepository;

	@InjectMocks
	StudentServiceImpl studentServiceImpl;

	@Test
	public void testgetStudentList() {
		when(studentRepository.findAll()).thenReturn(Arrays.asList(new Student(1005L, "TestName", "PQRSTSDF345")));

		List<Student> studentList = studentServiceImpl.getStudentList();

		System.out.println(studentList);
		assertTrue("Student list should not be zero", studentList.size() > 0);
	}

	// doNothing().when(studentRepository.save(new Student()));

	@Test
	public void testinsertStudent() {
		when(studentRepository.save(mock(Student.class))).thenReturn(new Student(1005L, "TestName", "PQRSTSDF345"));
		Student student = studentServiceImpl.insertStudent(new Student(1005L, "TestName", "PQRSTSDF345"));
		assertNotNull("Student list should not be zero", student != null);
	}

	@Test
	public void testdeleteStudent() {
		doNothing().when(studentRepository).delete(1L);
		studentServiceImpl.deleteStudent(1L);
	}

	@Test
	public void testupdatestudent() {
		Student student = new Student(1005L, "TestName", "PQRSTSDF345");

		when(studentRepository.saveAndFlush(student)).thenReturn(student);

		Student result = studentServiceImpl.updatestudent(student);

		// assertEquals(student.getId(), result.getId());

	}
}
