package ru.pasvitas.teaching.startteaching.configuration;

/*
import jakarta.servlet.DispatcherType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		log.info("Password user1: {}", encoder.encode("User1"));
		log.info("Password Admin: {}", encoder.encode("Admin"));
		return encoder;
	}

	@Primary
	@Bean
	public PasswordEncoder passwordEncoderSimple() {
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return encodedPassword.equals(rawPassword.toString());
			}
		};
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(
						request ->
								request
										.requestMatchers("/api/groups/**").hasAuthority("Admin")
										.requestMatchers(HttpMethod.GET, "/api/students").hasAnyAuthority("Student", "Admin")
										.requestMatchers("/api/students/**").hasAuthority("Admin")
										.requestMatchers("/error").permitAll()
										.requestMatchers("/login").permitAll()

				)
				.formLogin(Customizer.withDefaults())
				.logout(LogoutConfigurer::permitAll)
				.csrf(CsrfConfigurer::disable)
				.build();
	}

}
*/
