package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.patientDAO;
import com.example.demo.dao.PatientDAOWrapper;
import com.example.demo.entities.patientsEntity;
import com.example.demo.patientbeans.patients;
@Service
public class patientServiceImpl implements patientService {
	
	
	@Autowired
	//private PatientDAOWrapper patient_DAO_Wrapper;
	private PatientDAOWrapper patient_DAO_Wrapper;
	
	public List<patients> getPatientsList() throws Exception {
		
//		List<patients> list = new ArrayList<patients>();
//		
//		Iterable<patientsEntity> listEn= patient_DAO_Impl.findAll();
//		
//		listEn.forEach(x->{
//			
//			patients patient = new patients();
//			BeanUtils.copyProperties(x, patient);
//			list.add(patient);
//		});
//		return list;
		return patient_DAO_Wrapper.findAll();

	}
	
	public int addPatient(patients patient) {
		int result=patient_DAO_Wrapper.savePatient(patient);
		return result;
	}
	
	public patients deletePatient(int id) {
		patients patient = patient_DAO_Wrapper.findOne(id);
		if(patient != null) {
			patient_DAO_Wrapper.delete(id);
		}
		return patient;
	}
	
	public patients updatePatient(patients patient) {
//		patientsEntity p_Entity=new patientsEntity();
//		BeanUtils.copyProperties(patient, p_Entity);
//		patientsEntity p_en= dao.save(p_Entity);
//		
//		patients pn=new patients();
//		
//		BeanUtils.copyProperties(p_en, pn);
//		return pn;
		
		
		patients pn = patient_DAO_Wrapper.findOne(patient.getId());
		
		if(pn!=null) {
			patient = patient_DAO_Wrapper.updatePatient(patient);
		}
		return patient;
	}
	
	public patients getPatientbyId (int id) {
		patients patient = patient_DAO_Wrapper.findOne(id);
		return patient;
	}

}
