package com.gmail.karpovych.springdemoboot.controller;

import com.gmail.karpovych.springdemoboot.model.Employee;
import com.gmail.karpovych.springdemoboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String findAll(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employee/employee-list";
    }

    @GetMapping("/employee-create")
    public String createEmployeeForm(Employee employee) {
        return "employee/employee-create";
    }

    @PostMapping("/employee-create")
    public String createEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("employee-delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer employeeId) {
        employeeService.deleteById(employeeId);
        return "redirect:/employees";
    }

    @GetMapping("employee/employee-update/{id}")
    public String updateEmployeeForm(@PathVariable("id") Integer employeeId, Model model) {
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);
        return "employee/employee-update";
    }

    @PostMapping("/employee-update")
    public String updateEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
}
