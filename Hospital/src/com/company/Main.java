package com.company;

import com.company.Database.Database;
import com.company.People.Patient;

public class Main {

    public static void main(String[] args) {
        Database db = new Database();
        Patient main = new Patient("Pirabakaran", "Anojan", "Informatiker", "07.02.2005", "Broken Leg", 1);
        main.bookAppointment(db);
    }
}
