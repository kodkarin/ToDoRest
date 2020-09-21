package com.example.todo.rest;

import com.example.todo.entities.WorkOrderEntity;
import com.example.todo.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoRestController {

    private RestService restService;

    @Autowired
    public ToDoRestController(RestService theRestService) {
        restService = theRestService;
    }

    @GetMapping("/workorders")
    public List<WorkOrderEntity> getAllWorkOrders() {
        return restService.findAllWorkOrders();
    }

}
