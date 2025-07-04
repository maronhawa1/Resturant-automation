package com.maron.restaurantapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.maron.restaurantapi.model.Employees;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
  private List<Employees> employees= new ArrayList<>();
    private Long nextId = 1L;
@GetMapping
 public List<Employees> getAllEmployees (){
    return employees;
}
@GetMapping("/{id}")
    public Employees getEmpolyeeById(@PathVariable Long id){
    return employees.stream().filter(e ->e.getId_employee().equals(id))
            .findFirst().orElseThrow(()->new NoSuchElementException("Employee not found"));
}
@PostMapping
    public  List<Employees> addEmployee(@RequestBody List<Employees> employeesList ){
    for(Employees employee : employeesList){
        employee.setId_employee(nextId++);
        employees.add(employee);
    }
    return employeesList;
}
    @PutMapping("/{id}")
    public  Employees updateEmployee(@PathVariable Long id,@RequestBody Employees updateEmployee ){
    Employees employee=getEmpolyeeById(id);
    employee.setName_employee(updateEmployee.getName_employee());
    employee.setEmail_employee(updateEmployee.getEmail_employee());
    employee.setPhone_employee(updateEmployee.getPhone_employee());
    employee.setROLE_employee(updateEmployee.getROLE_employee());
    return  employee;
    }
    @DeleteMapping("/{id}")
    public  void deleteEmployee(@PathVariable Long id){
    employees.removeIf(e->e.getId_employee().equals(id));
    }


}
