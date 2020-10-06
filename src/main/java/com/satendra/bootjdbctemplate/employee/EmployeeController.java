package com.satendra.bootjdbctemplate.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    List<Employee> getAllEmployee(){
        return employeeRepository.readEmployee();
    }

    @PostMapping("/employees")
    Employee psotEmployee(@RequestBody Employee employee){
        return employeeRepository.createEmployee(employee);
    }

    @PostMapping("/employees/{id}")
    Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        return employeeRepository.updateEmployee(employee,id);
    }

    @DeleteMapping("/employees/{id}")
    Employee deleteEmployee(@PathVariable Long id){
        return employeeRepository.deleteEmployee(id);
    }

}
