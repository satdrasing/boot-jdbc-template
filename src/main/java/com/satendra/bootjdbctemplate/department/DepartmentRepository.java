package com.satendra.bootjdbctemplate.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Department> getAllDepartment() {

        return jdbcTemplate
                .query("select * from department",
                        new DepartmentRowMapper()
                );
    }

    public List<Department> getAllDepartmentBean() {

        return jdbcTemplate
                .query("select * from department",
                        new BeanPropertyRowMapper<>(Department.class)
                );
    }

    public Department getDepartment(long id) {

        return jdbcTemplate
                .queryForObject("select * from department where id = ? ",
                        new Object[]{id},
                        new DepartmentRowMapper());
    }

    public Department getDepartmentWithBean(long id) {

        return jdbcTemplate
                .queryForObject("select * from department where id = ? ",
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(Department.class)
                );
    }

}
