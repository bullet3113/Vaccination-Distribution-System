package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception;

public class PatientNotExistException extends RuntimeException {

    public PatientNotExistException(String msg) {
        super(msg);
    }
}
