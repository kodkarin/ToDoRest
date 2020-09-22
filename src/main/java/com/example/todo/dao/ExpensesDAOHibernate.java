package com.example.todo.dao;

import com.example.todo.entities.ExpensesEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ExpensesDAOHibernate implements ExpensesDAO {

    private EntityManager entityManager;

    @Autowired
    public ExpensesDAOHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ExpensesEntity> findExpensesForWorkOrder(int workOrderId) {
        return null;
    }

    @Override
    public void addExpense(ExpensesEntity expense) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(expense);
    }

    @Override
    public void deleteExpenseById(int id) {

    }
}
