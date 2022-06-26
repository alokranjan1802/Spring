package com.example.demo.requestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.patientbeans.patients;
import com.example.demo.service.patientService;
import com.example.demo.service.patientServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000")
public class RequestController {
	
	@Autowired
	private patientService patients_service;
	
	@RequestMapping(value="pat/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<patients>> getpatientsDetails() throws Exception{
		
		List <patients> listPatients = patients_service.getPatientsList();
		System.out.println(listPatients);
		return new ResponseEntity<List<patients>> (listPatients, HttpStatus.OK);
	}
//	@RequestMapping(value="pat/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
//	public String getpatientsDetails() throws Exception{
//		
//		//List <patients> listPatients = patients_service.getPatientsList();
//		//System.out.println(listPatients);
//		return "Hi";
//	}
	
	@RequestMapping(value="pat/addPatient",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> addPatient(@RequestBody patients patient) throws Exception{
		System.out.println(patient.getName());
		
		int id = patients_service.addPatient(patient);
		
		return new ResponseEntity<String> ("Employee added with id: "+id, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="pat/updatePatient",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<patients> updatePatient(@RequestBody patients patient) throws Exception{
		
		patients pn = patients_service.updatePatient(patient);
		//System.out.println(listPatients);
		return new ResponseEntity<patients> (pn, HttpStatus.OK);
	}
	
	@RequestMapping(value="pat/deletePatient/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<patients> deletePatient(@PathVariable("id") int patientId) throws Exception{
		
		patients pn = patients_service.deletePatient(patientId);
		//System.out.println(listPatients);
		return new ResponseEntity<patients> (pn, HttpStatus.OK);
	}
	@RequestMapping(value="pat/getDetailsbyId/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<patients> getpatientDetailsbyId(@PathVariable("id") int myId) throws Exception{
		System.out.println(myId);
		System.out.println(myId);
		patients patient = patients_service.getPatientbyId(myId);
		return new ResponseEntity<patients> (patient, HttpStatus.OK);
	}

}
