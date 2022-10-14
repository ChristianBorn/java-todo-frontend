package com.example.backend.repo;

import com.example.backend.model.Task;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class TaskRepo {
    private List<Task> tasksInRepo = new ArrayList<>();

    public List<Task> getAllTasksfromRepo() {
        return tasksInRepo;
    }

    public boolean addTasktoRepo(Task task) {
        return tasksInRepo.add(task);
    }
}
