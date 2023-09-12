package com.springboot.studentservice.repository;

import com.springboot.studentservice.entity.Address;
import com.springboot.studentservice.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class AddressRepositoryTest {
    
    @Autowired
    private AddressRepository addressRepository;

    // insert into address table
//    @Test
//    public void saveAddress() throws Exception{
//
//        Student student = new Student();
//        student.setEmail("doealexander@hotmail.com");
//        student.setEnterYear(2020);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date birthDate = dateFormat.parse("2016-09-16");
//        student.setBirthDate(birthDate);
//        student.setFirstName("Alexander");
//        student.setLastName("Doe");
//
//
//        Address address = new Address();
//
//        address.setStu_add_street("123 Main Street");
//        address.setStu_add_city("Springfield");
//        address.setStu_add_state("CA");
//        address.setStu_add_country("USA");
//        address.setStudent(student);
//
//        addressRepository.save(address);
//    }

    // delete address
    @Test
    public void deleteAddressById(){
        int id = 1;
        addressRepository.deleteAddressById(id);

    }

    // update address
    @Test
    public void updateAddressById(){
        addressRepository.updateAddressById("CA", 1);
    }


    @Test
    public void getAllAddresses(){
        List<Address> addressList = addressRepository.findAll();
        System.out.println("addressList = " + addressList);
    }

    
}
