package ui;

import Model.Doctor;
import Model.Patient;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu() {
    int response = 0;
    do {
        System.out.println("\n\n");
        System.out.println("Patient");
        System.out.println("Welcome: "+ UIMenu.paitientLogger.getName());
        System.out.println("1. Book an Appointment");
        System.out.println("2. My Appointment");
        System.out.println("0. Logout");

        Scanner sc = new Scanner(System.in);
        response = Integer.valueOf(sc.nextLine());

        switch (response){
            case 1:
                showBookAppointmentMenu();
                break;
            case 2:
                ShowPaintientMyAppointment();
                break;
            case 0:
                UIMenu.showMenu();
                break;
        }

    }while (response != 0);
    }
    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            System.out.println(":. Book an appointment");
            System.out.println("Select date: ");
            //Numeración de la lista de fechas
            //Indice de la fecha seleccionada
            //[doctor]
            //1. - doctor1
            //      - 1 fecha1
            //2. - doctor2

            Map<Integer,Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorAvailableAppointment.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorAvailableAppointment.get(i).getAvailableAppointment();
                Map<Integer, Doctor> doctorAppointment = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size()  ; j++) {
                    k++;
                    System.out.println(k + ". "+ availableAppointments.get(j).getDate());
                    doctorAppointment.put(Integer.valueOf(j),UIDoctorMenu.doctorAvailableAppointment.get(i));
                    doctors.put(Integer.valueOf(k),doctorAppointment);
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelecter = Integer.valueOf(sc.nextLine());
            Map<Integer,Doctor> doctorAvailableSelected = doctors.get(responseDateSelecter);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");
            for (Map.Entry<Integer,Doctor> doc :doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    "Date: "+ doctorSelected.getAvailableAppointment().get(indexDate).getDate()+
                    " Time: " + doctorSelected.getAvailableAppointment().get(indexDate).getTime());
            System.out.println("Confirm your appointment: \n" +
                    "1. Yes \n" +
                    "2. Change Date");
            response = Integer.valueOf(sc.nextLine());
            if (response == 1) {
                UIMenu.paitientLogger.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointment().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointment().get(indexDate).getTime()
                );
                showPatientMenu();
            }
        }while (response != 0);
    }
    private static void ShowPaintientMyAppointment(){
        int response = 0;
        do {
            System.out.println(":: My appointments");
            if (UIMenu.paitientLogger.getAppointmentDoctors().size() == 0) {
                System.out.println("Don't have appointment");
            }
            for (int i = 0; i < UIMenu.paitientLogger.getAppointmentDoctors().size() ; i++) {
                int j = i +1;
                System.out.println(j + ". "
                        +"Date: " + UIMenu.paitientLogger.getAppointmentDoctors().get(i).getDate()
                        +" Time: " + UIMenu.paitientLogger.getAppointmentDoctors().get(i).getTime()
                        + "\nDoctor: " + UIMenu.paitientLogger.getAppointmentDoctors().get(i).getDoctor().getName()
                );
            }
            System.out.println("0. Return");
        }while (response != 0);
    }
}
