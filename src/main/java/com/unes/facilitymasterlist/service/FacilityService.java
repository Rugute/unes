package com.unes.facilitymasterlist.service;

import com.unes.facilitymasterlist.model.Facility;
import com.unes.facilitymasterlist.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("facilityService")
public class FacilityService {
    Date nowDate = new Date();
    private FacilityRepository  facilityRepository;
    @Autowired
    public FacilityService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public Facility save(Facility facility) {
        return facilityRepository.save(facility);
    }
    public void delete(Facility facility){
        facilityRepository.delete(facility);
    }
    public List<Facility> getAllFacilities(){return  facilityRepository.findAll();}
    public List<Facility> getFacilitiesByName(String name){
        return  facilityRepository.findByFacilityname(name);
    }
    public List<Facility> getFacilityByUUI(UUID uuid){
        return  facilityRepository.findAllById(uuid);
    }
   }
