package com.example.UserManagement.Service.Clients.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class BankDto {

    private Long bankId;


    private String name;


    private String branch;
}
