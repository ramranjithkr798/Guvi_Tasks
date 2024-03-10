package org.example;

public class Employee {
    int empNo,empPage,empSalary;
    String empName;
    public Employee(int empNo, String empName ,int empPage, int empSalary) {
        this.empNo = empNo;
        this.empPage = empPage;
        this.empSalary = empSalary;
        this.empName = empName;
    }
    public int getEmpNo() {
        return empNo;
    }
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
    public int getEmpPage() {
        return empPage;
    }
    public void setEmpPage(int empPage) {
        this.empPage = empPage;
    }
    public int getEmpSalary() {
        return empSalary;
    }
    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
