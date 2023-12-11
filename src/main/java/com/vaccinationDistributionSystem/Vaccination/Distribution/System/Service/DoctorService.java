package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Service;

import com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO.AddDoctorDTO;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO.VaccinationCentersVsDoctorCount;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity.Doctor;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception.VaccinationCenterNotFoundException;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    VaccinationCenterService vaccinationCenterService;

    public void addDoctor(AddDoctorDTO obj) {

        List<Object []> data = doctorRepository.getVaccinationCentersVsDoctorCount();
        if(data.size() == 0) throw new VaccinationCenterNotFoundException("No Vaccination Centers Exist");

        int minVcid = 1;
        int minDocCount = Integer.MAX_VALUE;

        for(Object[] d: data) {
            System.out.println(Integer.parseInt(d[0].toString()) + " " + Integer.parseInt(d[1].toString()));
            if(Integer.parseInt(d[1].toString()) < minDocCount) {
                minVcid = Integer.parseInt(d[0].toString());
                minDocCount = Integer.parseInt(d[1].toString());
            }
        }

        Doctor doc = new Doctor();
        doc.setName(obj.getName());
        doc.setDegree(obj.getDegree());
        doc.setVaccinationCenter(vaccinationCenterService.getById(minVcid));

        doctorRepository.save(doc);
    }
}
