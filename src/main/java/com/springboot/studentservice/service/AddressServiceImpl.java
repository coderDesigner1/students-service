package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.AddressDto;
import com.springboot.studentservice.dto.StudentDetailsDto;
import com.springboot.studentservice.entity.Address;
import com.springboot.studentservice.entity.Student;
import com.springboot.studentservice.exception.NotFoundException;
import com.springboot.studentservice.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    @Override
    public AddressDto addAddress(AddressDto addressDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Address address = modelMapper.map(addressDto, Address.class);

        addressRepository.save(address);
        modelMapper.createTypeMap(Address.class, AddressDto.class)
                .addMapping(Address::getStu_address_id, AddressDto::setStu_address_id);
        return modelMapper.map(address, AddressDto.class);
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
       Address address = modelMapper.map(addressDto, Address.class);
        addressRepository.save(address);
        modelMapper.createTypeMap(Address.class, AddressDto.class)
                .addMapping(Address::getStu_address_id, AddressDto::setStu_address_id);
        return modelMapper.map(address, AddressDto.class);

    }

    @Override
    public void deleteAddress(Long id) {
        try{
            addressRepository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new NotFoundException("Unable to delete address as it is referenced in Student");
        }


    }


}
