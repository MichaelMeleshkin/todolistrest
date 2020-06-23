package com.todolist.service;

import com.todolist.dao.TaskRepository;
import com.todolist.dao.UserRepository;
import com.todolist.dto.TaskDto;
import com.todolist.entity.Task;
import com.todolist.entity.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

	private final UserRepository userRepository;
	private final TaskRepository taskRepository;

	@Autowired
	private final ModelMapper modelMapper;

	@Autowired
	private final UserService userService;

	@Override
	public List<Task> findAll(HttpServletRequest req) {
		return userService.currentUser(req).getTasks();
	}

	@Override
	public Optional<Task> findById(Integer id) {
		return taskRepository.findById(id);
	}

	@Override
	public void save(TaskDto taskDto, HttpServletRequest req) {
		Task task = modelMapper.map(taskDto, Task.class);
		User user = userService.currentUser(req);
		user.getTasks().add(task);
		userRepository.save(user);
	}

	@Override
	public void update(TaskDto taskDto) {
		Optional<Task> taskOptional = findById(taskDto.getId());
		if (taskOptional.isPresent()) {
			Task task = taskOptional.get();
			modelMapper.map(taskDto, task);
			taskRepository.save(task);
		}
	}

	@Override
	public void deleteById(Integer id) {
		taskRepository.deleteById(id);
	}

}






