package com.example.demo.service;

import com.example.demo.entity.Employee;

import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        List<Employee> employeeList = employeeRepository.getRmployees();
        return employeeList;
    }

    public boolean saveEmployee(Employee employee){
        return employeeRepository.createEmployee(employee);
    }

    public Employee getEmployeeByRollNo(String rollNo) {
        return employeeRepository.getEmployeeByRollNo(rollNo);
    }

    public boolean updateEmployee(Employee employee) {
        int result = employeeRepository.updateEmployee(employee);
        if(result > 0){
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(int employeeId) {
        int result = employeeRepository.deleteEmployee(employeeId);
        if(result > 0){
            return true;
        }
        return false;
    }
}
