package com.company;

import com.company.Database.Database;
import com.company.People.Doctor;
import com.company.People.Patient;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Database db = new Database();
        Patient pat = new Patient("", "", "", 900909);
        Doctor doc = new Doctor("", "", "", 9931499, Department.rehabilitation);
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to be admin or user");
        String classChoice = "";
        String input = "";
        String cont = "true";
        while (((!classChoice.equals("admin") && !classChoice.equals("user")) || (cont.equals("true")) && classChoice.equals("user")) ||(cont.equals("true")) && classChoice.equals("admin")) {
            if(classChoice.equals("")){
                classChoice = scan.nextLine();
            }
            switch (classChoice) {
                case "admin":
                    while (!input.equals("0") && !input.equals("9") && classChoice.equals("admin") && cont.equals("true")) {
                        System.out.println("1:Add Building\n" +
                                "2:Add a worker to a building\n" +
                                "3:Add a department to a building\n" +
                                "4:Add a Worker\n" +
                                "5:Print Buildings based on department\n" +
                                "6:Print all Workers\n" +
                                "7:Print all building Names\n" +
                                "8:Print all Buildings data\n" +
                                "9:Switch to user mode\n" +
                                "0:To quit");
                        input = scan.nextLine();
                        switch (input) {
                            case "1":
                                doc.addBuilding(db);
                                break;
                            case "2":
                                doc.addWorkerToBuilding(db);
                                break;
                            case "3":
                                doc.addDepartmentToBuilding(db);
                                break;
                            case "4":
                                doc.addWorker(db);
                                break;
                            case "5":
                                Department d = null;
                                System.out.println("please enter the department name:");
                                System.out.println("medical\nnursing\nphysical\nrehabilitation");
                                while (d == null) {
                                    input = scan.nextLine();
                                    switch (input) {
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
                                db.printBuildingBasedOnDepartments(d);
                                break;
                            case "6":
                                db.printAllWorkers();
                                break;
                            case "7":
                                db.printAllBuildingNames();
                                break;
                            case "8":
                                db.printAllDataBuildings();
                                break;
                            case "9":
                                classChoice="user";
                                break;
                            case "0":
                                cont="false";
                                break;
                        }
                        input="";
                    }
                    break;
                case "user":
                    System.out.println("Please enter your first Name");
                    pat.setFirstName(scan.nextLine());
                    System.out.println("Please enter your last name");
                    pat.setLastName(scan.nextLine());
                    System.out.println("Please enter your birthdate(dd,mm,yyyy)");
                    pat.setBirthDate(scan.nextLine());
                    while (!input.equals("0") && !input.equals("3") && classChoice.equals("user") && cont.equals("true")) {
                        System.out.println("1:Add appointment\n" +
                                "2: Print your reports\n" +
                                "3: Switch to admin mode\n"+
                                "0: Quit");
                        input = scan.nextLine();
                        switch (input) {
                            case "1":
                                pat.bookAppointment(db);
                                break;
                            case "2":
                                pat.printAllMyReports(db);
                                break;
                            case "3":
                                classChoice = "admin";
                                break;
                            case"0":
                                cont="false";
                                break;
                        }
                        input="";
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
