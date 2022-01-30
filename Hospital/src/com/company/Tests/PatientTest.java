package com.company.Tests;

import com.company.Database.Database;
import com.company.Department;
import com.company.People.Patient;
import com.company.People.Worker;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void addAppointment() {
        Database db = new Database();
        Patient p = new Patient("", "", "", 725);
        Worker w = new Worker("","","",Department.medical);

        p.addAppointment(db,"","","",p, w, "", Department.medical);

        assertEquals(1, db.getAppointments().get(1).size());
    }
}