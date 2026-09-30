package com.example.helpdesk.controller;

import com.example.helpdesk.dto.EmployeeDTO;
import com.example.helpdesk.dto.EmployeeResponseDTO;
import com.example.helpdesk.entity.Employee;
import com.example.helpdesk.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
   @PostMapping
public EmployeeResponseDTO createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {

    Employee employee = employeeService.createEmployeeFromDTO(employeeDTO);

    return employeeService.convertToResponseDTO(employee);
}
@GetMapping
public List<EmployeeResponseDTO> getAllEmployees() {
    return employeeService.getAllEmployees();
}
@GetMapping("/{id}")
public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
    return employeeService.getEmployeeById(id);
}
@PutMapping("/{id}")
public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
    return employeeService.updateEmployee(id, employee);
}
@DeleteMapping("/{id}")
public void deleteEmployee(@PathVariable Long id) {
    employeeService.deleteEmployee(id);
}
}