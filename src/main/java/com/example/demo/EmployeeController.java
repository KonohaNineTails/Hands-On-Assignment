package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmployeeController {

    public EmployeeController(EmployeeRepository repository) {
        this.employeeRepository = repository;

    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeController.class, args);
    }

    public EmployeeRepository employeeRepository;

    @GetMapping("/addEmployee")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee"; // This will return the addEmployee.html template
    }


    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        Employee savedEmployee = employeeRepository.save(employee); // Save your employee using a service
        return ResponseEntity.ok(savedEmployee); // Return the saved employee as JSON

    }


}

