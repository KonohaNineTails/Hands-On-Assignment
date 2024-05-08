package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeController.class, args);
    }
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/addEmployee")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee"; // This will return the addEmployee.html template
    }

    @PostMapping("/addEmployee")
    public String submitEmployeeForm(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/addEmployee"; // Redirect to the addEmployee page after submission
    }
}
