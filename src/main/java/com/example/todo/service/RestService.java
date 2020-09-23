package com.example.todo.service;

import com.example.todo.entities.*;

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
    public void addExpense(ExpensesEntity expense);
    //public ExpensesEntity addExpense(ExpensesForm expense);
}
