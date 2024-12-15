package com.example.demo.Services;

import com.example.demo.Interface.ITaskService;
import com.example.demo.Models.Task;
import com.example.demo.Repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    private final TaskRepository _taskRepository;

    public TaskService(TaskRepository taskRepository) {
        _taskRepository = taskRepository;
    }

    @Override
    public List<Task> GetAllTasks() {
        return _taskRepository.findAll();
    }

    @Override
    public Task GetTaskById(Long Id) {
        return _taskRepository.findById(Id).orElseThrow();
    }

    @Override
    public Task AddTask(Task task) {
        return  _taskRepository.save(task);
    }

    @Override
    public Task UpdateTask(Long Id, Task taskUpdate) {
        Task task = _taskRepository.findById(Id).orElseThrow();
        task.setTitle(taskUpdate.getTitle());
        task.setDescription(taskUpdate.getDescription());
        task.setDate(taskUpdate.getDate());
        task.setState(taskUpdate.getState());
        return  _taskRepository.save(task);
    }

    @Override
    public Task DeleteTask(Long Id) {
        Task task = _taskRepository.findById(Id).orElseThrow();
        _taskRepository.delete(task);
        return task;
    }
}
