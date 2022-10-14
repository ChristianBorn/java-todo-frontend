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

    public Task addTask(String body) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Task task = objectMapper.readValue(body, Task.class);

        task.setId(UUID.randomUUID().toString());
        savedTasks.addTaskToRepo(task.getId(), task);
        return task;
    }

    public List<Task> getAllTasks() {
        return savedTasks.getAllTasksfromRepo().values().stream().toList();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return savedTasks.getAllTasksfromRepo().values().stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }


    public Task updateTask(String id, String body) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Task updatedTask = objectMapper.readValue(body, Task.class);
        Task taskToUpdate = savedTasks.getSpecificTask(id);

        if(!updatedTask.equals(taskToUpdate)) {
            return savedTasks.updateTaskAttributes(updatedTask, id);
        }

        return null;

    }

    //TODO Exception Handling in case id does not exist
    public Task deleteTask(String id) {
        return savedTasks.deleteTask(id);
    }

    public Task getTaskById(String id) {
        return savedTasks.getSpecificTask(id);
    }
}
