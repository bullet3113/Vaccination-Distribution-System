package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Controller;

import com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO.AddVaccinationCenterDTO;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO.ResponseDTO.CenterNameDoseType;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception.VaccinationCenterNotFoundException;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccinationcenter")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add")
    public String addVaccinationCenter(@RequestBody AddVaccinationCenterDTO obj) {
        vaccinationCenterService.addVaccinationCenter(obj);
        return "Center added successfully";
    }

    @GetMapping("/find")
    public ResponseEntity searchByName(@RequestParam String name) {
        try {
            return new ResponseEntity(vaccinationCenterService.searchByName(name), HttpStatus.OK);
        } catch (VaccinationCenterNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/{centerName}")
    public ResponseEntity getDoseCount(@PathVariable String centerName, @RequestParam String doseType) {
        try {
            return new ResponseEntity(vaccinationCenterService.getDoseCount(centerName, doseType), HttpStatus.OK);
        } catch (VaccinationCenterNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
