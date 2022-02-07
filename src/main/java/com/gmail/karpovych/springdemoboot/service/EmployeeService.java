package com.gmail.karpovych.springdemoboot.service;

import com.gmail.karpovych.springdemoboot.model.Employee;
import com.gmail.karpovych.springdemoboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee findById(Integer employeeId) {
        return employeeRepository.getOne(employeeId);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
