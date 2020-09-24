package com.example.todo.dao;

import com.example.todo.entities.LoginEntity;
import com.example.todo.input_forms.LoginForm;

public interface LoginDAO {

    public LoginEntity login(LoginForm loginForm);
}
