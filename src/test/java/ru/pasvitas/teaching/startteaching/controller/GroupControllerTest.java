package ru.pasvitas.teaching.startteaching.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import ru.pasvitas.teaching.startteaching.model.Group;
import ru.pasvitas.teaching.startteaching.repository.GroupRepository;

import static org.junit.jupiter.api.Assertions.*;

class GroupControllerTest {

	private GroupRepository groupRepository = Mockito.mock(GroupRepository.class);
	private GroupController groupController = new GroupController(groupRepository);

	@Test
	void test() {

		Mockito.when(groupRepository.save(new Group().setName("Name"))).thenReturn(new Group().setId(1L).setName("Name"));

		ResponseEntity<Group> expected = ResponseEntity.ok(new Group()
				.setId(1L)
				.setName("Name"));

		ResponseEntity<Group> actual = groupController.createGroup(new Group().setName("Name"));

		assertEquals(expected, actual);
	}

}