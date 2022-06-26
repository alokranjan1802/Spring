package com.example.demo.service;

import java.util.List;

import com.example.demo.patientbeans.patients;

public interface patientService {
	List<patients> getPatientsList() throws Exception;
	int addPatient(patients patient) throws Exception;
	patients updatePatient (patients patient) throws Exception;
	patients deletePatient (int id) throws Exception;
	patients getPatientbyId (int id) throws Exception;

}
