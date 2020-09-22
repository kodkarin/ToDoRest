package com.example.todo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Herman
 * @author Niclas
 */
@Entity
@Table(name = "work_orders")
public class WorkOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private String date;

    @Column(name="time")
    private String time;

    @Column(name = "address")
    private String address;

    @Column(name = "work_description")
    private String workDescription;

    @Column(name = "contact_info")
    private String contactInfo;

    @JsonBackReference(value = "workOrder-customer")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @JsonBackReference (value = "workOrder-employee")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @Column(name = "status")
    private Integer status;

    @Column(name = "work_started")
    private String workStarted;

    @Column(name = "work_finished")
    private String workFinished;

    @Column(name = "travel_hours")
    private double travelHours;

    @Column(name = "comment")
    private String comment;

    @JsonManagedReference (value = "expense-workOrder")
    @OneToMany(mappedBy = "workOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExpensesEntity> expenses;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getWorkStarted() {
        return workStarted;
    }

    public void setWorkStarted(String workStarted) {
        this.workStarted = workStarted;
    }

    public String getWorkFinished() {
        return workFinished;
    }

    public void setWorkFinished(String workFinished) {
        this.workFinished = workFinished;
    }

    public double getTravelHours() {
        return travelHours;
    }

    public void setTravelHours(double travelHours) {
        this.travelHours = travelHours;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<ExpensesEntity> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<ExpensesEntity> expenses) {
        this.expenses = expenses;
    }

    public void addExpense(ExpensesEntity expense) {
        if(expenses == null) {
            expenses = new ArrayList<>();
        }
        expenses.add(expense);
        expense.setWorkOrder(this);
    }

    @Override
    public String toString() {
        return "WorkOrderEntity{" +
                "id=" + id +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", workDescription='" + workDescription + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", customer=" + customer.getCompanyName() +
                ", employee=" + employee.getFirstName() + " " + employee.getLastName() +
                ", status=" + status +
                ", workStarted=" + workStarted +
                ", workFinished=" + workFinished +
                ", travelHours=" + travelHours +
                ", comment='" + comment + '\'' +
                '}';
    }
}
