package org.Entities;

public class Employee {

    private   int EmployeeId ;
    private String EmployeeName;
    private String Title ;
    private String Department;
    public String[] JobTitles = new String[] {"Software Engineer","SQA Engineer","Customer Support","Product Management","Devops","Data Migration"};

    public String[] getJobTitles() {
        return JobTitles;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }



}
