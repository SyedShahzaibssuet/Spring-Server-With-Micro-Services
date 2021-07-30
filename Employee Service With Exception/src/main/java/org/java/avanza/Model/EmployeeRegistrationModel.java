package org.java.avanza.Model;

public class EmployeeRegistrationModel {
    private String Name;
    private String Department;
    private String Status;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String show(){
        return ""+this.Name+ " " + this.Department +" "+this.Status;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
