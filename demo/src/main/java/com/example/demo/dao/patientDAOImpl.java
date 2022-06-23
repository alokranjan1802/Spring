package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import beans.patients;
import entities_package.patientsEntity;

@Repository
public class patientDAOImpl {
	
	private patientDAO dao;
	
	public List<patients> findAll() {
		List<patients> list = new ArrayList<patients>();
		
		Iterable<patientsEntity> listEn= dao.findAll();
		
		listEn.forEach(x->{
			
			patients patient = new patients();
			BeanUtils.copyProperties(x, patient);
			list.add(patient);
		});
		
		
		
//		patients patient = new patients(1,"a",25);
//		list.add(patient);
		
		System.out.println(list.size());
		return list;
	}

}
