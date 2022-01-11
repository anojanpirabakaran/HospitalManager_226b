package com.company.People;
/*==============================================================
Author: Patient
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import java.util.Date;

public class Patient extends Person {
    private String reasonForStay;

    public Patient(String firstName, String lastName, String occupation, String birthDate, String reasonForStay) {
        super(firstName, lastName, occupation, birthDate);
        this.reasonForStay = reasonForStay;
    }


}
