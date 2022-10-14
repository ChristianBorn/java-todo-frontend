package com.example.backend.service;

import com.example.backend.model.Task;
import com.example.backend.model.TaskStatus;
import com.example.backend.repo.TaskRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TaskServiceTest {

    @Test
    void addTask() {
        //GIVEN
        //WHEN
        //THEN
    }

    @Test
    void getAllTasks() {
        //GIVEN
        TaskRepo taskRepo = mock(TaskRepo.class);
        TaskService taskService = new TaskService(taskRepo);
        Task newTask = new Task(UUID.randomUUID().toString(), "Test", TaskStatus.OPEN);

        //WHEN
        when(taskRepo.getAllTasksfromRepo()).thenReturn(Map.of(newTask.getId(), newTask));
        List<Task> actual = taskService.getAllTasks();
        List<Task> expected = List.of(newTask);
        //Then
        assertEquals(expected, actual);

    }

    @Test
    void getTasksByStatus() {
        //GIVEN
        //WHEN
        //Then
    }
}