package com.example.demo.Interface;

import com.example.demo.Models.Task;

import java.util.List;

public interface ITaskService {
    List<Task> GetAllTasks();
    Task GetTaskById(Long Id);
    Task AddTask(Task taskCreate);
    Task UpdateTask(Long Id, Task taskUpdate);
    Task DeleteTask(Long Id);
}
