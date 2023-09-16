package com.example.myemployee.service.Impl;

import com.example.myemployee.dto.EmployeeDataDTO;
import com.example.myemployee.dto.ResponseDTO;
import com.example.myemployee.model.Address;
import com.example.myemployee.model.Employee;
import com.example.myemployee.repository.AddressRepository;
import com.example.myemployee.repository.EmployeeRepository;
import com.example.myemployee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class EmployeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public List<Employee> addEmployeeData(EmployeeDataDTO employeeDataDTO) {
        List<Employee> employeesToBePersisted  = new ArrayList<>();

        for (int i=0; i<1000; i++) {
            String employeeId = UUID.randomUUID().toString();

            Employee employee = new Employee();
            employee.setEmployeeId(employeeId);
            employee.setName(employeeDataDTO.getName());
            employee.setAge(employeeDataDTO.getAge());

            employeesToBePersisted.add(employee);

            for (Address address : employeeDataDTO.getAddressList()) {
                address.setEmployeeId(employeeId);
                String addressId = UUID.randomUUID().toString();

                address.setAddressId(addressId);
            }

            addressRepository.saveAll(employeeDataDTO.getAddressList());

        }

        return employeeRepository.saveAll(employeesToBePersisted);
    }

    @Override
    public EmployeeDataDTO updateEmployeeData(EmployeeDataDTO employeeDataDTO) {
        Optional<Employee> OptEmployee = employeeRepository.findById(employeeDataDTO.getEmployeeId());
        if (OptEmployee.isPresent()) {
            Employee existingEmployeeData = OptEmployee.get();
            existingEmployeeData.setName(employeeDataDTO.getName());
            existingEmployeeData.setAge(employeeDataDTO.getAge());

            List<Address> addressList = employeeDataDTO.getAddressList();
            for (Address adderess : addressList) {

            }

        }
        return null;
    }


    @Override
    public EmployeeDataDTO getEmployeeData(String employeeId) {
        Optional<Employee> OptEmployee = employeeRepository.findById(employeeId);
        if (OptEmployee.isPresent()) {
            Employee employee = OptEmployee.get();

            List<Address> addresses = addressRepository.findAllByEmployeeId(employeeId);

            EmployeeDataDTO employeeDataDTO = new EmployeeDataDTO();
            employeeDataDTO.setEmployeeId(employee.getEmployeeId());
            employeeDataDTO.setName(employee.getName());
            employeeDataDTO.setAge(employee.getAge());
            employeeDataDTO.setAddressList(addresses);

            return employeeDataDTO;
        } else {
            log.info("Employee not found");
            return null;
        }

    }

    @Override
    public ResponseDTO getEmployeeDataByName(String name) {
        List<EmployeeDataDTO> allFetchedData = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAllByName(name);
        for (Employee employee : employees) {
            List<Address> addresses = addressRepository.findAllByEmployeeId(employee.getEmployeeId());
            EmployeeDataDTO employeeDataDTO = new EmployeeDataDTO();
            employeeDataDTO.setEmployeeId(employee.getEmployeeId());
            employeeDataDTO.setName(employee.getName());
            employeeDataDTO.setAge(employee.getAge());
            employeeDataDTO.setAddressList(addresses);
            allFetchedData.add(employeeDataDTO);
        }

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse(allFetchedData);
        responseDTO.setCount(allFetchedData.size());
        return responseDTO;
    }

    @Override
    public List<EmployeeDataDTO> getEmployeeDataByAgeRange(int minAge, int maxAge) {
        List<EmployeeDataDTO> response = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAllByAgeBetween(minAge, maxAge);

        for (Employee employee : employees) {
            List<Address> addresses = addressRepository.findAllByEmployeeId(employee.getEmployeeId());
            EmployeeDataDTO employeeDataDTO = new EmployeeDataDTO();
            employeeDataDTO.setEmployeeId(employee.getEmployeeId());
            employeeDataDTO.setName(employee.getName());
            employeeDataDTO.setAge(employee.getAge());
            employeeDataDTO.setAddressList(addresses);
            response.add(employeeDataDTO);
        }

        return response;
    }



}







