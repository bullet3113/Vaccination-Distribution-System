package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity;

import jakarta.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int pid;
    String name;
    String vaccinePreference;
    String centerPreference;

    @ManyToOne
    VaccinationCenter vaccinationCenter;

    @ManyToOne
    Doctor doctor;

    @Column(unique = true)
    int phone;
    @Column(unique = true)
    String email;

    @OneToOne
    Certificates certificates;

    boolean isVaccinated;

    public Patient() {
    }

    public Patient(int pid, String name, String vaccinePreference, String centerPreference, VaccinationCenter vaccinationCenter, Doctor doctor, int phone, String email, Certificates certificates, boolean isVaccinated) {
        this.pid = pid;
        this.name = name;
        this.vaccinePreference = vaccinePreference;
        this.centerPreference = centerPreference;
        this.vaccinationCenter = vaccinationCenter;
        this.doctor = doctor;
        this.phone = phone;
        this.email = email;
        this.certificates = certificates;
        this.isVaccinated = isVaccinated;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVaccinePreference() {
        return vaccinePreference;
    }

    public void setVaccinePreference(String vaccinePreference) {
        this.vaccinePreference = vaccinePreference;
    }

    public String getCenterPreference() {
        return centerPreference;
    }

    public void setCenterPreference(String centerPreference) {
        this.centerPreference = centerPreference;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Certificates getCertificates() {
        return certificates;
    }

    public void setCertificates(Certificates certificates) {
        this.certificates = certificates;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }
}
