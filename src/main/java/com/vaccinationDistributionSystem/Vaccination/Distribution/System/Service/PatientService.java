package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Service;

import com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO.AddPatientDTO;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity.Certificates;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity.Patient;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception.AlreadyGotVaccinatedException;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception.DoctorNotExistException;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception.PatientNotExistException;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception.VaccinationCenterNotFoundException;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Repository.CertificateRepository;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Repository.DoctorRepository;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Repository.PatientRepository;
import com.vaccinationDistributionSystem.Vaccination.Distribution.System.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    CertificateRepository certificateRepository;

    public void addPatient(AddPatientDTO obj) {
        Patient p = new Patient();

        p.setName(obj.getName());
        p.setCenterPreference(obj.getCenterPreferenceEnum().toString());
        p.setEmail(obj.getEmail());
        p.setPhone(obj.getPhone());
        p.setVaccinePreference(obj.getVaccinePreferenceEnum().toString());

        List<Object[]> vaccinationCenterVsPatient  = vaccinationCenterRepository.getMinPatientVaccineCenter(obj.getCenterPreferenceEnum().toString());
        if(vaccinationCenterVsPatient.size() == 0) {
            throw new VaccinationCenterNotFoundException("Vaccination Center Not Found");
        }

        Object[] arr = vaccinationCenterVsPatient.get(0);
        int minId = Integer.parseInt(arr[0].toString());
        p.setVaccinationCenter(vaccinationCenterRepository.findById(minId).orElse(null));

        System.out.println(minId);
        List<Object []> doctorVsPatient = doctorRepository.getMinPatientDoctor(minId);
        if(doctorVsPatient.size() == 0) {
            throw new DoctorNotExistException("Doctor not found");
        }
        Object[] arr1 = doctorVsPatient.get(0);
        int docId = Integer.parseInt(arr1[0].toString());
        p.setDoctor(doctorRepository.findById(docId).orElse(null));

        patientRepository.save(p);
    }

    public void provideDoseToPatient(int pId) {
        Patient obj = patientRepository.findById(pId).orElse(null);

        if(obj == null) {
            throw new PatientNotExistException("Patient with ID " + pId + " Doesn't Exist in Database");
        }

        // certificate is already generated
        if(certificateRepository.findByPatient(pId) != null) {
            throw new AlreadyGotVaccinatedException("Patient " + obj.getName() + " is already Vaccinated");
        }

        Certificates vaccineCertificate = new Certificates();
        vaccineCertificate.setPatient(obj);
        certificateRepository.save(vaccineCertificate);
        String text = "Hey " + obj.getName() + " Congratulations! You got vaccinated by Doctor " + obj.getDoctor().getName() + " And your vaccination Certificate ID is " + vaccineCertificate.getCid();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("bqkszt@gmail.com");
        simpleMailMessage.setTo(obj.getEmail());
        simpleMailMessage.setSubject("Vaccination Certificate");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);
    }

    public Patient getPatientById(int pid) {
        Patient p = patientRepository.findById(pid).orElse(null);
        if(p == null) throw new PatientNotExistException("Patient Not found with Patient ID " + pid );

        return p;
    }
}
