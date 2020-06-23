package com.todolist.service;

import com.todolist.dto.TaskDto;
import com.todolist.entity.Task;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface TaskService {

	public List<Task> findAll(HttpServletRequest req);

	public Optional<Task> findById(Integer id);

	public void update(TaskDto taskDto);
	
	public void save(TaskDto userDto, HttpServletRequest req);
	
	public void deleteById(Integer id);
	
}
