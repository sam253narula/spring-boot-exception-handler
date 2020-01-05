package com.springboot.rest.example.exceptionHandler;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.rest.example.exceptionDtos.ResponseErrorDto;
import com.springboot.rest.example.exceptionDtos.StudentNotFoundException;
import com.springboot.rest.example.exceptionDtos.StudentShouldExistInDatabaseException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class SpringBootStudentDataApplicationExceptionHandler {

	@ExceptionHandler(value = StudentNotFoundException.class)
	public ResponseErrorDto handleNotFoundException(StudentNotFoundException e) {
		ResponseErrorDto responseErrorDto = ResponseErrorDto.builder().code(HttpStatus.NOT_FOUND.value())
				.errorMessages(Collections.singletonList("Student with mentioned id is not found in Databaae")).build();
		log.debug("Not Found Response: {}", responseErrorDto);
		return responseErrorDto;
	}

	@ExceptionHandler(value = StudentShouldExistInDatabaseException.class)
	public ResponseErrorDto handleNotFoundException(StudentShouldExistInDatabaseException e) {
		ResponseErrorDto responseErrorDto = ResponseErrorDto.builder().code(HttpStatus.PRECONDITION_FAILED.value())
				.errorMessages(Collections.singletonList(e.getMessage())).build();
		log.debug("Pre Condition fialed Response: {}", responseErrorDto);
		return responseErrorDto;
	}
}
