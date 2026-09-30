package com.example.helpdesk.service;

import com.example.helpdesk.entity.Employee;
import com.example.helpdesk.exception.ResourceNotFoundException;
import com.example.helpdesk.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.helpdesk.dto.EmployeeDTO;
import com.example.helpdesk.dto.EmployeeResponseDTO;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
}
public List<EmployeeResponseDTO> getAllEmployees() {
    return employeeRepository.findAll()
            .stream()
            .map(this::convertToResponseDTO)
            .toList();
}
public EmployeeResponseDTO getEmployeeById(Long id) {
    Employee employee = employeeRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Employee not found with id: " + id
                    ));

    return convertToResponseDTO(employee);
}
public Employee updateEmployee(Long id, Employee employee) {
    Employee existingEmployee = employeeRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Employee not found with id: " + id
                    ));

    existingEmployee.setName(employee.getName());
    existingEmployee.setEmail(employee.getEmail());
    existingEmployee.setDepartment(employee.getDepartment());

    return employeeRepository.save(existingEmployee);
}
public void deleteEmployee(Long id) {
    Employee employee = employeeRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Employee not found with id: " + id
                    ));

    employeeRepository.delete(employee);
}
public Employee createEmployeeFromDTO(EmployeeDTO employeeDTO) {

    Employee employee = new Employee();

    employee.setName(employeeDTO.getName());
    employee.setEmail(employeeDTO.getEmail());
    employee.setDepartment(employeeDTO.getDepartment());

    return employeeRepository.save(employee);
}
public EmployeeResponseDTO convertToResponseDTO(Employee employee) {

    return new EmployeeResponseDTO(
            employee.getId(),
            employee.getName(),
            employee.getEmail(),
            employee.getDepartment()
    );
}
}