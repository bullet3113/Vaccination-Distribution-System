package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity;

import jakarta.persistence.*;

@Entity
public class Certificates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cid;

    @OneToOne
    Patient patient;

    public Certificates() {
    }

    public Certificates(int cid, Patient patient) {
        this.cid = cid;
        this.patient = patient;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
