package com.API.jsonExempledb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.jsonExempledb.model.MedicalRecord;
import com.API.jsonExempledb.service.MedicalRecordService;


@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {
	private MedicalRecordService medicalrecordService;

	public MedicalRecordController(MedicalRecordService medicalrecordService) {
	        this.medicalrecordService = medicalrecordService;
	    }

	@GetMapping("/listMD")
	public Iterable<MedicalRecord> list() {
		return medicalrecordService.list();
	}

}
