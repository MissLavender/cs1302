/**
 * Created by Carmen on 10/12/2016.
 */
/****************************************************************
 *                                                               *
 *                  Carmen Lavender                              *
 *                   Mini Project 1                              *
 *                  Patient  Class                               *
 ****************************************************************/

import java.io.*;

public class Patient extends Person

{
    //*************************Properties**********************/
    private String appt_idNumber;
    private String patient_idNumber;
    private String insurance;
    private Appointment appt;

    public Patient() {
        super();
        appt_idNumber = "";
        patient_idNumber = "";
        insurance = "";

    }

    public Patient(String fn, String ln, String e, String aid, String pid, String i) {
        super(fn, ln, e);
        appt_idNumber = aid;
        patient_idNumber = pid;
        insurance = i;

    }

    public void setAppt_idNumber(String aid) {
        appt_idNumber = aid;
    }

    public String getAppt_idNumber() {
        return appt_idNumber;
    }

    public void setPatient_idNumber(String pid) {
        patient_idNumber = pid;
    }

    public String getPatient_idNumber() {
        return patient_idNumber;
    }

    public void setInsurance(String i) {
        insurance = i;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setAppt(Appointment appt) {
        this.appt = appt;
    }

    public Appointment getAppt() {
        return appt;
    }


    public void display()

    {
        super.display();
        System.out.println(" Appointment Id number " + getAppt_idNumber());
        System.out.println(" Patient Id number " + getPatient_idNumber());
        System.out.println("Insurance company " + getInsurance());
        System.out.println(" Appointment ");
        getAppt().display();
    }

    public void select(String apptID) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Patients.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(apptID)) {
                    String[] fields = line.split(":");
                    super.setFirst_name(fields[2]);
                    super.setLast_name(fields[3]);
                    super.setEmail(fields[5]);
                    this.appt_idNumber = fields[0];
                    this.patient_idNumber = fields[1];
                    this.insurance = fields[6];
                    this.appt = new Appointment();
                    this.appt.select(apptID);

                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }

    public void insert(String apptID, String patientID, String fn, String ln, String em, String ins) {
        super.setFirst_name(fn);
        super.setLast_name(ln);
        super.setEmail(em);
        this.appt_idNumber = apptID;
        this.patient_idNumber = patientID;
        this.insurance = ins;

        try {
            new PrintStream(new FileOutputStream("Patients.txt", true)).println(
                    appt_idNumber + ":" +
                            patient_idNumber + ":" +
                            super.getFirst_name() + ":" +
                            super.getLast_name() + ":" +
                            super.getEmail() + ":" +
                            insurance
            );
        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }
}