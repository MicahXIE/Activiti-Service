package com.micah.activitiservice.controller;

import com.micah.activitiservice.entity.TaskRepresentation;
import com.micah.activitiservice.service.ActivitiService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "activiti")
public class ActivitiController {
    @Autowired
    private ActivitiService service;

    @GetMapping("start")
    public String start() {
        return service.start();
    }

    @GetMapping("task")
    public List<TaskRepresentation> getTask(@RequestParam(value = "uid") String uid) {
        List<Task> tasks = service.getTask(uid);
        List<TaskRepresentation> dtos = new ArrayList<>();
        for (Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(), task.getName()));
        }
        return dtos;
    }
}
