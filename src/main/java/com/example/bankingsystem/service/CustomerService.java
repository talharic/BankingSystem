package com.example.bankingsystem.service;

import com.example.bankingsystem.converter.CustomerConverter;
import com.example.bankingsystem.converter.CustomerMapper;
import com.example.bankingsystem.dto.CustomerSaveRequestDto;
import com.example.bankingsystem.dto.CustomerDto;
import com.example.bankingsystem.entity.Customer;
import com.example.bankingsystem.exception.ItemNotFountException;
import com.example.bankingsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return customerConverter.converterToCustomerDtoList(customerList);
    }

    public CustomerDto save(CustomerSaveRequestDto customerSaveRequestDto) {
        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(customerSaveRequestDto);
        customer = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.convertToCustomerDto(customer);
    }

    public void delete(Long id) {
        Customer customer = getByIdWithCheck(id);
        customerRepository.delete(customer);
    }

    public CustomerDto findById(Long id) {
        Customer customer = getByIdWithCheck(id);
        return CustomerMapper.INSTANCE.convertToCustomerDto(customer);
    }

    public Customer getByIdWithCheck(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        Customer customer;
        if (customerOptional.isPresent()) {
            customer = customerOptional.get();
        } else {
            throw new ItemNotFountException("Customer Not Found");
        }
        return customer;
    }
}
