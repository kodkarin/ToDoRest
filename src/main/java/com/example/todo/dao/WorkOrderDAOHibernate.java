package com.example.todo.dao;

import com.example.todo.entities.EmployeeEntity;
import com.example.todo.entities.LoginEntity;
import com.example.todo.entities.WorkOrderEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class WorkOrderDAOHibernate implements WorkOrderDAO {

    private EntityManager entityManager;

    @Autowired
    public WorkOrderDAOHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<WorkOrderEntity> findAllWorkOrders() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("from WorkOrderEntity", WorkOrderEntity.class);

        List<WorkOrderEntity> workOrders = theQuery.getResultList();

        return workOrders;
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
    public void saveNewWorkOrder(WorkOrderEntity workOrder) {

    }

    @Override
    public void updateWorkOrder(WorkOrderEntity workOrder) {

    }

    @Override
    public void deleteWorkOrderById(int workOrderId) {

    }
}
