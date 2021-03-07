package com.unes.facilitymasterlist.repository;

import com.unes.facilitymasterlist.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("facilityRepository")
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    List<Facility> findAll();
    // Facility findById(int qid);
    List<Facility> findByFacilityname(String name);

    List<Facility> findAllById(UUID uuid);
    // List<Facility> findByFacility_nameAndConstituency_id(String name,String constituency);
}
