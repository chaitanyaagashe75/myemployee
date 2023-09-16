package com.example.myemployee.dto;

import java.util.List;

public class ResponseDTO {

    private List<EmployeeDataDTO> response;

    private int count;

    public List<EmployeeDataDTO> getResponse() {
        return response;
    }

    public void setResponse(List<EmployeeDataDTO> response) {
        this.response = response;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
