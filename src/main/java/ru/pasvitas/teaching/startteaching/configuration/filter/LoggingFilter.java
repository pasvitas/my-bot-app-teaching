package ru.pasvitas.teaching.startteaching.configuration.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@Component
public class LoggingFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String uuid = UUID.randomUUID().toString();
		log.info("Request {} {} {}", uuid, request.getMethod(), request.getRequestURI());
		long startTime = System.currentTimeMillis();

		filterChain.doFilter(request, response);

		long endTime = System.currentTimeMillis();
		log.info("Response {}, time: {}, status: {}", uuid, endTime - startTime, response.getStatus());
	}
}
