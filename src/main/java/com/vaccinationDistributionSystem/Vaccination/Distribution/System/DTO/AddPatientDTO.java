package com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO;

import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Enums.CenterPreferenceEnum;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Enums.VaccinePreferenceEnum;

public class AddPatientDTO {

    String name;
    CenterPreferenceEnum centerPreferenceEnum;
    VaccinePreferenceEnum vaccinePreferenceEnum;
    int phone;
    String email;



    public AddPatientDTO(String name, CenterPreferenceEnum centerPreferenceEnum, VaccinePreferenceEnum vaccinePreferenceEnum, int phone, String email) {
        this.name = name;
        this.centerPreferenceEnum = centerPreferenceEnum;
        this.vaccinePreferenceEnum = vaccinePreferenceEnum;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CenterPreferenceEnum getCenterPreferenceEnum() {
        return centerPreferenceEnum;
    }

    public void setCenterPreferenceEnum(CenterPreferenceEnum centerPreferenceEnum) {
        this.centerPreferenceEnum = centerPreferenceEnum;
    }

    public VaccinePreferenceEnum getVaccinePreferenceEnum() {
        return vaccinePreferenceEnum;
    }

    public void setVaccinePreferenceEnum(VaccinePreferenceEnum vaccinePreferenceEnum) {
        this.vaccinePreferenceEnum = vaccinePreferenceEnum;
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
}
