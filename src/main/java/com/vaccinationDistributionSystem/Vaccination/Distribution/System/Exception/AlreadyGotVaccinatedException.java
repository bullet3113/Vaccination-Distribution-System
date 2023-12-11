package com.vaccinationDistributionSystem.Vaccination.Distribution.System.Exception;

public class AlreadyGotVaccinatedException extends RuntimeException {

    public AlreadyGotVaccinatedException(String msg) {
        super(msg);
    }
}
