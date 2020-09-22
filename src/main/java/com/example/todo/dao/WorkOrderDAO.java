package com.example.todo.dao;

import com.example.todo.entities.EmployeeEntity;
import com.example.todo.entities.LoginEntity;
import com.example.todo.entities.WorkOrderEntity;

import java.util.List;

public interface WorkOrderDAO {
    public List<WorkOrderEntity> findAllWorkOrders();
    public List<WorkOrderEntity> findAllWorkOrdersForEmployee(EmployeeEntity employeeEntity);
    public List<WorkOrderEntity> findWorkOrdersByStatus(int status);
    public WorkOrderEntity findWorkOrderById(int id);

    public void saveWorkOrder(WorkOrderEntity workOrder);
    public void deleteWorkOrderById(int workOrderId);
}
