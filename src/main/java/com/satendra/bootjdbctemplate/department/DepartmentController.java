package com.satendra.bootjdbctemplate.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("departments")
    public List<Department> getAllDepartment(){
        return departmentRepository.getAllDepartment();
    }

    @GetMapping("departments-bean")
    public List<Department> getAllDepartmentBean(){
        return departmentRepository.getAllDepartmentBean();
    }

    @GetMapping("departments/{id}")
    public Department getDepartment(@PathVariable long id){
        return departmentRepository.getDepartment(id);
    }

    @GetMapping("departments-bean/{id}")
    public Department getDepartmentBean(@PathVariable long id){
        return departmentRepository.getDepartmentWithBean(id);
    }

}
