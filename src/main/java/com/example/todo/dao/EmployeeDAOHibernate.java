package com.example.todo.dao;

import com.example.todo.entities.EmployeeEntity;
import com.example.todo.entities.LoginEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EmployeeDAOHibernate implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EmployeeEntity findEmployeeById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("from EmployeeEntity where id=:id");
        theQuery.setParameter("id", id);

        return (EmployeeEntity) theQuery.getSingleResult();

    }


    @Override
    public EmployeeEntity loginEmployee(LoginEntity login) {
        return findEmployeeById(login.getEmployeeId());
    }
}
