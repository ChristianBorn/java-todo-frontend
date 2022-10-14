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
        return savedTasks.addTasktoRepo(task.getId(), task);
    }

    public List<Task> getAllTasks() {
        return savedTasks.getAllTasksfromRepo().values().stream().toList();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return savedTasks.getAllTasksfromRepo().values().stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }


    public Task advanceTask(String id) {
        TaskStatus status = savedTasks.getSpecificTask(id).getStatus();
        switch (status) {
            case OPEN: status = TaskStatus.IN_PROGRESS; break;
            case IN_PROGRESS: status = TaskStatus.DONE; break;
            case DONE: break;
        }
        return savedTasks.updateTaskStatus(status, id);
    }

    //TODO Exception Handling in case id does not exist
    public Task deleteTask(String id) {
        return savedTasks.deleteTask(id);
    }
}
