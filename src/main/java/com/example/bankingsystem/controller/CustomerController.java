package com.example.bankingsystem.controller;

import com.example.bankingsystem.dto.CustomerSaveRequestDto;
import com.example.bankingsystem.dto.CustomerDto;
import com.example.bankingsystem.dto.CustomerUpdateRequestDto;
import com.example.bankingsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(customerDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        CustomerDto customerDto = customerService.findById(id);
        return ResponseEntity.ok(customerDto);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CustomerSaveRequestDto customerSaveRequestDto) {
        CustomerDto customerDto = customerService.save(customerSaveRequestDto);
        return ResponseEntity.ok(customerDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.ok(Void.TYPE);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody CustomerUpdateRequestDto customerUpdateRequestDto) {
        CustomerDto customerDto = customerService.update(customerUpdateRequestDto);
        return ResponseEntity.ok(customerDto);
    }
}
