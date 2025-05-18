package ru.pasvitas.teaching.startteaching.service;

import java.util.List;
import ru.pasvitas.teaching.startteaching.model.Student;

public interface StudentsService {

	Student addStudent(Student student);

	public List<Student> getAllStudents(
			String firstName,
			String secondName,
			int page,
			int size
	);

	List<Student> getStudentByGroup(String groupName);

	public Student getStudentById(Long id);

	public Student editStudent(
			Long id,
			Student student);

	public void deleteStudent(Long id);
}
