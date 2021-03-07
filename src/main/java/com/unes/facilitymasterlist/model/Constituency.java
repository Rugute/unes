package com.unes.facilitymasterlist.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

public class Constituency {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(15)")
    private UUID id;

    @Column(name = "constituency_name")
    private String constituency_name;

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

    public String getConstituency_name() {
        return constituency_name;
    }

    public void setConstituency_name(String constituency_name) {
        this.constituency_name = constituency_name;
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
}
