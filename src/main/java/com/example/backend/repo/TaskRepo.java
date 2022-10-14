package com.example.backend.repo;

import com.example.backend.model.Task;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class TaskRepo {
    private Map<String, Task> tasksInRepo = new HashMap();

    public Map<String, Task> getAllTasksfromRepo() {
        return tasksInRepo;
    }

    public Task addTasktoRepo(String id, Task task) {
        return tasksInRepo.put(id, task);
    }
}
