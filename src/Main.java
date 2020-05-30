import Model.Doctor;
import Model.ISchedulable;
import Model.Patient;
import Model.User;
import ui.UIMenu;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        UIMenu.showMenu();
        /**
        Doctor myDoctor = new Doctor("Juan Sebastian Gomez","juan@mail.com");

        myDoctor.addAvailableAppointment(new Date(),"08:00");
        myDoctor.addAvailableAppointment(new Date(),"09:00");
        myDoctor.addAvailableAppointment(new Date(),"11:00");

        for (Doctor.AvailableAppointment aA : myDoctor.getAvailableAppointment()) {
            System.out.println(aA.getDate() + " " + aA.getTime());
        }

        User user = new Doctor("Juan","juan@mail.com");
        User userPa = new Patient("Juan","juan@mail.com");

        user.showDataUser();
        userPa .showDataUser();

        //Clase anonima
        User user1 = new User("Juan","juan@mail.com") {
            @Override
            public void showDataUser() {
                System.out.println("Doctor");
                System.out.println("Hospital: Cruz Azul");
                System.out.println("Departamento: Pediatria");
            }
        };
        user1.showDataUser();
        ISchedulable ISchedulable = new ISchedulable() {
            @Override
            public void schedule(Date date, String time) {
                System.out.println("");
            }
        };**/

        /**
        Patient patient = new Patient("Alejandra","alenjandra@mail.com");
        patient.setWeight(20.6);
        System.out.println(patient.getName());
        System.out.println(patient.getWeight());
        patient.setPhoneNumber("12345678");
        System.out.println(patient.getPhoneNumber());

        System.out.println(myDoctor);
**/
    }
}
