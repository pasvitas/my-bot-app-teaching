package ru.pasvitas.teaching.startteaching.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.pasvitas.teaching.startteaching.exceptions.StudentNotFoundException;

@Slf4j
@ControllerAdvice
public class StudentsExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Void> handleStudentsNotFound(StudentNotFoundException exception) {
		//Log4j
		log.warn("Student not found: {}", exception.getId(), exception);
		return ResponseEntity.notFound().build();
	}

}
