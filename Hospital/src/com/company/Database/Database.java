package com.company.Database;
/*==============================================================
Author: Database
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Building;
import com.company.Department;
import com.company.Interfaces.Read;
import com.company.People.*;
import com.company.Interfaces.Write;

import javax.print.Doc;
import java.io.File;
import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database implements Read, Write {

    private ArrayList<Worker> workers;
    private ArrayList<Patient> patients;
    private ArrayList<Building> buildings;
    private HashMap<Integer, ArrayList<Report>> reports = new HashMap<>();
    private HashMap<String, ArrayList<String[]>> appointments = new HashMap<>();

    //Integer is the ID of the patient followed by the reports

    public Database() {
        workers = readWorkers(new File("src/com/company/Database/Data/Worker"));
        patients = readPatients(new File("src/com/company/Database/Data/Patient"));
        buildings = readBuildings(new File("src/com/company/Database/Data/Building"), workers);
        for (Report r : readReports(new File("src/com/company/Database/Data/Report"), workers, patients)) {
            addReport(r);
        }
    }

    /**
     * Prints all the data in all buildings
     */
    public void printAllDataBuildings() {
        for (Building b : buildings) {
            System.out.println("----------------------");
            System.out.println(b.getName());
            System.out.println("Departments:");
            for (Department d : b.getDepartments()) {
                System.out.println("    " + d);
            }
            System.out.println("Workers:");
            for (Worker w : b.getWorkers()) {
                System.out.println("    ID: " + w.getId() + " " + w.getFirstName() + " " + w.getLastName());
            }
        }
    }


    /**
     * Adds a report to the report list
     *
     * @param r the report to add
     */
    private void addReport(Report r) {
        if (!reports.containsKey(r.getPatient().getId())) {
            reports.put(r.getPatient().getId(), new ArrayList<Report>());
        }
        reports.get(r.getPatient().getId()).add(r);
    }

    /**
     * Prints all Buildings that have a certain department in them
     *
     * @param department the department that will be looked for
     */
    public void printBuildingBasedOnDepartments(Department department) {
        for (Building b : buildings) {
            if (b.getDepartments().contains(department)) {
                System.out.println(department);
            }
        }
    }

    /**
     * Prints all Doctors that are in a certain department
     *
     * @param department the department that decides what will be printed
     */
    public void printDoctorBasedOnDepartments(Department department) {
        for (Worker d : workers) {
            if (d.getClass() == Doctor.class) {
                if (d.getDepartment().equals(department)) {
                    System.out.println("id: " + d.getId() + " " + d.getFirstName() + " " + d.getLastName());
                }
            }
        }
    }

    /**
     * Prints all doctors and nurses that are working in a given department
     *
     * @param department the department that decides what will be printed
     */
    public void printNursesAndDoctorsBasedOnDepartments(Department department) {
        for (Worker n : workers) {
            if (n.getClass() == Nurse.class || n.getClass() == Doctor.class) {
                if (n.getDepartment().equals(department)) {
                    System.out.println("id: " + n.getId() + " " + n.getFirstName() + " " + n.getLastName());
                }
            }
        }
    }

    /**
     * Returns true if a timeSlot for an appointment is free
     *
     * @param date
     * @param start
     * @param end
     * @return true if the slot is free
     */
    public boolean timeSlotIsFree(String date, String start, String end) {
        if (!appointments.containsKey(date)) {
            return true;
        } else {
            int[] inFormattedStart = new int[2];
            inFormattedStart[0] = Integer.parseInt(start.split(":")[0]);
            inFormattedStart[1] = Integer.parseInt(start.split(":")[1]);

            int[] inFormattedEnd = new int[2];
            inFormattedEnd[0] = Integer.parseInt(end.split(":")[0]);
            inFormattedEnd[1] = Integer.parseInt(end.split(":")[1]);


            LocalTime inputStart = LocalTime.of(Integer.parseInt(start.split(":")[0]), Integer.parseInt(start.split(":")[1]));
            LocalTime inputEnd = LocalTime.of(Integer.parseInt(end.split(":")[0]), Integer.parseInt(end.split(":")[1]));

            for (String[] times : appointments.get(date)) {
                LocalTime fixedAppointmentStart = LocalTime.of(Integer.parseInt(times[0].split(":")[0]), Integer.parseInt(times[0].split(":")[1]));
                LocalTime fixedAppointmentEnd = LocalTime.of(Integer.parseInt(times[1].split(":")[0]), Integer.parseInt(times[1].split(":")[1]));

                if ((inputStart.isBefore(fixedAppointmentStart) && inputEnd.isBefore(fixedAppointmentStart)) || inputStart.isAfter(fixedAppointmentStart) && inputEnd.isAfter(fixedAppointmentEnd)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Returns if a worker with a given id is found
     *
     * @param id the ID of the worker to search for
     * @return if the worker exists
     */
    public boolean workerWithIDExists(int id) {
        for (Worker w : workers) {
            if (w.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds an appointment/report
     *
     * @param date
     * @param startTime
     * @param endTime
     * @param p         patient object
     * @param w         worker object
     * @param reason
     * @param d         department
     */
    public void addAppointment(String date, String startTime, String endTime, Patient p, Worker w, String reason, Department d) {
        if (!reports.containsKey(p.getId())) {
            reports.put(p.getId(), new ArrayList<>());
        }
        reports.get(p.getId()).add(new Report(p, w, d, date, startTime, endTime, reason));
        addAppointmentTime(date,startTime,endTime);
    }

    /**
     * Adds an appointment time and duration to the appointment list
     *
     * @param date
     * @param startTime
     * @param endTime
     */
    public void addAppointmentTime(String date, String startTime, String endTime) {
        if (!appointments.containsKey(date)) {
            appointments.put(date, new ArrayList<>());
        }
        String[] val = {startTime, endTime};
        appointments.get(date).add(val);
    }

    public void moveWorker(String newBuildingName, int idOfWorkerToMove) {
        Worker worker = null;
        for (Worker w : workers) {
            if (w.getId() == idOfWorkerToMove) {
                worker = w;
            }
        }
        removeWorkerFromBuilding(worker);
        addWorkerToBuilding(worker,newBuildingName);
    }

    private void addWorkerToBuilding(Worker w,String newBuildingName) {
        for (Building b:buildings) {
            if(b.getName().equals(newBuildingName)){
                b.getWorkers().add(w);
            }
        }
    }

    private void removeWorkerFromBuilding(Worker worker) {
        for (Building b : buildings) {
            if (b.getWorkers().contains(worker)) {
                b.getWorkers().remove(worker);
            }
        }
    }

    public Worker getWorkerByID(int id) {
        for (Worker w : workers) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    public void printAllReports() {
        for (Map.Entry<Integer, ArrayList<Report>> r : reports.entrySet()) {
            System.out.println("---------------------");
            System.out.println("Patient ID: " + r.getKey());
            for (Report rep : r.getValue()) {
                System.out.println("------------------");
                System.out.println("   Date      : " + rep.getDate());
                System.out.println("   Start Time: " + rep.getStartTime());
                System.out.println("   End Time  : " + rep.getEndTime());
                System.out.println("   Reason    : " + rep.getReason());
                System.out.println("   Worker    : " + rep.getWorker().getFirstName() + " " + rep.getWorker().getLastName());
            }

        }
    }

    public void printAllBuildingNames(){
        for (Building b:buildings) {
            System.out.println(b.getName());
        }
    }

    public void printAllWorkers(){
        for (Worker w:workers) {
            System.out.println("---------------------");
            System.out.println("ID: "+w.getId());
            System.out.println("Name:"  +w.getFirstName() +" "+w.getLastName());
        }
    }

    public void addDepartmentToBuilding(String buildingName, Department d) {
        for (Building b:buildings) {
            if(b.getName().equals(buildingName)){
                if(!b.getDepartments().contains(d)){
                    b.getDepartments().add(d);
                }
            }
        }
    }
    public void addWorker(Worker w){
        workers.add(w);
    }
    public void addNewBuilding(String name) {
        buildings.add(new Building(name));
    }
    public void printAllReportsOfUserIntoFile(int id){
        printReportsInList(reports.get(id));
    }
}
