package com.company.People;
/*==============================================================
Author: Person
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import java.util.Date;

public class Person {
    protected String firstName = "";
    protected String lastName = "";
    protected String occupation = "";
    protected String birthDate = "";
    protected int id;
    static protected int numOfPersons = 0;

    public Person(String firstName, String lastName, String occupation, String birthDate,int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.birthDate = birthDate;
        this.id=id;
        numOfPersons++;
    }
    public Person(String firstName, String lastName, String occupation, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.birthDate = birthDate;
        this.id=++numOfPersons;
    }

    public void printData() {
        System.out.println("First name: " + firstName);
        System.out.println("last name:  " + lastName);
        System.out.println("Occupation: " + occupation);
        System.out.println("birthdate:  " + birthDate);
        System.out.println("ID:         " + id);
    }
}