package com.example.todo.service;

import com.example.todo.entities.EmployeeEntity;
import com.example.todo.entities.LoginEntity;
import com.example.todo.entities.WorkOrderEntity;

import java.util.List;

public interface RestService {
    public List<WorkOrderEntity> findAllWorkOrders();
    public List<WorkOrderEntity> findAllWorkOrdersForEmployee(int employeeId);
    public List<WorkOrderEntity> findWorkOrdersByStatus(int status);
    public WorkOrderEntity findWorkOrderById(int id);
    public EmployeeEntity findEmployeeById(int id);
    public EmployeeEntity loginEmployee(LoginEntity login);
    public void saveWorkOrder(WorkOrderEntity workOrder);
    public void deleteWorkOrderById(int workOrderId);
}
