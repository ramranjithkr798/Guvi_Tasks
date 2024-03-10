package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection=Connections.getConnection();
        PreparedStatement preparedStatement = null;

        List<Employee> employeeList=new ArrayList();
        employeeList.add(new Employee(101,"Jenny",25,10000));
        employeeList.add(new Employee(102,"Jacky",30,20000));
        employeeList.add(new Employee(103,"Joe",20,40000));
        employeeList.add(new Employee(104,"John",40,80000));
        employeeList.add(new Employee(105,"Shameer",25,90000));

        try {
            for(Employee employee: employeeList) {
                System.out.println("Entering into for");
                String sqlStatement="insert into employee values("+employee.getEmpNo()+",'"+employee.getEmpName()+"',"+employee.getEmpPage()+","+employee.getEmpSalary()+")";
                preparedStatement = connection.prepareStatement(sqlStatement);
                preparedStatement.execute();
                System.out.println("Employee data inserted successfully......");
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            //connection.close();
        }
    }
}