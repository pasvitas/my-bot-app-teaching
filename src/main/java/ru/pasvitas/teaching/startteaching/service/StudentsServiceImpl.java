package ru.pasvitas.teaching.startteaching.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.pasvitas.teaching.startteaching.exceptions.StudentNotFoundException;
import ru.pasvitas.teaching.startteaching.model.Student;
import ru.pasvitas.teaching.startteaching.repository.StudentsRepository;

@RequiredArgsConstructor
@Service
@Primary
public class StudentsServiceImpl implements StudentsService {

	private final StudentsRepository studentsRepository;

	public Student addStudent(
			Student student) {
		return studentsRepository.save(student);
	}

	public List<Student> getAllStudents(
			String firstName,
			String secondName
	) {
		if (firstName == null || secondName == null) {
			List<Student> students = new ArrayList<>();
			studentsRepository.findAll().forEach(students::add);
			return students;
		}
		else {
			return studentsRepository.findByFirstNameAndSecondName(firstName, secondName);
		}
	}

	public Student getStudentById(Long id) {
		Optional<Student> student = studentsRepository.findById(id);
		if (student.isPresent()) {
			return student.get();
		}
		else {
			throw new StudentNotFoundException(id);
		}
	}

	public Student editStudent(
			Long id,
			Student student) {
		Optional<Student> studentFind = studentsRepository.findById(id);
		if (studentFind.isPresent()) {
			student.setId(id);
			return studentsRepository.save(student);
		}
		else {
			throw new StudentNotFoundException(id);
		}
	}

	public void deleteStudent(Long id) {
		studentsRepository.deleteById(id);
	}

}
