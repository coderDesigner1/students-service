package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.AddressDto;
import com.springboot.studentservice.entity.Address;
import com.springboot.studentservice.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<AddressDto> getAllAddresses() {
        Iterable<Address> addresses = addressRepository.findAll();
        List<AddressDto> addressDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        addresses.forEach((address)->{
            AddressDto addressDto = modelMapper.map(address, AddressDto.class);
            addressDtoList.add(addressDto);
        });
        return addressDtoList;
    }
}
