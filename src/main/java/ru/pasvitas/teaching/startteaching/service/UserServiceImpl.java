package ru.pasvitas.teaching.startteaching.service;

/*
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.pasvitas.teaching.startteaching.model.User;
import ru.pasvitas.teaching.startteaching.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional = userRepository.findByLogin(username);
		if (userOptional.isPresent()) {
			return userOptional.get();
		}
		else {
			throw new UsernameNotFoundException("User not found");
		}
	}
}
*/
