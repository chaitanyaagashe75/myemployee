package com.example.myemployee.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    private String EmployeeId;
    private String name;
    private int age;
}
