package com.company;
/*==============================================================
Author: Building
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/

import com.company.People.Worker;
import java.util.ArrayList;

public class Building {
    private String name;
    private ArrayList<Worker> workers = new ArrayList<>();
    private ArrayList<Department> departments = new ArrayList<>();

    public Building(String name, ArrayList<Worker> workers, ArrayList<Department> departments) {
        this.name = name;
        this.workers = workers;
        this.departments = departments;
    }
  public ArrayList<Department> departments = new ArrayList<>();
}
