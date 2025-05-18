package ru.pasvitas.teaching.startteaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class StartTeachingApplication {

	/*

	Сделать базу данных студентов
	Frontend - сделает другой
	Backend - мы

	Студент
	- Имя
	- Фамилия
	- Группа

	Операции:
	- Просмотр всех студентов
	- Просомтр одного студента (конкретного)
	- Поиск по студентам (по Фамилии и группе)

	- Добавление
	- Изменение
	- Удаление

	 */


	public static void main(String[] args) {
		SpringApplication.run(StartTeachingApplication.class, args);
	}

}
