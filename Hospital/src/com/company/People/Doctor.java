package com.company.People;
/*==============================================================
Author: Doctor
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Department;
import com.company.Interfaces.Admin;

public class Doctor extends Worker implements Admin {

    public Doctor(String firstName, String lastName, String birthDate, int id, Department department) {
        super(firstName, lastName, birthDate, id, department);
    }
    public Doctor(String firstName, String lastName, String birthDate, Department department) {
        super(firstName, lastName, birthDate, department);
    }
}
