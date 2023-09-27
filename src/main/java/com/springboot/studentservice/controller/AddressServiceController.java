package com.springboot.studentservice.controller;

import com.springboot.studentservice.dto.AddressDto;
import com.springboot.studentservice.model.AddressRequestModel;
import com.springboot.studentservice.model.AddressResponseModel;
import com.springboot.studentservice.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addAddress")
    public ResponseEntity<String> addAddress(@RequestBody AddressRequestModel addressRequestModel){
        ModelMapper modelMapper = new ModelMapper();
        AddressDto addressDto = modelMapper.map(addressRequestModel, AddressDto.class);
        AddressDto addressDto1 = addressService.addAddress(addressDto);
        return new ResponseEntity<>(addressDto1.getStu_address_id()+" Address Created", HttpStatus.CREATED);
    }

    @PutMapping("/updateAddress")
    public ResponseEntity<String> updateAddress(@RequestBody AddressRequestModel addressRequestModel){
        ModelMapper modelMapper = new ModelMapper();
        AddressDto addressDto = modelMapper.map(addressRequestModel, AddressDto.class);
        AddressDto addressDto1 = addressService.updateAddress(addressDto);
        return new ResponseEntity<>(addressDto1.getStu_address_id()+"Updated Address", HttpStatus.OK);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>("Deleted Address "+ id, HttpStatus.OK);
    }
}
