package com.example.todo.rest;

import com.example.todo.entities.WorkOrderEntity;
import com.example.todo.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/workorders/{employeeId}")
    public List<WorkOrderEntity> getWorkOrdersForEmployee(@PathVariable int employeeId) {
        return restService.findAllWorkOrdersForEmployee(employeeId);
    }

    @PutMapping("/workorders")
    public WorkOrderEntity updateWorkOrder(@RequestBody WorkOrderEntity workOrder) {

        restService.saveWorkOrder(workOrder);
        return workOrder;
    }

    /*@PostMapping("/workorders")
    public WorkOrderEntity addNewWorkOrder(@RequestBody WorkOrderEntity workOrder) {

        workOrder.setId(0);
        restService.saveWorkOrder(workOrder);
        return workOrder;

    }*/
}
