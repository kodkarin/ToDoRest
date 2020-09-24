package com.example.todo.service;

import com.example.todo.entities.*;
import com.example.todo.input_forms.ExpensesForm;
import com.example.todo.input_forms.LoginForm;
import com.example.todo.input_forms.WorkOrderFinishedForm;
import com.example.todo.input_forms.WorkOrderStatusForm;

import java.util.List;

public interface RestService {
    public List<WorkOrderEntity> findAllWorkOrders();
    public List<WorkOrderEntity> findAllWorkOrdersForEmployee(int employeeId);
    public List<WorkOrderEntity> findWorkOrdersByStatus(int status);
    public WorkOrderEntity findWorkOrderById(int id);
    public EmployeeEntity findEmployeeById(int id);
    public EmployeeEntity loginEmployee(LoginForm login);
    public void saveWorkOrder(WorkOrderEntity workOrder);
    public void deleteWorkOrderById(int workOrderId);
    public ExpensesEntity addExpense(ExpensesForm expense);
    public WorkOrderEntity updateWorkOrderStatus(WorkOrderStatusForm workOrderStatus);
    public WorkOrderEntity finishWorkOrder(WorkOrderFinishedForm finishedWorkOrder);
    //public ExpensesEntity addExpense(ExpensesForm expense);
}
