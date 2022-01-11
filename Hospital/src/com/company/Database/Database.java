package com.company.Database;
/*==============================================================
Author: Database
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Interfaces.Read;
import com.company.Interfaces.Write;
import com.company.People.Patient;
import com.company.People.Person;

import java.io.File;

public class Database implements Read, Write {
    public void read(){
        for (Person p:readPatients(new File("src/com/company/Database/Data/Patient"))) {
            if(p instanceof Patient){
                p.printData();
            }
        }
    }
}
