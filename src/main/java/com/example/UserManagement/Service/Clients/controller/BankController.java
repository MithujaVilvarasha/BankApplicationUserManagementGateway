package com.example.UserManagement.Service.Clients.controller;

import com.example.UserManagement.Service.Clients.BankServiceFeignClient;
import com.example.UserManagement.Service.Clients.clientService.BankService;
import com.example.UserManagement.Service.Clients.dto.BankDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Bank")
public class BankController {

    @Autowired
    BankService bankService;

    @Autowired
    BankServiceFeignClient bankServiceFeignClient;

    @PostMapping("/save")
    public ResponseEntity<BankDto> save(@RequestBody  BankDto bankModel) {
        return bankService.save(bankModel);
    }

    @PostMapping("/saveall")
    public ResponseEntity<List<BankDto>> saveall(@RequestBody List<BankDto> bankDtos){
        return bankService.saveall(bankDtos);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<BankDto>> findall(){
        return bankService.findall();
    }




}
