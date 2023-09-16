package com.example.myemployee.repository;

import com.example.myemployee.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,String> {
    List<Address> findAllByEmployeeId(String employeeId);
}
