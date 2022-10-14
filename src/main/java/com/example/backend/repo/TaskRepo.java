package com.example.backend.repo;

import com.example.backend.model.Task;
import com.example.backend.model.TaskStatus;
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

    public Task addTaskToRepo(String id, Task task) {
        tasksInRepo.put(id, task);
        return task;
    }

    public Task getSpecificTask(String id) {
        return tasksInRepo.get(id);
    }
    //TODO define case where updatedTask is equal to the task to be updated in repo
    public Task updateTaskAttributes(Task updatedTask, String id) {
        tasksInRepo.replace(id, updatedTask);


        return tasksInRepo.get(id);
    }

    //TODO Add Exception in case id does not exist
    public Task deleteTask(String id) {
        return tasksInRepo.remove(id);
    }

}
