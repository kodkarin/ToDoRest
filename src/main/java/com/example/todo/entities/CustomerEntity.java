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
@Table(name = "customers")
public class CustomerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "telephone_no")
    private String telephoneNo;

    @JsonManagedReference (value = "workOrder-customer")
    @OneToMany(mappedBy = "customer",
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private List<WorkOrderEntity> workOrders;

    public CustomerEntity() {
        // No-arg constructor
    }

    // ----Getters---- //

    public Integer getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getContactPerson() {
        return contactPerson;
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
        workOrder.setCustomer(this);
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", telephoneNo='" + telephoneNo + '\'' +
                '}';
    }
}

