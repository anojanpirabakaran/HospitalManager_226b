package com.company.Interfaces;
/*==============================================================
Author: Read
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.People.Patient;
import com.company.People.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public interface Read {
    default ArrayList<Patient> readPatients(File file) {
        ArrayList<Patient> patients = new ArrayList<>();
        String firstName;
        String lastName;
        String occupation;
        String date;
        String reasonForStay;
        Patient p;
        String id;
        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                firstName = scan.nextLine();
                lastName = scan.nextLine();
                occupation = scan.nextLine();
                date = scan.nextLine();
                reasonForStay = scan.nextLine();
                id = scan.nextLine();
                scan.next();
                p = new Patient(firstName, lastName, occupation,date , reasonForStay,Integer.parseInt(id));
                patients.add(p);
            }

        } catch (Exception e) {
        }
        return patients;
    }
    default ArrayList<Patient> readNurse(File file) {
        ArrayList<Patient> patients = new ArrayList<>();
        String firstName;
        String lastName;
        String occupation;
        String date;
        String reasonForStay;
        String id;
        Patient p;
        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                firstName = scan.nextLine();
                lastName = scan.nextLine();
                occupation = scan.nextLine();
                date = scan.nextLine();
                reasonForStay = scan.nextLine();
                id=scan.nextLine();
                scan.next();
                p = new Patient(firstName, lastName, occupation,date , reasonForStay,Integer.parseInt(id));
                patients.add(p);
            }

        } catch (Exception e) {
        }
        return patients;
    }
}
