package com.satendra.bootjdbctemplate.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //read all employee curd -r
    public List<Employee> readEmployee() {

        return jdbcTemplate.query("select * from employee", (resultSet, i) -> {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setEmployeeName(resultSet.getString("employee_name"));
            return employee;
        });

    }



    // create employee
    public Employee createEmployee(Employee employee) {

        String insertEmployeeSql = "insert into employee (employee_name) values (?)";

        GeneratedKeyHolder holder = new GeneratedKeyHolder();


        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertEmployeeSql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getEmployeeName());
            return ps;
        }, holder);

        long newId = holder.getKey().longValue();
        employee.setId(newId);

        return employee;

    }

    //update employee

    public Employee updateEmployee(Employee employee, long id) {

        String updateEmployeeSql = "update employee set employee_name=? where id=?";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(updateEmployeeSql);
            ps.setString(1, employee.getEmployeeName());
            ps.setLong(2, id);
            return ps;

        });

        employee.setId(id);
        return employee;
    }

    public Employee deleteEmployee(long id) {

        String updateEmployeeSql = "delete from  employee where id=?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(updateEmployeeSql);
                preparedStatement.setLong(1,id);
                return preparedStatement;
            }
        });
        return null;
    }
}
