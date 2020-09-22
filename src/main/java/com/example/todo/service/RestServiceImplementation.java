package com.example.todo.service;

import com.example.todo.dao.EmployeeDAO;
import com.example.todo.dao.ExpensesDAO;
import com.example.todo.dao.LoginDAO;
import com.example.todo.dao.WorkOrderDAO;
import com.example.todo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestServiceImplementation implements RestService {

    private WorkOrderDAO workOrderDAO;
    private ExpensesDAO expensesDAO;
    private EmployeeDAO employeeDAO;
    private LoginDAO loginDAO;

    @Autowired
    public RestServiceImplementation(WorkOrderDAO workOrderDAO, ExpensesDAO expensesDAO,
                                     EmployeeDAO employeeDAO, LoginDAO loginDAO) {
        this.workOrderDAO = workOrderDAO;
        this.expensesDAO = expensesDAO;
        this.employeeDAO = employeeDAO;
        this.loginDAO = loginDAO;
    }

    @Override
    @Transactional
    public List<WorkOrderEntity> findAllWorkOrders() {
        return workOrderDAO.findAllWorkOrders();
    }

    @Override
    @Transactional
    public List<WorkOrderEntity> findAllWorkOrdersForEmployee(int employeeId) {
        EmployeeEntity employeeEntity = employeeDAO.findEmployeeById(employeeId);
        return workOrderDAO.findAllWorkOrdersForEmployee(employeeEntity);
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
    public EmployeeEntity loginEmployee(LoginForm login) {
        LoginEntity loginEntity = loginDAO.login(login);
        if (loginEntity == null) {
            return null;
        }
        return employeeDAO.loginEmployee(loginEntity);
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

    @Override
    @Transactional
    public ExpensesEntity addExpense(ExpensesForm expense) {
        WorkOrderEntity workOrder = workOrderDAO.findWorkOrderById(expense.getWorkOrderId());
        ExpensesEntity newExpense = new ExpensesEntity(expense.getAmount(), expense.getDescription(), workOrder);
        expensesDAO.addExpense(newExpense);
        return newExpense;
    }
}
