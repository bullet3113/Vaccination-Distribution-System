package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Repository;

import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {


}
