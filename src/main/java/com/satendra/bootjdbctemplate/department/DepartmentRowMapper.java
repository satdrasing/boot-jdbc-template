package com.satendra.bootjdbctemplate.department;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper implements RowMapper<Department> {
    @Override
    public Department mapRow(ResultSet resultSet, int i) throws SQLException {

        Department department = new Department();
        department.setId(resultSet.getLong("id"));
        department.setDeptName(resultSet.getString("dept_name"));
        return department;
    }
}
