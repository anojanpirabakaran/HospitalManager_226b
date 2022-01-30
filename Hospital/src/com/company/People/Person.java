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
    protected String birthDate = "";
    protected int id;
    static protected int numOfPersons = 0;

    public Person(String firstName, String lastName, String birthDate,int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.id = id;
        numOfPersons++;
    }

    public Person(String firstName, String lastName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.id = ++numOfPersons;
    }

    public void printData() {
        System.out.println("First name: " + firstName);
        System.out.println("last name:  " + lastName);
        System.out.println("birthdate:  " + birthDate);
        System.out.println("ID:         " + id);
    }


    public int getId() {
        return id;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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