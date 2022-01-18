package com.company;
/*==============================================================
Author: Department
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

public enum Department {
    medical("1"),
    nursing("2"),
    physical("3"),
    rehabilitation("4");


    public String value;

    private Department(String label) {
        this.value = label;
    }
}
