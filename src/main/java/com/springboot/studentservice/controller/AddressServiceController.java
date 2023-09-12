package com.springboot.studentservice.controller;

import com.springboot.studentservice.dto.AddressDto;
import com.springboot.studentservice.model.AddressResponseModel;
import com.springboot.studentservice.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressServiceController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressResponseModel>> getAllAddresses(){
        List<AddressDto> addressDtoList = new ArrayList<>();
        List<AddressResponseModel> addressResponseModelList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        addressDtoList = addressService.getAllAddresses();

        addressDtoList.forEach((address)->{
            AddressResponseModel addressResponseModel = modelMapper.map(address, AddressResponseModel.class);
            addressResponseModelList.add(addressResponseModel);
        });
        return new ResponseEntity<>(addressResponseModelList, HttpStatus.OK);
    }
}
