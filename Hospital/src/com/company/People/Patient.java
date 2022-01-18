package com.company.People;
/*==============================================================
Author: Patient
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Building;
import com.company.Database.Database;
import com.company.Department;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Scanner;

public class Patient extends Person {
    Scanner scan = new Scanner(System.in);
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
    public void bookAppointment(Database database){
        System.out.println("Here you see all the departments: ");
        for (Department department : Department.values()) {
            System.out.println(department);
        }
        System.out.println("Choose a department: ");
        String choosenDepartment = scan.nextLine();
        System.out.println(choosenDepartment);
        database.printBuildingBasedOnDepartments(Department.valueOf(choosenDepartment));


    }

}
