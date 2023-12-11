package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Repository;

import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {

    public List<VaccinationCenter> findBycenterName(String name);

    @Query(value = "select vc.vcid, count(*) from vaccination_center as vc left join patient p on p.vaccination_center_vcid = vc.vcid where vc.type = :type group by vc.vcid order by count(*) asc", nativeQuery = true)
    List<Object []> getMinPatientVaccineCenter(String type);
}
