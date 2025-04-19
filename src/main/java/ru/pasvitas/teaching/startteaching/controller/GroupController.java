package ru.pasvitas.teaching.startteaching.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pasvitas.teaching.startteaching.model.Group;
import ru.pasvitas.teaching.startteaching.repository.GroupRepository;

@RequestMapping("/api/groups")
@RequiredArgsConstructor
@RestController
public class GroupController {

	private final GroupRepository groupRepository;

	@PostMapping
	public ResponseEntity<Group> createGroup(
			@RequestBody Group group) {
		return ResponseEntity.ok(groupRepository.save(group));
	}

	@GetMapping
	public ResponseEntity<List<Group>> getAllGroups() {
		List<Group> groups = new ArrayList<>();
		groupRepository.findAll().forEach(groups::add);
		return ResponseEntity.ok(groups);
	}

}
