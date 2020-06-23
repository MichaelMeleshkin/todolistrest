package com.todolist.controller;

import com.todolist.dto.TaskDto;
import com.todolist.entity.Task;
import com.todolist.service.TaskService;
import com.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TaskController {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;

	@GetMapping("/tasks")
	public List<Task> findAll(HttpServletRequest req) {
		return userService.currentUser(req).getTasks();
	}

	@GetMapping("/task/{taskId}")
	public Optional<Task> getTask(@PathVariable Integer taskId) {
		return taskService.findById(taskId);
	}

	@PostMapping("/task")
	public void getTask(@RequestBody TaskDto taskDto, HttpServletRequest req) {
		taskService.save(taskDto, req);
	}

	@PutMapping("/task")
	public void updateTask(@RequestBody TaskDto taskDto) {
		taskService.update(taskDto);
	}

	@DeleteMapping("/task/{taskId}")
	public void deleteTask(@PathVariable Integer taskId) {
		taskService.deleteById(taskId);
	}
}










