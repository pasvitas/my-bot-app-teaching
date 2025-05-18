package ru.pasvitas.teaching.startteaching.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.pasvitas.teaching.startteaching.exceptions.StudentNotFoundException;
import ru.pasvitas.teaching.startteaching.exceptions.TeachingApplicationException;
import ru.pasvitas.teaching.startteaching.exceptions.ExceptionResponse;

@Slf4j
@ControllerAdvice
public class StudentsExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Void> handleStudentsNotFound(StudentNotFoundException exception) {
		//Log4j
		log.warn("Student not found: {}", exception.getId(), exception);
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(TeachingApplicationException.class)
	public ResponseEntity<ExceptionResponse> handleTeachingApplicationException(TeachingApplicationException exception) {
		log.error("Error on students: {}", exception.getMethod(), exception.getOriginalException());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ExceptionResponse(exception.getCode(), exception.getMessage()));
	}
}
