package com.example.backend.service;

import com.example.backend.model.Task;
import com.example.backend.model.TaskStatus;
import com.example.backend.repo.TaskRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskService {
    private TaskRepo savedTasks = new TaskRepo();

    public boolean addTask(String body) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Task task = objectMapper.readValue(body, Task.class);

        task.setId(UUID.randomUUID().toString());
        return savedTasks.addTasktoRepo(task);
    }

    public List<Task> getAllTasks() {
        return savedTasks.getAllTasksfromRepo();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return savedTasks.getAllTasksfromRepo().stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}
