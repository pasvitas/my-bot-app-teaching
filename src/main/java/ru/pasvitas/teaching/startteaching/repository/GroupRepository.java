package ru.pasvitas.teaching.startteaching.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pasvitas.teaching.startteaching.model.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
