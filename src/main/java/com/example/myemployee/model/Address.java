package com.example.myemployee.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    private String AddressId;
    private String landmark;
    private String city;
    private int pincode;

    @Column(nullable = false)
    private String employeeId;

}
