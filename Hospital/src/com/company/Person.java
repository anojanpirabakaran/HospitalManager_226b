package com.company;
/*==============================================================
Author: Person
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import java.util.Date;

public class Person {
    String firstName = "";
    String lastName = "";
    String occupation = "";
    Date birthDate = new Date();

    public Person(String firstName, String lastName, String occupation, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.birthDate = birthDate;
    }
}