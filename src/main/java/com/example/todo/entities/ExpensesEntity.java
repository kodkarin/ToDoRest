package com.example.todo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Herman
 * @author Niclas
 */
@Entity
@Table(name = "expenses")
public class ExpensesEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String description;

    @JsonBackReference (value = "expense-workOrder")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "work_order_id")
    private WorkOrderEntity workOrder;

    public ExpensesEntity() {

    }

    public ExpensesEntity(double amount, String description, WorkOrderEntity workOrder) {
        this.amount = amount;
        this.description = description;
        this.workOrder = workOrder;
    }

    // ----Getters---- //

    public Integer getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public WorkOrderEntity getWorkOrder() {
        return workOrder;
    }

    // ----Setters---- //

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWorkOrder(WorkOrderEntity workOrder) {
        this.workOrder = workOrder;
    }

    @Override
    public String toString() {
        return "ExpensesEntity{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
