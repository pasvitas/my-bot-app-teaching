package ru.pasvitas.teaching.startteaching.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TeachingApplicationException extends RuntimeException {

	private final String code;
	private final String message;
	private final String method;
	private final Exception originalException;
}
