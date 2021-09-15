package com.API.jsonExempledb.repository;

import org.springframework.data.repository.CrudRepository;

import com.API.jsonExempledb.model.MedicalRecord;



public interface MedicalRecordRepository extends  CrudRepository<MedicalRecord, Long> {

}
