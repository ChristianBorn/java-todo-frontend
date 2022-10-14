package com.example.backend.controller;

import com.example.backend.model.Task;
import com.example.backend.service.TaskService;
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
    public boolean addNewTask(@RequestBody String body) {
        try {
            return super.applicationService.addTask(body);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
