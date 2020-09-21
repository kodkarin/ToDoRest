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

   /* @PostMapping("/workorders")
    public WorkOrderEntity addNewWorkOrder(WorkOrderEntity workOrder) {

        workOrder.setId(0);
        restService.saveNewWorkOrder(workOrder);
        return workOrder;

    }*/
}
