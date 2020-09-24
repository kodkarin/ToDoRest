package com.example.todo.rest;

import com.example.todo.entities.*;
import com.example.todo.input_forms.ExpensesForm;
import com.example.todo.input_forms.LoginForm;
import com.example.todo.input_forms.WorkOrderFinishedForm;
import com.example.todo.input_forms.WorkOrderStatusForm;
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

    @PostMapping("/workorders/status/finalReport")
    public WorkOrderEntity finishWorkOrder(@RequestBody WorkOrderFinishedForm finishedWorkOrder) {
        return restService.finishWorkOrder(finishedWorkOrder);
    }
    @PostMapping("/workorders/status")
    public WorkOrderEntity updateWorkOrderStatus(@RequestBody WorkOrderStatusForm workOrderStatus) {
        return restService.updateWorkOrderStatus(workOrderStatus);
    }

    @PutMapping("/workorders")
    public WorkOrderEntity updateWorkOrder(@RequestBody WorkOrderEntity workOrder) {

        restService.saveWorkOrder(workOrder);
        return workOrder;
    }

    @PostMapping("/expenses")
    public ExpensesEntity addExpense(@RequestBody ExpensesForm expense) {

         return restService.addExpense(expense);
    }

    /*
    @PostMapping("/expenses")
    public ExpensesEntity addExpense(@RequestBody ExpensesEntity expense) {

        restService.addExpense(expense);
        return expense;
    }*/

    @PostMapping("/login")
    public EmployeeEntity login(@RequestBody LoginForm loginForm){

        return restService.loginEmployee(loginForm);
    }

    /*@PostMapping("/workorders")
    public WorkOrderEntity addNewWorkOrder(@RequestBody WorkOrderEntity workOrder) {

        workOrder.setId(0);
        restService.saveWorkOrder(workOrder);
        return workOrder;

    }*/
}
