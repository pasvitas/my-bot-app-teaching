package ru.pasvitas.teaching.startteaching.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.pasvitas.teaching.startteaching.exceptions.StudentNotFoundException;
import ru.pasvitas.teaching.startteaching.model.Student;
import ru.pasvitas.teaching.startteaching.repository.StudentsRepository;

@RequiredArgsConstructor
@Service
@Transactional(isolation = Isolation.READ_UNCOMMITTED, rollbackFor = Exception.class)
@Primary
@Slf4j
public class StudentsServiceImpl implements StudentsService {

	private final StudentsRepository studentsRepository;

	public Student addStudent(
			Student student) {
		return studentsRepository.save(student);
	}

	public List<Student> getAllStudents(
			String firstName,
			String secondName,
			int page,
			int size
	) {
		if (firstName == null || secondName == null) {
			List<Student> students = new ArrayList<>();
			studentsRepository.findAll(PageRequest.of(page, size).withSort(Sort.by(Sort.Order.asc("firstName")))).forEach(students::add);
			return students;
		} else {
			return studentsRepository.findByFirstNameAndSecondName(firstName, secondName, PageRequest.of(page, size).withSort(Sort.by(Sort.Order.asc("firstName"))));
		}
	}

	@Override
	public List<Student> getStudentByGroup(String groupName) {
		return studentsRepository.findStudentsByGroupName(groupName);
	}

	public Student getStudentById(Long id) {
		Optional<Student> student = studentsRepository.findById(id);
		if (student.isPresent()) {
			return student.get();
		} else {
			throw new StudentNotFoundException(id);
		}
	}

	public Student editStudent(
			Long id,
			Student student) {
		Optional<Student> studentFind = studentsRepository.findById(id);
		if (studentFind.isPresent()) {
			student.setId(id);
			log.info("Edit student with id {}: {}", id, student);
			return studentsRepository.save(student);
		} else {
			log.error("Student not found: {}", id);
			throw new StudentNotFoundException(id);
		}
	}

	public void deleteStudent(Long id) {
		throw new RuntimeException("This is error");
		//studentsRepository.deleteById(id);
	}

}
