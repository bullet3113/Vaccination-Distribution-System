package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Controller;

import com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO.AddDoctorDTO;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception.VaccinationCenterNotFoundException;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody AddDoctorDTO doctorDTO) {

        try {
            doctorService.addDoctor(doctorDTO);
            return new ResponseEntity("Doctor added Successfully", HttpStatus.CREATED);
        } catch (VaccinationCenterNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
