package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities_package.patientsEntity;

public interface patientDAO extends JpaRepository<patientsEntity, Integer> {

}
