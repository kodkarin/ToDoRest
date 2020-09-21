package com.example.todo.entities;

import javax.persistence.*;
import java.util.Date;

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

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "address")
    private String address;

    @Column(name = "work_description")
    private String workDescription;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "status")
    private Integer status;

    @Temporal(TemporalType.DATE)
    @Column(name = "work_started")
    private Date workStarted;

    @Temporal(TemporalType.DATE)
    @Column(name = "work_finished")
    private Date workFinished;

    @Column(name = "travel_hours")
    private double travelHours;

    @Column(name = "comment")
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getWorkStarted() {
        return workStarted;
    }

    public void setWorkStarted(Date workStarted) {
        this.workStarted = workStarted;
    }

    public Date getWorkFinished() {
        return workFinished;
    }

    public void setWorkFinished(Date workFinished) {
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

    @Override
    public String toString() {
        return "WorkOrderEntity{" +
                "id=" + id +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", workDescription='" + workDescription + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", customerId=" + customerId +
                ", employeeId=" + employeeId +
                ", status=" + status +
                ", workStarted=" + workStarted +
                ", workFinished=" + workFinished +
                ", travelHours=" + travelHours +
                ", comment='" + comment + '\'' +
                '}';
    }
}
