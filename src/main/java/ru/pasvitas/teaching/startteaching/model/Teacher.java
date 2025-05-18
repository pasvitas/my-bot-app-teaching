package ru.pasvitas.teaching.startteaching.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_id_seq")
	@SequenceGenerator(sequenceName = "teacher_id_seq", name = "teacher_id_seq", allocationSize = 1)
	private Long id;

	@Column(name = "name")
	private String name;

}
