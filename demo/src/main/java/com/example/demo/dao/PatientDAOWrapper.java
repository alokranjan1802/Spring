package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.patientsEntity;
import com.example.demo.patientbeans.patients;

@Repository
//@Transactional
public class PatientDAOWrapper {
	@Autowired
	//@Lazy
	private patientDAO dao;
	
	public List<patients>findAll() {
		List<patients> list = new ArrayList<patients>();
		
		Iterable<patientsEntity> listEn= dao.findAll();
		
		listEn.forEach(x->{
			
			patients patient = new patients();
			BeanUtils.copyProperties(x, patient);
			list.add(patient);
		});
		
		
		
//		patients patient = new patients(1,"a",25);
//		list.add(patient);
		
//		System.out.println(list.size());
//		if(list.size()!=0) {
//			return list;
//
//		}
//		
//		patients patient = new patients(1,"a",25);
//		list.add(patient);
		return list;
	}
	
	public Integer savePatient(patients patient) {
		patientsEntity patient_Entity = new patientsEntity();
		BeanUtils.copyProperties(patient, patient_Entity);
		System.out.println(patient_Entity.getName());
		patientsEntity p_entity = dao.save(patient_Entity);
		return p_entity.getId();
	}
	
	public patients updatePatient(patients patient) {
		patientsEntity patient_Entity = new patientsEntity();
		BeanUtils.copyProperties(patient, patient_Entity);
		System.out.println(patient_Entity.getAge());
		patientsEntity p_entity= dao.save(patient_Entity);
		patients pn=new patients();
		
		BeanUtils.copyProperties(p_entity, pn);
		return pn;
	}
	
	public void delete (Integer id) {
		dao.deleteById(id);
	}
	
	public patients findOne(Integer id) {
		System.out.println(id.getClass());
		patientsEntity p_en= dao.findById(id).orElse(null);
		System.out.println(p_en.getId());
		patients patient=new patients();
		if(p_en != null) {
			BeanUtils.copyProperties(p_en, patient);
		}
		return patient;
	}
	
}
