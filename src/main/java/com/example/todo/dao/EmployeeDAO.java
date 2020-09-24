package com.example.todo.dao;

import com.example.todo.entities.EmployeeEntity;
import com.example.todo.entities.LoginEntity;

public interface EmployeeDAO {
    public EmployeeEntity findEmployeeById(int id);
    public EmployeeEntity loginEmployee(LoginEntity login);
}
