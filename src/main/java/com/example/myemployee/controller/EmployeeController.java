package com.example.myemployee.controller;

import com.example.myemployee.dto.EmployeeDataDTO;
import com.example.myemployee.dto.ResponseDTO;
import com.example.myemployee.model.Employee;
import com.example.myemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeData")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public List<Employee> addEmployeeData(@RequestBody EmployeeDataDTO employeeDataDTO) {
        return employeeService.addEmployeeData(employeeDataDTO);
    }

    @PutMapping("/update")
    public EmployeeDataDTO updateEmployeeData(@RequestBody EmployeeDataDTO employeeDataDTO){
       return employeeService.updateEmployeeData(employeeDataDTO);
    }

    @GetMapping("/get/{EmployeeId}")
    public EmployeeDataDTO getEmployeeData(@PathVariable String EmployeeId){
        return employeeService.getEmployeeData(EmployeeId);
    }


    @GetMapping("/getByName/{name}")
    public ResponseDTO getEmployeeDataByName(@PathVariable String name){
        return employeeService.getEmployeeDataByName(name);
    }

    @GetMapping("/getByAgeRange")
    public List<EmployeeDataDTO> getEmployeeDataByAgeRange(@RequestParam int minAge, @RequestParam int maxAge){
        return employeeService.getEmployeeDataByAgeRange(minAge, maxAge);
    }

}
