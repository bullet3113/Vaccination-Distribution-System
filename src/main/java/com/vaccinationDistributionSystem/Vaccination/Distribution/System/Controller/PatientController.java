package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Controller;

import com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO.AddPatientDTO;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity.Patient;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception.AlreadyGotVaccinatedException;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception.DoctorNotExistException;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception.PatientNotExistException;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception.VaccinationCenterNotFoundException;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity addPatient(@RequestBody AddPatientDTO obj) {
        try {
            patientService.addPatient(obj);
            return new ResponseEntity("Patient added successfully", HttpStatus.CREATED);
        } catch (DoctorNotExistException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (VaccinationCenterNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/givedose")
    public ResponseEntity giveDose(@RequestParam int pId) {
        try {
            patientService.provideDoseToPatient(pId);
            return new ResponseEntity<>("Patient vaccinated Successfully", HttpStatus.OK);
        } catch (AlreadyGotVaccinatedException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        } catch (PatientNotExistException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/find")
    public ResponseEntity getPatientById(@RequestParam int pId) {
        try {
            return new ResponseEntity(patientService.getPatientById(pId), HttpStatus.OK);
        } catch (PatientNotExistException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
