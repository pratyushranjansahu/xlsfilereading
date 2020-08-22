package com.example.XLSReading.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PinCodeRepository extends CrudRepository<PinCodeEntity, Integer>{

}
