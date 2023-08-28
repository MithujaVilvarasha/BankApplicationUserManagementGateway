package com.example.UserManagement.Service.Clients;


import com.example.UserManagement.Service.Clients.dto.BankDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "BankApplication", url="http://localhost:8080", path="")
public interface BankServiceFeignClient {

    @PostMapping("/Bank/save")
    public ResponseEntity<BankDto> save(@RequestBody BankDto bankModel);

    @PostMapping("/Bank/saveall")
    public ResponseEntity<List<BankDto>> saveall(@RequestBody List<BankDto> bankDtos);

    @GetMapping("/Bank/findall")
    public ResponseEntity<List<BankDto>> findall();


    @GetMapping("/Bank/findbyid/{id}")
    public ResponseEntity<BankDto> findById(@PathVariable Long id);


}
