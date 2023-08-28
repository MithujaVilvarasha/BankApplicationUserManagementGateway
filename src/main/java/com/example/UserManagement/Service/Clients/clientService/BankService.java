package com.example.UserManagement.Service.Clients.clientService;

import com.example.UserManagement.Service.Clients.BankServiceFeignClient;
import com.example.UserManagement.Service.Clients.dto.BankDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@Component
@Slf4j
public class BankService {
    @Autowired
    BankServiceFeignClient bankServiceFeignClient;
    public ResponseEntity<BankDto> save(BankDto bankModel)
    {
        try
        {
            return new ResponseEntity<>(bankServiceFeignClient.save(bankModel).getBody(), HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.println("not done");
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<List<BankDto>> saveall(List<BankDto> bankDtos) {
        try{
            return new ResponseEntity<>(bankServiceFeignClient.saveall(bankDtos).getBody(),HttpStatus.CREATED);
        }
        catch (Exception e){
            System.out.println("not done");
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<BankDto>> findall() {
        try{
            return new ResponseEntity<>(bankServiceFeignClient.findall().getBody(),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
