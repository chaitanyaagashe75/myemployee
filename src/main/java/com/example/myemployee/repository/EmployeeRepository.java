package com.example.myemployee.repository;

import com.example.myemployee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
   public List<Employee> findAllByName(String name);

  public List<Employee> findAllByAgeBetween(int minAge, int maxAge);
}
