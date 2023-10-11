package com.example.bankingsystem.converter;

import com.example.bankingsystem.dto.CustomerDto;
import com.example.bankingsystem.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerConverter {

    public List<CustomerDto> converterToCustomerDtoList(List<Customer> customerList) {
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDto customerDto = convertToCustomerDto(customer);
            customerDtoList.add(customerDto);
        }
        return  customerDtoList;
    }

    public CustomerDto convertToCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customerDto.getName());
        customerDto.setSurname(customerDto.getSurname());
        customerDto.setIdentityNo(customerDto.getIdentityNo());
        return customerDto;
    }
}
