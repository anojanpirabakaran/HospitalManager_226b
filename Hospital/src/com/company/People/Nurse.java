package com.company.People;
/*==============================================================
Author: Nurse
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Department;

public class Nurse extends Worker {
    public Nurse(String firstName, String lastName, String occupation, String birthDate, int id, Department department) {
        super(firstName, lastName, occupation, birthDate,id,department);
    }
}
