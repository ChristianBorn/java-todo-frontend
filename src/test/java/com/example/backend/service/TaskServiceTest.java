package com.example.backend.service;

import com.example.backend.model.Task;
import com.example.backend.model.TaskStatus;
import com.example.backend.repo.TaskRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    void addTask() throws JsonProcessingException {
        //GIVEN
        TaskRepo taskRepo = mock(TaskRepo.class);
        TaskService taskService = new TaskService(taskRepo);

        String taskToAddJSON = """
                            {"description": "s", "status": "OPEN"}
                            """;
        Task taskToAdd = new ObjectMapper().readValue(taskToAddJSON, Task.class);
        System.out.println(taskToAdd);



        //WHEN
        when(taskRepo.addTaskToRepo("1", taskToAdd)).thenReturn(taskToAdd);
        Task actual = taskService.addTask(taskToAddJSON);
        Task expected = taskToAdd;
        //Set id of expected task to the task that was saved, because addTask() sets a random UUID
        expected.setId(actual.getId());
        //THEN
        assertEquals(expected, actual);
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