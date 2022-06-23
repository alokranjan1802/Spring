package requestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.patientService;

import beans.patients;

@RestController
public class RequestController {
	
	@Autowired
	private patientService patients_service;
	
	@RequestMapping(value="pat/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<patients>> getpatientsDetails() throws Exception{
		
		List <patients> listPatients = patients_service.getPatientsList();
		System.out.println(listPatients);
		return new ResponseEntity<List<patients>> (listPatients, HttpStatus.OK);
	}
	
	

}
