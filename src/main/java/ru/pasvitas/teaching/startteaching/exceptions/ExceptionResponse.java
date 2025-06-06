package ru.pasvitas.teaching.startteaching.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@RequiredArgsConstructor
public class ExceptionResponse {

	private final String code;
	private final String message;

}
