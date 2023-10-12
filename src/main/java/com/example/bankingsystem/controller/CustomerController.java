package com.example.bankingsystem.controller;

import com.example.bankingsystem.dto.CustomerSaveRequestDto;
import com.example.bankingsystem.dto.CustomerDto;
import com.example.bankingsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<CustomerDto> customerDtoList = customerService.findAll();
        return new ResponseEntity(customerDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity sava(@RequestBody CustomerSaveRequestDto customerSaveRequestDto) {
        CustomerDto customerDto = customerService.save(customerSaveRequestDto);
        return new ResponseEntity(customerDto, HttpStatus.OK);
    }
}
