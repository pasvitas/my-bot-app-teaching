package ru.pasvitas.teaching.startteaching.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.pasvitas.teaching.startteaching.model.Student;

@Qualifier("studentsLocal")
@Service
public class StudentServiceListImpl implements StudentsService {

	private List<Student> students = new ArrayList<>();

	@Override
	public Student addStudent(Student student) {
		students.add(student);
		return student;
	}

	@Override
	public List<Student> getAllStudents(String firstName, String secondName) {
		return students;
	}

	@Override
	public Student getStudentById(Long id) {
		return students.get(id.intValue());
	}

	@Override
	public Student editStudent(Long id, Student student) {
		students.remove(id.intValue());
		students.add(id.intValue(), student);
		return student;
	}

	@Override
	public void deleteStudent(Long id) {
		students.remove(id.intValue());
	}
}
