package ui;

import Model.Doctor;
import Model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
            "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public static Doctor doctorLogger;
    public static Patient paitientLogger;

    public static void showMenu() {
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Model.Doctor");
            System.out.println("2. Model.Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }


    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    showMenu();
                    break;
            }
        } while (response != 0);
    }

    private static void authUser(int usertype) {

        ArrayList<Doctor> doctores = new ArrayList<>();
        doctores.add(new Doctor("Alejandro", "alejandro@mail.com"));
        doctores.add(new Doctor("Camila", "camila@mail.com"));
        doctores.add(new Doctor("Valentina", "valentina@mail.com"));


        ArrayList<Patient> pacientes = new ArrayList<>();
        pacientes.add(new Patient("Pedro", "pedro@mail.com"));
        pacientes.add(new Patient("Cristian", "cristian@mail.com"));
        pacientes.add(new Patient("Andres", "andres@mail.com"));


        boolean emailCorrect = false;
        do {

            System.out.println("Insert your email: [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (usertype == 1) {
                for (Doctor doc : doctores) {
                    if (doc.getEmail().equals(email)) {
                        emailCorrect = true;
                        doctorLogger = doc;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }

            }
            if (usertype == 2) {
                for (Patient pat : pacientes) {
                    if (pat.getEmail().equals(email)) {
                        emailCorrect = true;
                        paitientLogger = pat;
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }

        } while (!emailCorrect);
    }
}
