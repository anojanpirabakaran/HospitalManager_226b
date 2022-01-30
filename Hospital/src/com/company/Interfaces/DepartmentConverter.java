package com.company.Interfaces;
/*==============================================================
Author: DepartmentConverter
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Department;

public interface DepartmentConverter {
    default Department convertStringToDepartment(String s) {
        switch (s) {
            case "1":
            case "medical":
                return Department.medical;
            case "2":
            case "nursing":
                return Department.nursing;
            case "3":
            case "physical":
                return Department.physical;
            case "rehabilitation":
            case "4":
                return Department.rehabilitation;
            default:
                return null;
        }
    }
}
