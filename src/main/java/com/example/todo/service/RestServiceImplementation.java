package com.example.todo.service;

import com.example.todo.dao.WorkOrderDAO;
import com.example.todo.entities.EmployeeEntity;
import com.example.todo.entities.LoginEntity;
import com.example.todo.entities.WorkOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestServiceImplementation implements RestService {

    private WorkOrderDAO workOrderDAO;

    @Autowired
    public RestServiceImplementation(WorkOrderDAO workOrderDAO) {
        this.workOrderDAO = workOrderDAO;
    }

    @Override
    @Transactional
    public List<WorkOrderEntity> findAllWorkOrders() {
        return workOrderDAO.findAllWorkOrders();
    }

    @Override
    @Transactional
    public List<WorkOrderEntity> findAllWorkOrdersForEmployee(int employeeId) {
        return workOrderDAO.findAllWorkOrdersForEmployee(employeeId);
    }

    @Override
    @Transactional
    public List<WorkOrderEntity> findWorkOrdersByStatus(int status) {
        return null;
    }

    @Override
    @Transactional
    public WorkOrderEntity findWorkOrderById(int id) {
        return null;
    }

    @Override
    @Transactional
    public EmployeeEntity findEmployeeById(int id) {
        return null;
    }

    @Override
    @Transactional
    public EmployeeEntity loginEmployee(LoginEntity login) {
        return null;
    }

    @Override
    @Transactional
    public void saveWorkOrder(WorkOrderEntity workOrder) {
        workOrderDAO.saveWorkOrder(workOrder);
    }


    @Override
    @Transactional
    public void deleteWorkOrderById(int workOrderId) {

    }
}
