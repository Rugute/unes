package com.unes.facilitymasterlist;


import com.unes.facilitymasterlist.service.FacilityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class FacilitymasterlistApplicationTests {
	@Autowired
	private FacilityService facilityService;
	/*@Autowired
	private Facility facility;*/

	@Test
	void contextLoads() {
		Date nowdate = new Date();
		/*Facility facility = new Facility();
		facility.setFacility_name("Kibwezi Doctors Plaza");
		facility.setMflcode("12345");
		facility.setConstituency_id(1);
		facility.setCounty_id(1);
		facility.setCreated_by(1);
		facility.setCreated_on(nowdate);
		facility.setWard_id(1);
		facilityService.save(facility);*/
	}



}
