package com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO;

import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Enums.CenterPreferenceEnum;

public class AddVaccinationCenterDTO {

    String centerName;
    int covaxinDose;
    int covishieldDose;
    int sputnikDose;
    CenterPreferenceEnum type;
    String address;

    public AddVaccinationCenterDTO(String centerName, int covaxinDose, int covishieldDose, int sputnikDose, CenterPreferenceEnum type, String address) {
        this.centerName = centerName;
        this.covaxinDose = covaxinDose;
        this.covishieldDose = covishieldDose;
        this.sputnikDose = sputnikDose;
        this.type = type;
        this.address = address;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public int getCovaxinDose() {
        return covaxinDose;
    }

    public void setCovaxinDose(int covaxinDose) {
        this.covaxinDose = covaxinDose;
    }

    public int getCovishieldDose() {
        return covishieldDose;
    }

    public void setCovishieldDose(int covishieldDose) {
        this.covishieldDose = covishieldDose;
    }

    public int getSputnikDose() {
        return sputnikDose;
    }

    public void setSputnikDose(int sputnikDose) {
        this.sputnikDose = sputnikDose;
    }

    public CenterPreferenceEnum getType() {
        return type;
    }

    public void setType(CenterPreferenceEnum type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
