package com.example.todo.service;

import com.example.todo.dao.EmployeeDAO;
import com.example.todo.dao.WorkOrderDAO;
import com.example.todo.entities.EmployeeEntity;
import com.example.todo.entities.LoginEntity;
import com.example.todo.entities.WorkOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestServiceImplementation implements RestService {

    private WorkOrderDAO workOrderDAO;

    @Autowired
    public RestServiceImplementation(WorkOrderDAO workOrderDAO) {
        this.workOrderDAO = workOrderDAO;
    }

    @Override
    public List<WorkOrderEntity> findAllWorkOrders() {
        return workOrderDAO.findAllWorkOrders();
    }

    @Override
    public List<WorkOrderEntity> findAllWorkOrdersForEmployee(int employeeId) {
        return null;
    }

    @Override
    public List<WorkOrderEntity> findWorkOrdersByStatus(int status) {
        return null;
    }

    @Override
    public WorkOrderEntity findWorkOrderById(int id) {
        return null;
    }

    @Override
    public EmployeeEntity findEmployeeById(int id) {
        return null;
    }

    @Override
    public EmployeeEntity loginEmployee(LoginEntity login) {
        return null;
    }

    @Override
    public void saveNewWorkOrder(WorkOrderEntity workOrder) {

    }

    @Override
    public void updateWorkOrder(WorkOrderEntity workOrder) {

    }

    @Override
    public void deleteWorkOrderById(int workOrderId) {

    }
}
