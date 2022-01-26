package com.company.Database;
/*==============================================================
Author: Database
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Building;
import com.company.Interfaces.Read;
import com.company.People.Worker;
import com.company.Interfaces.Write;
import com.company.People.Patient;
import com.company.People.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Database implements Read, Write {
    private ArrayList<Worker> workers;
    private ArrayList<Patient> patients;
    private ArrayList<Building> buildings;
    private HashMap<Integer, ArrayList<Report>> reports = new HashMap<>();

    //Integer is the ID of the patient followed by the reports

    public Database() {
        workers = readWorkers(new File("src/com/company/Database/Data/Worker"));
        patients = readPatients(new File("src/com/company/Database/Data/Patient"));
        buildings = readBuildings(new File("src/com/company/Database/Data/Building"),workers);
        for (Report r:readReports(new File("src/com/company/Database/Data/Report"),workers,patients)) {
            addReport(r);
        }
    }

    private void addReport(Report r) {
        if(!reports.containsKey(r.getPatient().getId())){
            reports.put(r.getPatient().getId(),new ArrayList<Report>());
        }
        reports.get(r.getPatient().getId()).add(r);

    }


    /**
     * Safes the workers data into a database for storing data that contains the workers name,ID, and check in time
     *
     * @param w
     */
    public void checkIn(Worker w) {

    }
}
