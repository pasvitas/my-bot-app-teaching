package ru.pasvitas.teaching.startteaching.configuration.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Order(1)
@Component
public class DevFilter extends OncePerRequestFilter {

	private static final String DEV_HEADER_NAME = "Dev";
	private static final String DEV_HEADER_VALUE = "I dev";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		if (request.getHeader(DEV_HEADER_NAME) != null && request.getHeader(DEV_HEADER_NAME).equals(DEV_HEADER_VALUE)) {
			filterChain.doFilter(request, response);
		}
		else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}
}
