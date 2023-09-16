package com.example.myemployee.service;

import com.example.myemployee.dto.EmployeeDataDTO;
import com.example.myemployee.dto.ResponseDTO;
import com.example.myemployee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
   public List<Employee> addEmployeeData(EmployeeDataDTO employeeDataDTO);

   public EmployeeDataDTO updateEmployeeData(EmployeeDataDTO employeeDataDTO);

  public EmployeeDataDTO getEmployeeData(String employeeId);

   public ResponseDTO getEmployeeDataByName(String name);

   public List<EmployeeDataDTO> getEmployeeDataByAgeRange(int minAge, int maxAge);

}
