package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Service;

import com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO.AddVaccinationCenterDTO;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO.ResponseDTO.CenterNameDoseType;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception.VaccinationCenterNotFoundException;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public void addVaccinationCenter(AddVaccinationCenterDTO vaccinationCenterDetails) {
        VaccinationCenter obj = new VaccinationCenter();
        obj.setCenterName(vaccinationCenterDetails.getCenterName());
        obj.setCovaxinDose(vaccinationCenterDetails.getCovaxinDose());
        obj.setSputnikDose(vaccinationCenterDetails.getSputnikDose());
        obj.setCovishieldDose(vaccinationCenterDetails.getCovishieldDose());
        obj.setAddress(vaccinationCenterDetails.getAddress());
        obj.setType(vaccinationCenterDetails.getType().toString());
        vaccinationCenterRepository.save(obj);
    }


    public List<VaccinationCenter> searchByName(String name) {
        List<VaccinationCenter> list = vaccinationCenterRepository.findBycenterName(name);
        if(list.size() == 0) throw new VaccinationCenterNotFoundException("No Such Centers Found");
        return list;
    }

    public List<CenterNameDoseType> getDoseCount(String centerName, String doseType) {
        List<VaccinationCenter> allVaccinationCenters = vaccinationCenterRepository.findBycenterName(centerName);
        if(allVaccinationCenters.size() == 0) throw new VaccinationCenterNotFoundException("No Such Centers Found");

        List<CenterNameDoseType> allVaccinationCentersParticularDoseType = new ArrayList<>();

        for(VaccinationCenter obj: allVaccinationCenters) {
            CenterNameDoseType temp = new CenterNameDoseType();
            temp.setCenterName(obj.getCenterName());
            temp.setDoseType(doseType);
            if(doseType.toLowerCase().equals("sputnik")) temp.setDoseCount(obj.getSputnikDose());
            else if(doseType.toLowerCase().equals("covaxin")) temp.setDoseCount(obj.getCovaxinDose());
            else if(doseType.toLowerCase().equals("covishield")) temp.setDoseCount(obj.getCovishieldDose());
            allVaccinationCentersParticularDoseType.add(temp);
        }

        return allVaccinationCentersParticularDoseType;
    }

    public VaccinationCenter getById(int vcid) {
        return vaccinationCenterRepository.findById(vcid).orElse(null);
    }
}
