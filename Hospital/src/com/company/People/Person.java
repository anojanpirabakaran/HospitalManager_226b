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

    public Person(String firstName, String lastName, String occupation, String birthDate, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.birthDate = birthDate;
        this.id = id;
        numOfPersons++;
    }

    public Person(String firstName, String lastName, String occupation, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.birthDate = birthDate;
        this.id = ++numOfPersons;
    }

    public void printData() {
        System.out.println("First name: " + firstName);
        System.out.println("last name:  " + lastName);
        System.out.println("Occupation: " + occupation);
        System.out.println("birthdate:  " + birthDate);
        System.out.println("ID:         " + id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNumOfPersons() {
        return numOfPersons;
    }

    public static void setNumOfPersons(int numOfPersons) {
        Person.numOfPersons = numOfPersons;
    }
}