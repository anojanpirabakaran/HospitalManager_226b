package com.company.Database;
/*==============================================================
Author: Report
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.People.Patient;
import com.company.People.Worker;

public class Report {
    private Patient patient;
    private Worker worker;
    private String date;
    private String startTime;
    private String endTime;
    private String reason;

    public Report(Patient patient, Worker worker, String date, String startTime, String endTime, String reason) {
        this.patient = patient;
        this.worker = worker;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
    }

    public static String formatDate(int year, int month, int day) {
        return year + ":" + month + ":" + day;
    }

    public static String formatDate(String year, String month, String day) {
        return year + ":" + month + ":" + day;
    }

    public static String formatTime(int hour, int minute) {
        return hour + ":" + minute;
    }

    public static String formatTime(String hour, String minute) {
        return hour + ":" + minute;
    }

    public Patient getPatient() {
        return patient;
    }
}
