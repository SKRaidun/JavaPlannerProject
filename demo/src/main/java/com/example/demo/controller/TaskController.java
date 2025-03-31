package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public Iterable<Task> getTask() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskOnId(@PathVariable("id") Long taskId) {
        return taskRepository.findById(taskId).orElseThrow(EntityNotFoundException::new);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTaskStatusOnId(@PathVariable("id") Long taskId, @RequestBody Task task) {
        task.setId(taskId);
        return taskRepository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTaskOnId(@PathVariable("id") Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @PatchMapping("/tasks/{id}")
    public void patchMethod(@PathVariable("id") Long taskId, @RequestBody Task task) {
        taskRepository.setStatusDoneOnId(taskId, task.isDone());
    }

    @PatchMapping("/tasks/{id}/{done}")
    public void patchMethod(@PathVariable("id") Long taskId, @PathVariable("done") boolean status) {
        taskRepository.setStatusDoneOnId(taskId, status);
    }

}
