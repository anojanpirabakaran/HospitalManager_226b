package com.company.People;
/*==============================================================
Author: Doctor
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Department;

public class Doctor extends Worker{

    public Doctor(String firstName, String lastName, String birthDate, int id, Department department) {
        super(firstName, lastName, birthDate, id, department);
    }
}
