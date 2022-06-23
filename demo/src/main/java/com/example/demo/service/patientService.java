package com.example.demo.service;

import java.util.List;

import beans.patients;

public interface patientService {
	List<patients> getPatientsList() throws Exception;

}
