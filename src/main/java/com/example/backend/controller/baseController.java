package com.example.backend.controller;

import com.example.backend.service.TaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public abstract class baseController {
    TaskService applicationService = new TaskService();
}
