package com.company.People;
/*==============================================================
Author: Worker
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Department;

public class Worker extends Person{
   private Department department;
    public Worker(String firstName, String lastName, String birthDate,int id,Department department) {
        super(firstName, lastName, birthDate, id);
        this.department = department;
    }
}
