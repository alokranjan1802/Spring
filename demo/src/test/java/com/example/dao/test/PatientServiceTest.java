package com.example.dao.test;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.slf4j.LoggerFactory;

import com.example.demo.DemoApplication;
import com.example.demo.patientbeans.patients;
import com.example.demo.service.patientServiceImpl;

import org.junit.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=DemoApplication.class)

@Transactional
public class PatientServiceTest {
	
	private Logger logger = LoggerFactory.getLogger(PatientServiceTest.class);
	
	{System.out.println("Hi");}

	
	@Autowired
	private patientServiceImpl pnService;
	
	@Before
	public void testMethodBeforeInterceptor() {
		logger.info("Starting a new Test Method..");
	}
	
	@After
	public void testMethodAfterInterceptor() {
		logger.info("Ending a new Test Method..");
	}
	
	@Test
	public void testFindAll() throws Exception{
		List<patients> pnlist = pnService.getPatientsList();
		System.out.println(pnlist.size());
		logger.info(pnlist.toString());
		Assert.assertTrue(pnlist != null);
	}
	
	@Test
	public void testUpdateValid() {
		patients pnupdate = new patients(1,"DEF",30); 
		patients pn = pnService.updatePatient(pnupdate);
		Assert.assertTrue(pn.getName() ==  "DEF");
	}
	
	@Test
	public void testDeleteValid() {
		patients pn = pnService.deletePatient(1);
		Assert.assertTrue(pn.getId() ==  1);
	}
	
//	@Test
//	public void testUpdateValid() {
//		patients pnupdate = new patients(1,"DEF",30); 
//		patients pn = pnService.updatePatient(pnupdate);
//		Assert.assertTrue(pn.getName() ==  "DEF");
//	}
	
}
