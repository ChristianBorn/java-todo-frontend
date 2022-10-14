package com.example.backend.repo;

import com.example.backend.model.Task;
import com.example.backend.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.image.PixelGrabber;
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

    public Task getSpecificTask(String id) {
        return tasksInRepo.get(id);
    }

    public Task updateTaskStatus(TaskStatus status, String id) {
        tasksInRepo.get(id).setStatus(status);
        return tasksInRepo.get(id);
    }

    //TODO Add Exception in case id does not exist
    public Task deleteTask(String id) {
        return tasksInRepo.remove(id);
    }
}
