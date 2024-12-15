package com.example.demo.Controllers;

import com.example.demo.Interface.ITaskService;
import com.example.demo.Models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final ITaskService _taskService;

    public TaskController(ITaskService taskService) {
        _taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = _taskService.GetAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        Task task = _taskService.GetTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task newTask = _taskService.AddTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskUpdate) {
        Task updatedTask = _taskService.UpdateTask(id, taskUpdate);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        _taskService.DeleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
