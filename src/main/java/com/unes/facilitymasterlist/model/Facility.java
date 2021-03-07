package com.unes.facilitymasterlist.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @Column(name = "facility_name")
    private String facilityname;

    @Column(name = "mflcode")
    private String mflcode;

    @Column(name = "county_id")
    private int county_id;

    @Column(name = "sub_county_id")
    private int subcountyid;

    @Column(name = "constituency_id")
    private int constituency_id;

    @Column(name = "ward_id")
    private int ward_id;

    @Column(name="created_by")
    private int created_by;

    @Column(name="created_on")
    private Date created_on;

    @Column(name="modified_by", nullable=true)
    private int modified_by;

    @Column(name="modified_on", nullable=true)
    private Date modified_on;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFacility_name() {
        return facilityname;
    }

    public void setFacility_name(String facilityname) {
        this.facilityname = facilityname;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public int getModified_by() {
        return modified_by;
    }

    public void setModified_by(int modified_by) {
        this.modified_by = modified_by;
    }

    public Date getModified_on() {
        return modified_on;
    }

    public void setModified_on(Date modified_on) {
        this.modified_on = modified_on;
    }

    public String getMflcode() {
        return mflcode;
    }

    public void setMflcode(String mflcode) {
        this.mflcode = mflcode;
    }

    public int getCounty_id() {
        return county_id;
    }

    public void setCounty_id(int county_id) {
        this.county_id = county_id;
    }

    public int getSub_county_id() {
        return subcountyid;
    }

    public void setSub_county_id(int sub_county_id) {
        this.subcountyid = sub_county_id;
    }

    public int getConstituency_id() {
        return constituency_id;
    }

    public void setConstituency_id(int constituency_id) {
        this.constituency_id = constituency_id;
    }

    public int getWard_id() {
        return ward_id;
    }

    public void setWard_id(int ward_id) {
        this.ward_id = ward_id;
    }
}
