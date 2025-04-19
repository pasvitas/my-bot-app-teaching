package ru.pasvitas.teaching.startteaching.exceptions;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ExceptionResponse {

	private Long code;
	private String message;

}
