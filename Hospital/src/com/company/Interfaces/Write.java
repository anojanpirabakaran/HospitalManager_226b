package com.company.Interfaces;
/*==============================================================
Author: Write
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.Database.Report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public interface Write {
    default void printReportsInList(ArrayList<Report> reports) {
        try {
            File yourReport = new File("yourReports.txt");
            BufferedWriter write = new BufferedWriter(new FileWriter(yourReport));
            write.write("");
            for (Report r : reports) {
                write.append("-------------------------\n");
                write.append("Date: " + r.getDate()+"\n");
                write.append("Start: " + r.getStartTime()+"\n");
                write.append("End: " + r.getEndTime()+"\n");
                write.append("Doctor ID: "+r.getWorker().getId()+ "\n Doctor Name: " + r.getWorker().getFirstName() + " "+r.getWorker().getLastName()+"\n");
                write.append("Patient: "+ r.getPatient().getFirstName() + " "+r.getPatient().getLastName()+"\n");
                write.append("Reason: " + r.getReason()+"\n");
            }
            write.close();
        } catch (Exception e) {
        }
    }
}
