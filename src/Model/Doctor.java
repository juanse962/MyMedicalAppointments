package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {


    private String speciality;
    //Avalible appointment


    public Doctor(String name, String email) {
        super(name, email);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    ArrayList<AvailableAppointment> aA = new ArrayList<>();

    public void addAvailableAppointment(String date, String time) {
        aA.add(new AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointment() {
        return aA;
    }

    @Override
    public String toString() {
        return super.toString()+"\nSpeciality:" + speciality
                +"\nAvaliable: "+aA.toString();
    }

    @Override
    public void showDataUser() {

        System.out.println("Empleado del Hospital: Cruz roja");
        System.out.println("Departamento: pediatria");
    }

    public class AvailableAppointment {
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate() {
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointment \nDate: "+date
                    +"\nTime:"+time;
        }
    }
}