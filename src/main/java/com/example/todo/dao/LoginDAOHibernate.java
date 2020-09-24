package com.example.todo.dao;

import com.example.todo.entities.LoginEntity;
import com.example.todo.input_forms.LoginForm;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class LoginDAOHibernate implements  LoginDAO {

    private EntityManager entityManager;

    @Autowired
    public LoginDAOHibernate  (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public LoginEntity login(LoginForm loginForm) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("from LoginEntity where username=:username");
        theQuery.setParameter("username", loginForm.getUsername());
        //theQuery.setParameter("password", loginForm.getPassword());

        return (LoginEntity) theQuery.getSingleResult();
    }
}
