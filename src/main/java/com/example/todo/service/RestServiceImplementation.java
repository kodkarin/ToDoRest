package com.example.todo.service;

import com.example.todo.dao.EmployeeDAO;
import com.example.todo.dao.ExpensesDAO;
import com.example.todo.dao.LoginDAO;
import com.example.todo.dao.WorkOrderDAO;
import com.example.todo.entities.*;
import com.example.todo.input_forms.ExpensesForm;
import com.example.todo.input_forms.LoginForm;
import com.example.todo.input_forms.WorkOrderFinishedForm;
import com.example.todo.input_forms.WorkOrderStatusForm;
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

    /*@Override
    @Transactional
    public void addExpense(ExpensesEntity expense) {
        expensesDAO.addExpense(expense);
    }*/

    @Override
    @Transactional
    public WorkOrderEntity updateWorkOrderStatus(WorkOrderStatusForm workOrderStatus) {
        WorkOrderEntity workOrderToUpdate = workOrderDAO.findWorkOrderById(workOrderStatus.getId());
        workOrderToUpdate.setStatus(workOrderStatus.getStatus());
        if (workOrderStatus.getStatus() == 1) {
            workOrderToUpdate.setEmployee(null);
        }
        workOrderDAO.saveWorkOrder(workOrderToUpdate);
        return workOrderToUpdate;
    }

    @Override
    @Transactional
    public WorkOrderEntity finishWorkOrder(WorkOrderFinishedForm finishedWorkOrder) {
        WorkOrderEntity workOrderToUpdate = workOrderDAO.findWorkOrderById(finishedWorkOrder.getId());
        workOrderToUpdate.setStatus(finishedWorkOrder.getStatus());
        workOrderToUpdate.setWorkStarted(finishedWorkOrder.getWorkStarted());
        workOrderToUpdate.setWorkFinished(finishedWorkOrder.getWorkFinished());
        workOrderToUpdate.setTravelHours(finishedWorkOrder.getTravelHours());
        workOrderToUpdate.setComment(finishedWorkOrder.getComment());
        workOrderDAO.saveWorkOrder(workOrderToUpdate);
        return workOrderToUpdate;
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
