package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int docid;
    String name;
    String degree;

    @ManyToOne
    VaccinationCenter vaccinationCenter;

    @OneToMany(mappedBy = "doctor")
    List<Patient> patients;

    int patientCount;

    public Doctor() {
    }

    public Doctor(int docid, String name, String degree, VaccinationCenter vaccinationCenter, int patientCount) {
        this.docid = docid;
        this.name = name;
        this.degree = degree;
        this.vaccinationCenter = vaccinationCenter;
        this.patientCount = patientCount;
    }

    public int getDocid() {
        return docid;
    }

    public void setDocid(int docid) {
        this.docid = docid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public int getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }
}
