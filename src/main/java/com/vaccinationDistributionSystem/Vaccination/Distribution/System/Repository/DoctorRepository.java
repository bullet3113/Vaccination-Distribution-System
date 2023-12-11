package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Repository;

import com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO.VaccinationCentersVsDoctorCount;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

//    @Query(value = "select vaccination_center_vcid, count(*) as totalDocCount from doctor group by vaccination_center_vcid", nativeQuery = true)
    @Query(value = "select vaccination_center.vcid, count(*) from doctor right join vaccination_center on vaccination_center.vcid = doctor.vaccination_center_vcid group by vaccination_center.vcid;", nativeQuery = true)
    public List<Object []> getVaccinationCentersVsDoctorCount();

    @Query(value = "select d.docid, count(*) from doctor as d left join patient as p on d.docid = p.doctor_docid where d.vaccination_center_vcid = :centerId group by d.docid order by count(*) asc", nativeQuery = true)
//    @Query(value = "select d.docid, d.patient_count from doctor d where d.vaccination_center_vcid = :centerId order by d.patient_count asc", nativeQuery = true)
    public List<Object []> getMinPatientDoctor(int centerId);
}

