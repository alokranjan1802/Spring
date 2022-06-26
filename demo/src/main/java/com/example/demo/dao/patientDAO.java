package com.example.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.patientsEntity;
import com.example.demo.patientbeans.patients;

//public interface patientDAO extends JpaRepository<patientsEntity, Integer> {
//	
//	//public List<patients> findAll();
//
//}
public interface patientDAO extends JpaRepository<patientsEntity, Integer> {
}