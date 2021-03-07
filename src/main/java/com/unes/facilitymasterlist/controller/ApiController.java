package com.unes.facilitymasterlist.controller;

import com.unes.facilitymasterlist.model.Facility;
import com.unes.facilitymasterlist.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest/v1/api")
public class ApiController {
    @Autowired
    private FacilityService facilityService;
    @RequestMapping(value="/getfacilities", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<Facility> getFacilities() {
        Date nowdate = new Date();
        Facility facility = new Facility();
        facility.setFacility_name("Kibwezi Doctors Plaza");
        facility.setMflcode("12345");
        facility.setConstituency_id(1);
        facility.setCounty_id(1);
        facility.setCreated_by(1);
        facility.setCreated_on(nowdate);
        facility.setWard_id(1);
        facilityService.save(facility);
        List<Facility> facilityList = facilityService.getAllFacilities();

        return facilityList;
    }
}
