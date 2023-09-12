package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.AddressDto;

import java.util.List;

public interface AddressService {
    public List<AddressDto> getAllAddresses();
}
