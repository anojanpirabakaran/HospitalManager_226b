package com.company.People;
/*==============================================================
Author: Patient
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Building;
import com.company.Database.Database;
import com.company.Department;
import com.company.Interfaces.DepartmentConverter;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Scanner;

public class Patient extends Person implements DepartmentConverter {
    public Patient(String firstName, String lastName, String birthDate, int id) {
        super(firstName, lastName, birthDate, id);
    }


    /**
     * Makes an appointment in a database
     * Contains
     * The user
     */
    public void bookAppointment(Database database) {
        Scanner scan = new Scanner(System.in);
        int chosenDoctor = 0;
        String date;
        String startTime;
        String endTime;
        String reason;
        String chosenDepartment;
        System.out.println("Here you see all the departments: \n");
        for (Department department : Department.values()) {
            System.out.println(department);
        }
        System.out.println("Choose a department: ");
        chosenDepartment = scan.nextLine();
        database.printBuildingBasedOnDepartments(Department.valueOf(chosenDepartment));
        System.out.println("You picked " + chosenDepartment);
        System.out.println("Now you have to choose a doctor(please enter the ID)");
        System.out.println("Possible Workers in your selected department");
        database.printNursesAndDoctorsBasedOnDepartments(Department.valueOf(chosenDepartment));
        System.out.println("Please enter the ID fo the worker");
        while (chosenDoctor == 0 || !database.workerWithIDExists(chosenDoctor)) {
            chosenDoctor = scan.nextInt();
        }
        scan.nextLine();
        System.out.println("Please enter the reason for your appointment");
        reason=scan.nextLine();

        do {
            System.out.println("Please enter the date of the appointment(DD,MM,YYYY)");
            date = scan.nextLine();
            System.out.println("Please enter the start time(24:60)");
            startTime = scan.nextLine();
            System.out.println("Please enter the end time(24:60)");
            endTime = scan.nextLine();
            if(!database.timeSlotIsFree(date, startTime, endTime)){
                System.out.println("There is another appointment at that time already");
            }else{
                System.out.println("Perfect, your appointment has been booked");
                addAppointment(database,date,startTime,endTime,this,database.getWorkerByID(chosenDoctor),reason,convertStringToDepartment(chosenDepartment));
                return;
            }
        } while (database.timeSlotIsFree(date, startTime, endTime));
    }

    private void addAppointment(Database database,String date,String startTime,String endTime,Patient p,Worker w,String reason,Department d) {
        database.addAppointment(date,startTime,endTime,p,w,reason,d);
    }

    public void printAllMyReports(Database database){
        database.printAllReportsOfUserIntoFile(this.id);
    }

}
