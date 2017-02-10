/**
 * Created by Carmen on 10/12/2016.
 */

import java.io.*;

/****************************************************************
 *                                                               *
 *                  Carmen Lavender                              *
 *                   Mini Project 1                              *
 *                  Dentist  Class                               *
 ****************************************************************/
public class Dentist extends Person {
    /********************Properties********************************/

    private String dentist_idNumber;
    private String password;
    private int payrate;
    private AppointmentList apptL;

    public Dentist() {
        super();
        dentist_idNumber = "D000";
        password = "000000";
        payrate = 000000;

    }

    public Dentist(String fn, String ln, String e, String did, String pwd, int p) {
        super(fn, ln, e);
        dentist_idNumber = did;
        password = pwd;
        payrate = p;

    }

    public void setDentist_idNumber(String did) {
        dentist_idNumber = did;
    }

    public String getDentist_idNumber() {
        return dentist_idNumber;
    }

    public void setPassword(String pwd) {
        password = pwd;
    }

    public String getPassword() {
        return password;
    }

    public void setPayrate(int p) {
        payrate = p;
    }

    public int getPayrate() {
        return payrate;
    }

    public void setApptL(AppointmentList al) {
        apptL = al;
    }

    public AppointmentList getApptL() {
        return apptL;
    }

    public void display() {
        super.display();
        System.out.println(" Dentist ID Number " + getDentist_idNumber());
        System.out.println(" Password " + getPassword());
        System.out.println("Pay rate " + getPayrate());
        System.out.println(" Appointment List : ");
        getApptL().display();

    }

    public void select(String apptID) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Dentists.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(apptID)) {
                    String[] fields = line.split(":");
                    super.setFirst_name(fields[2]);
                    super.setLast_name(fields[3]);
                    super.setEmail(fields[4]);
                    this.dentist_idNumber = fields[0];
                    this.password = fields[1];
                    this.payrate = Integer.parseInt(fields[5]);
                    this.apptL = new AppointmentList();
                    BufferedReader ApptList = new BufferedReader(new FileReader("Appointments.txt"));
                    String apptLine;
                    while ((apptLine = ApptList.readLine()) != null) {
                        if (apptLine.contains(this.dentist_idNumber)) {
                            Appointment appt = new Appointment();
                            appt.select(apptLine.split(":")[0]);
                            this.apptL.addAppointment(appt);
                        }
                    }
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public void insert(String dentist_ID, String pwd, String fn, String ln, String em, int pay) {
        this.dentist_idNumber = dentist_ID;
        this.password = pwd;
        super.setFirst_name(fn);
        super.setLast_name(ln);
        super.setEmail(em);
        this.payrate = pay;

        try {
            new PrintStream(new FileOutputStream("Dentists.txt", true)).println(dentist_idNumber + ":" + password + ":" + super.getFirst_name() + ":" + super.getLast_name() + ":" + super.getEmail() + ":" + payrate);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}