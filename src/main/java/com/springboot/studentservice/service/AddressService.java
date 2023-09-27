package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.AddressDto;

import java.util.List;

public interface AddressService {
    public List<AddressDto> getAllAddresses();

    public  AddressDto addAddress(AddressDto addressDto);

    public AddressDto updateAddress(AddressDto addressDto);

    public void deleteAddress(Long id);
}
