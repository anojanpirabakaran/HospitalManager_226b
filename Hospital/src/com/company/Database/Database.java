package com.company.Database;
/*==============================================================
Author: Database
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Interfaces.Read;
import com.company.People.Worker;
import com.company.Interfaces.Write;
import com.company.People.Patient;
import com.company.People.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Database implements Read, Write {
    private ArrayList<Worker> workers = new ArrayList<>();
    private ArrayList<Patient> patients  = new ArrayList<>();
    //Integer is the ID of the patient followed by the reports
    private HashMap<Integer,ArrayList<Report>> reports = new HashMap<>();

    public void read(){
        for (Person p:readPatients(new File("src/com/company/Database/Data/Patient"))) {
            if(p instanceof Patient){
                p.printData();
            }
        }
    }

    /**
     * Safes the workers data into a database for storing data that contains the workers name,ID, and check in time
     * @param w
     */
    public void checkIn(Worker w){

    }
}
