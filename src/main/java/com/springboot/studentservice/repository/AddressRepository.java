package com.springboot.studentservice.repository;

import com.springboot.studentservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Modifying
    @Transactional
    @Query(
         value="Delete from Address where address_id = ?1" ,
         nativeQuery = true
    )
    public int deleteAddressById(int id);



}
