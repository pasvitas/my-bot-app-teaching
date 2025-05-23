package ru.pasvitas.teaching.startteaching.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity(name = "groups")
@Table(name = "groups")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_id_seq")
	@SequenceGenerator(sequenceName = "groups_id_seq", name = "groups_id_seq", initialValue = 1, allocationSize = 1)
	private Long id;

	private String name;

	@OneToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
}
