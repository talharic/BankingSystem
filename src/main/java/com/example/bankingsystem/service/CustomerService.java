package com.example.bankingsystem.service;

import com.example.bankingsystem.converter.CustomerConverter;
import com.example.bankingsystem.converter.CustomerMapper;
import com.example.bankingsystem.dto.CustomerSaveRequestDto;
import com.example.bankingsystem.dto.CustomerDto;
import com.example.bankingsystem.entity.Customer;
import com.example.bankingsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerConverter customerConverter) {
        this.customerRepository = customerRepository;
        this.customerConverter = customerConverter;
    }

    public List<CustomerDto> findAll() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = customerConverter.converterToCustomerDtoList(customerList);
        return customerDtoList;
    }

    public CustomerDto save(CustomerSaveRequestDto customerSaveRequestDto) {
        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(customerSaveRequestDto);
        customer = customerRepository.save(customer);
        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);
        return customerDto;
    }
}
