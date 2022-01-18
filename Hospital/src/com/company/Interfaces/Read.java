package com.company.Interfaces;
/*==============================================================
Author: Read
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Building;
import com.company.Department;
import com.company.People.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public interface Read {
    default ArrayList<Patient> readPatients(File file) {
        ArrayList<Patient> patients = new ArrayList<>();
        String firstName;
        String lastName;
        String occupation;
        String date;
        String reasonForStay;
        Patient p;
        String id;
        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                firstName = scan.nextLine();
                lastName = scan.nextLine();
                date = scan.nextLine();
                reasonForStay = scan.nextLine();
                id = scan.nextLine();
                scan.next();
                p = new Patient(firstName, lastName, date, reasonForStay, Integer.parseInt(id));
                patients.add(p);
            }

        } catch (Exception e) {
        }
        return patients;
    }

    default ArrayList<Worker> readWorker(File file) {
        ArrayList<Worker> workers = new ArrayList<>();
        String job;
        String firstName;
        String lastName;
        String birthDate;
        String id;
        String department;
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                job = scan.nextLine();
                firstName = scan.nextLine();
                lastName = scan.nextLine();
                birthDate = scan.nextLine();
                id = scan.nextLine();
                department = scan.nextLine();
                scan.next();
                switch (job) {
                    case "doctor":
                        workers.add(new Doctor(firstName, lastName, birthDate, Integer.parseInt(id), Department.valueOf(department)));
                        break;
                    case "nurse":
                        workers.add(new Nurse(firstName, lastName, birthDate, Integer.parseInt(id), Department.valueOf(department)));
                        break;
                    default:
                        workers.add(new Worker(firstName, lastName, birthDate, Integer.parseInt(id), Department.valueOf(department)));

                }
            }

        } catch (Exception e) {
        }
        return workers;
    }

    default ArrayList<Building> readBuildings(File file, ArrayList<Worker> workers) {
        HashMap<int, Worker> workerMap = new HashMap<int, Worker>();
        ArrayList<Building> buildings = new ArrayList<>();

        for (Worker worker : workers) {
            workerMap.put(worker.getId(), worker);
        }
        String name;
        String[] departmentsValues;
        String[] workerIDs;
        ArrayList<Worker> workersForBuilding = new ArrayList<>();
        ArrayList<Department> departments=new ArrayList<>();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                name = scan.nextLine();
                departmentsValues=scan.nextLine().split(",");
                workerIDs=scan.nextLine().split(",");
                for (String s:departmentsValues) {
                    departments.add(Department.valueOf(s));
                }
                for (String id:workerIDs){
                    if(workerMap.containsKey(id)){
                        workersForBuilding.add(workerMap.get(id));
                    }
                }
                buildings.add(new Building(name,workersForBuilding,departments));
            }
        } catch (Exception e) {

        }
        return buildings;
    }
}
