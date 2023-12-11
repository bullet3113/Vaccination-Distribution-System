package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception;

public class DoctorNotExistException extends RuntimeException {

    public DoctorNotExistException(String msg) {
        super(msg);
    }
}
