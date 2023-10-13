package com.example.bankingsystem.converter;

import com.example.bankingsystem.dto.CustomerDto;
import com.example.bankingsystem.dto.CustomerSaveRequestDto;
import com.example.bankingsystem.dto.CustomerUpdateRequestDto;
import com.example.bankingsystem.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customer convertToCustomer(CustomerSaveRequestDto customerSaveRequestDto);
    Customer convertToCustomer(CustomerUpdateRequestDto customerUpdateRequestDto);
    List<CustomerDto> converterToCustomerDtoList(List<Customer> customerList);
    CustomerDto convertToCustomerDto(Customer customer);
}
