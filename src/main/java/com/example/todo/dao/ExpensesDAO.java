package com.example.todo.dao;

import com.example.todo.entities.ExpensesEntity;

import java.util.List;

public interface ExpensesDAO {
    public List<ExpensesEntity> findExpensesForWorkOrder(int workOrderId);
    public void addExpense(ExpensesEntity expense);
    public void deleteExpenseById(int id);
}
