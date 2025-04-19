package ru.pasvitas.teaching.startteaching.exceptions;

import lombok.Getter;

@Getter
public class StudentNotFoundException extends RuntimeException {

    private final Long id;

	public StudentNotFoundException(Long id) {
      super("Student not found: " + id);
      this.id = id;
	}
}
