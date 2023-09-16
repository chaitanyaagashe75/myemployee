package com.example.myemployee.dto;

import com.example.myemployee.model.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDataDTO {
    private String EmployeeId;
    private String name;
    private int age;
    private List<Address> addressList;
}
