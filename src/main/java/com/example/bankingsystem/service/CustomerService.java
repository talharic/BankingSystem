package com.example.bankingsystem.service;

import com.example.bankingsystem.converter.CustomerConverter;
import com.example.bankingsystem.dto.CustomerDto;
import com.example.bankingsystem.entity.Customer;
import com.example.bankingsystem.service.entityservice.CustomerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerEntityService customerEntityService;
    private final CustomerConverter customerConverter;

    @Autowired
    public CustomerService(CustomerEntityService customerEntityService, CustomerConverter customerConverter) {
        this.customerEntityService = customerEntityService;
        this.customerConverter = customerConverter;
    }

    public List<CustomerDto> findAll() {
        List<Customer> customerList = customerEntityService.findAll();
        List<CustomerDto> customerDtoList = customerConverter.converterToCustomerDtoList(customerList);
        return customerDtoList;
    }
}
