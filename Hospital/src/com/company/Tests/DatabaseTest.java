package com.company.Tests;

import com.company.Database.Database;
import com.company.Department;
import com.company.People.Worker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*==============================================================
Author: DatabaseTest
Datum:  
ProjektName:    Hospital
Beschreibung: 
==============================================================*/
class DatabaseTest {

    @org.junit.jupiter.api.Test
    void workerWithIDExists() {
        int id = 24;
        Database db = new Database();
        assertFalse(db.workerWithIDExists(id));
    }

    @org.junit.jupiter.api.Test
    void getWorkerByID() {
        Database db = new Database();
        int id = 2;
        assertTrue(db.getWorkerByID(id) instanceof com.company.People.Doctor);

    }

    @Test
    void addWorker() {

        Database db = new Database();
        db.clearWorkerList();
        Worker worker = new Worker("Anojan", "Pirabakaran", "07.02.2005", Department.rehabilitation);
        db.addWorker(worker);

        Worker worker1 = new Worker("Keisha", "Adelberger", "14.02.2004", Department.medical);
        db.addWorker(worker1);

        Worker worker2 = new Worker("Becky", "Qupevaj", "25.08.2006", Department.rehabilitation);
        db.addWorker(worker2);

        assertFalse(db.getWorkers().isEmpty());
        assertEquals(3, db.getWorkers().size());

    }

}