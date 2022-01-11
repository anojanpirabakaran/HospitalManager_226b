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
    public Patient(String firstName, String lastName, String occupation, String birthDate, String reasonForStay,int id) {
        super(firstName, lastName, occupation, birthDate,id);
        this.reasonForStay = reasonForStay;
    }

    /**
     * Makes an appointment in a database
     * Contains
     * The user
     */
    public void bookAppointment(){

    }

}
