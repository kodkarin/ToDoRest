package com.example.todo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Herman
 * @author Niclas
 */
@Entity
@Table(name = "employees")
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "telephone_no")
    private String telephoneNo;

    @JsonManagedReference (value = "workOrder-employee")
    @OneToMany(mappedBy = "employee",
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private List<WorkOrderEntity> workOrders;

    public EmployeeEntity() {
        // No-arg constructor
    }

    // ----Setters---- //

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    // ----Getters---- //

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public List<WorkOrderEntity> getWorkOrders() {
        return workOrders;
    }

    public void setWorkOrders(List<WorkOrderEntity> workOrders) {
        this.workOrders = workOrders;
    }

    public void addWorkOrder(WorkOrderEntity workOrder) {
        if(workOrders == null) {
            workOrders = new ArrayList<>();
        }
        workOrders.add(workOrder);
        workOrder.setEmployee(this);
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNo='" + telephoneNo + '\'' +
                '}';
    }
}
