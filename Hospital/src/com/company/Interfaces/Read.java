package com.company.Interfaces;
/*==============================================================
Author: Read
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Building;
import com.company.Database.Report;
import com.company.Department;
import com.company.People.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public interface Read extends DepartmentConverter {
    default ArrayList<Patient> readPatients(File file) {
        ArrayList<Patient> patients = new ArrayList<>();
        String firstName;
        String lastName;
        String date;
        Patient p;
        String id;
        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                firstName = scan.nextLine();
                lastName = scan.nextLine();
                date = scan.nextLine();
                id = scan.nextLine();
                scan.nextLine();
                patients.add(new Patient(firstName, lastName, date, Integer.parseInt(id)));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return patients;
    }

    default ArrayList<Worker> readWorkers(File file) {
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
                scan.nextLine();
                switch (job) {
                    case "doctor":
                        workers.add(new Doctor(firstName, lastName, birthDate, Integer.parseInt(id), convertStringToDepartment(department)));
                        break;
                    case "nurse":
                        workers.add(new Nurse(firstName, lastName, birthDate, Integer.parseInt(id), convertStringToDepartment(department)));
                        break;
                    default:
                        workers.add(new Worker(firstName, lastName, birthDate, Integer.parseInt(id), convertStringToDepartment(department)));

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return workers;
    }

    default ArrayList<Building> readBuildings(File file, ArrayList<Worker> workers) {
        HashMap<Integer, Worker> workerMap = new HashMap<>();
        ArrayList<Building> buildings = new ArrayList<>();

        for (Worker worker : workers) {
            workerMap.put(worker.getId(), worker);
        }
        String name="";
        String[] departmentsValues;
        String[] workerIDs = new String[0];
        ArrayList<Worker> workersForBuilding = new ArrayList<>();
        ArrayList<Department> departments = new ArrayList<>();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                name = scan.nextLine();
                departmentsValues = scan.nextLine().split(",");
                workerIDs = scan.nextLine().split(",");
                for (String s : departmentsValues) {
                    departments.add(convertStringToDepartment(s));
                }
            }
            for (String id : workerIDs) {
                if (workerMap.containsKey(Integer.parseInt(id))) {
                    workersForBuilding.add(workerMap.get(Integer.parseInt(id)));
                }
            }
            buildings.add(new Building(name, workersForBuilding, departments));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return buildings;
    }

    default ArrayList<Report> readReports(File file, ArrayList<Worker> workers, ArrayList<Patient> patients) {
        ArrayList<Report> reports = new ArrayList<>();
        HashMap<Integer, Worker> workerMap = new HashMap<Integer, Worker>();
        for (Worker worker : workers) {
            workerMap.put(worker.getId(), worker);
        }
        HashMap<Integer, Patient> patientMap = new HashMap<Integer, Patient>();
        for (Patient patient : patients) {
            patientMap.put(patient.getId(), patient);
        }

        String idPatient;
        String idWorker;
        Department d;
        String[] date;
        String[] startTime;
        String[] endTime;
        String reasonForStay;
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                idPatient = scan.nextLine();
                idWorker = scan.nextLine();
                d = convertStringToDepartment(scan.nextLine());
                date = scan.nextLine().split(",");
                startTime = scan.nextLine().split(":");
                endTime = scan.nextLine().split(":");
                reasonForStay = scan.nextLine();
                scan.nextLine();
                reports.add(new Report(patientMap.get(Integer.parseInt(idPatient)), workerMap.get(Integer.parseInt(idWorker)),d, Report.formatDate(date[0], date[1], date[2]), Report.formatTime(startTime[0], startTime[1]), Report.formatTime(endTime[0], endTime[1]), reasonForStay));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return reports;
    }
}
