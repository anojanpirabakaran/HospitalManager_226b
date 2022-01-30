package com.company.Interfaces;
/*==============================================================
Author: Admin
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Database.Database;
import com.company.Department;
import com.company.People.Doctor;
import com.company.People.Nurse;
import com.company.People.Worker;

import java.sql.SQLOutput;
import java.util.Scanner;

public interface Admin {
    /**
     * Adds a new Building to the database
     *
     * @param db
     */
    default public void addBuilding(Database db) {
        String buildingName;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name of the Building");
        buildingName = scan.nextLine();
        db.addNewBuilding(buildingName);
    }

    /**
     * Add/move a worker to a building
     *
     * @param db
     */
    default public void addWorkerToBuilding(Database db) {
        Scanner scan = new Scanner(System.in);
        String buildingName;
        int workerID;

        db.printAllBuildingNames();
        System.out.println("Enter the name of the building where you want the worker to go to");
        buildingName = scan.nextLine();
        db.printAllWorkers();
        System.out.println("Please enter the ID of the worker");
        workerID = scan.nextInt();

        db.moveWorker(buildingName, workerID);
    }

    /**
     * add a department to a building
     * @param db
     */
    default public void addDepartmentToBuilding(Database db) {
        String department;
        String buildingName;
        Department d = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Possible departments are:");
        System.out.println("medical\nnursing\nphysical\nrehabilitation");
        System.out.println("Please enter the Department that should be added");
        while (d == null) {
            department = scan.nextLine();
            switch (department) {
                case "medical":
                    d = Department.medical;
                    break;
                case "nursing":
                    d = Department.nursing;
                    break;
                case "physical":
                    d = Department.physical;
                    break;
                case "rehabilitation":
                    d = Department.rehabilitation;
                    break;
                default:
                    d = null;
            }
        }
        db.printAllBuildingNames();
        System.out.println("Please enter the name of the building that you want to have the department in");
        buildingName = scan.nextLine();
        db.addDepartmentToBuilding(buildingName, d);
    }

    /**
     * add a worker to the database
     * @param db
     */
    default public void addWorker(Database db) {
        String firstName;
        String lastName;
        String profession;
        String birthdate;
        Scanner scan = new Scanner(System.in);
        String department;
        Department d =null;

        System.out.println("Enter the workers first name");
        firstName=scan.nextLine();
        System.out.println("Enter the workers last name");
        lastName=scan.nextLine();
        System.out.println("Enter the workers birthdate(dd,mm,yyyy)");
        birthdate=scan.nextLine();
        System.out.println("Enter the workers profession(doctor,nurse,other)");
        profession=scan.nextLine();
        System.out.println("please enter the department");
        System.out.println("Possible departments are:");
        System.out.println("medical\nnursing\nphysical\nrehabilitation");
        System.out.println("Please enter the Department that should be added");
        while (d == null) {
            department = scan.nextLine();
            switch (department) {
                case "medical":
                    d = Department.medical;
                    break;
                case "nursing":
                    d = Department.nursing;
                    break;
                case "physical":
                    d = Department.physical;
                    break;
                case "rehabilitation":
                    d = Department.rehabilitation;
                    break;
                default:
                    d = null;
            }
        }
        switch (profession) {
            case "doctor":
            db.addWorker(new Doctor(firstName,lastName,birthdate,d));
                break;
            case "nurse":
                db.addWorker(new Nurse(firstName,lastName,birthdate,d));
                break;
            default:
                db.addWorker(new Worker(firstName,lastName,birthdate,d));
                break;
        }
    }
}
