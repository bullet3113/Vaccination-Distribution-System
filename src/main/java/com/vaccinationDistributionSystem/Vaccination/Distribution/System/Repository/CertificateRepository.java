package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Repository;

import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity.Certificates;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificates, Integer> {

    @Query(value = "select * from certificates where patient_pid = :pId", nativeQuery = true)
    public Certificates findByPatient(int pId);
}
