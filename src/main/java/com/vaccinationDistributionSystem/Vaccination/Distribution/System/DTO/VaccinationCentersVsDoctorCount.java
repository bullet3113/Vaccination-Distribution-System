package com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VaccinationCentersVsDoctorCount {

    Integer vaccinationId;
    Integer totalDocCount;
}
