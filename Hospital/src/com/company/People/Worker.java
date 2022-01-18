package com.company.People;
/*==============================================================
Author: Worker
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Department;

public class Worker extends Person{
    Department department;
    public Worker(String firstName, String lastName, String occupation, String birthDate,int id,Department department) {
        super(firstName, lastName, occupation, birthDate, id);
        this.department = department;
    }
}
