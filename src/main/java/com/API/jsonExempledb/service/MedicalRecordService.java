package com.API.jsonExempledb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.API.jsonExempledb.model.MedicalRecord;
import com.API.jsonExempledb.model.Medications;
import com.API.jsonExempledb.repository.MedicalRecordRepository;


@Service
public class MedicalRecordService {

	private MedicalRecordRepository medicalrecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalrecordRepository) {
        this.medicalrecordRepository = medicalrecordRepository;
    }
    public Iterable<MedicalRecord> list() {
        return medicalrecordRepository.findAll();
    }
    public MedicalRecord save(MedicalRecord medicalrecord){
        return medicalrecordRepository.save(medicalrecord);
    }
	public void save(List<MedicalRecord> medicalrecords) {
		medicalrecordRepository.saveAll(medicalrecords);
		
	}
	
}
