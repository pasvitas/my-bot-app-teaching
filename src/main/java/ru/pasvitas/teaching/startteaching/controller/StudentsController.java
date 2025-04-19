package ru.pasvitas.teaching.startteaching.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.pasvitas.teaching.startteaching.model.Student;
import ru.pasvitas.teaching.startteaching.service.StudentsService;

@RequestMapping("/api/students")
@RestController
public class StudentsController {

	/*
		localhost:8080/api/students

		Базовый путь: /api/students


		REST-API

		1. Глагол.
		- GET - Получить информацию
		- POST - Добавить информацию
		- PUT - Изменить/Заменить(полностью) информацию
		- DELETE - Удалить информацию
		- PATCH - Изменить часть информации
		2. Путь.
		- /api/students - данные по всем студентам
		- GET /api/students - Получили все данные
		- GET /api/students/{id} - Получили данные по студенту с id
		- POST /api/students - Добавить данные о студенте
		- PUT/PATCH /api/students/{id} - Изменили данные по студенту с id
		- DELETE /api/students/{id} - Удалили информацию по студенту с id
		3. Query-параметры
		- GET /api/students - фильтровать по фамилии, поиск по фамилии.
		/api/students?secondName={secondName}&firstName={firstName} - поиск по фамилии и имени
		4. Headers - Заголовки, авторизации или для системных данных
		5. Body - Тело - student.json

			 200 - Все ок
			 201 - Создано
			 400 - Ошибка в запросе, Bad Request
			 401 - Требуется авторизация
			 403 - Не хватает доступов
			 404 - Не найдено
			 500 - внутреняя ошибка сервера
			 504 - Gateway timeout
			 */

	public StudentsController(
			@Autowired StudentsService studentsService,
			@Autowired @Qualifier("studentsLocal") StudentsService studentsServiceLocal) {
		this.studentsService = studentsService;

		this.studentsServiceLocal = studentsServiceLocal;
	}

	private final StudentsService studentsService;

	private final StudentsService studentsServiceLocal;

	@PostMapping
	public ResponseEntity<Student> addStudent(
			@RequestBody Student student) {
		studentsServiceLocal.addStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentsService.addStudent(student));
	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "secondName", required = false) String secondName
	) {
		return ResponseEntity.ok(studentsService.getAllStudents(firstName, secondName));
	}

	//students/5
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(studentsService.getStudentById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> editStudent(
			@PathVariable("id") Long id,
			@RequestBody Student student) {

		return ResponseEntity.ok(studentsService.editStudent(id, student));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
		studentsService.deleteStudent(id);
		return ResponseEntity.ok().build();
	}

}
