package ru.pasvitas.teaching.startteaching.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.pasvitas.teaching.startteaching.model.Student;

@Repository
public interface StudentsRepository extends CrudRepository<Student, Long>, PagingAndSortingRepository<Student, Long> {

	List<Student> findByFirstNameAndSecondName(String firstName, String secondName);
	List<Student> findStudentsByGroupName(String groupName);
	List<Student> findByFirstNameAndSecondName(String firstName, String secondName, Pageable pageable);
}
