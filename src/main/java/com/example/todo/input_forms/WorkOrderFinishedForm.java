package com.example.todo.input_forms;

public class WorkOrderFinishedForm {

    private Integer id;
    private Integer status;
    private String workStarted;
    private String workFinished;
    private double travelHours;
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
}
