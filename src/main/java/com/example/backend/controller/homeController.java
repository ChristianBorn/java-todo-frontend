package com.example.backend.controller;

import com.example.backend.model.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class homeController extends baseController {


    @GetMapping
    public List<Task> getAllTasks() {
        return super.applicationService.getAllTasks();
    }

    @PostMapping
    public Task addNewTask(@RequestBody String body) {
        try {
            return super.applicationService.addTask(body);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/{id}")
    public Task updateTask (@PathVariable String id, @RequestBody String body) {
        try {
            return applicationService.updateTask(id, body);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping("/{id}")
    public Task deleteTask (@PathVariable String id) {
        return applicationService.deleteTask(id);
    }

    @GetMapping("/{id}")
    public Task getSpecificTask (@PathVariable String id) {
        return applicationService.getTaskById(id);
    }

}
