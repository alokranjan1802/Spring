package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.patientDAOImpl;

import beans.patients;
@Service
public class patientServiceImpl implements patientService {
	
	
	@Autowired
	private patientDAOImpl patient_DAO_Impl;
	
	public List<patients> getPatientsList() throws Exception {
		return patient_DAO_Impl.findAll();
	}

}
