import java.io.*;

/****************************************************************
 *                                                               *
 *                  Carmen Lavender                              *
 *                   Mini Project 1                              *
 *                  Appointment Class                            *
 ****************************************************************/

public class Appointment {
    /*********************Properites********************************/
    private String appt_idNumber;
    private String appt_date;
    private String time;
    private String dentist_idNumber;
    private String procedure_idNumber;

    /*******************Constructors*****************************/

    public Appointment() {
        appt_idNumber = "A000";
        appt_date= "00/00/0000";
        time = "0AM";
        dentist_idNumber = "D000";
        procedure_idNumber = "P000";

    }

    public Appointment(String aid, String d, String t, String did, String pid) {
        appt_idNumber = aid;
        appt_date = d;
        time = t;
        dentist_idNumber = did;
        procedure_idNumber = pid;
    }

    //======================Behaviors========================================//

    public void setAppt_IdNumber(String aid) {
        appt_idNumber = aid;
    }

    public String getAppt_IdNumber() {
        return appt_idNumber;
    }

    public void setDate(String d) {
        appt_date = d;
    }

    public String getDate() {
        return appt_date;
    }

    public void setTime(String t) {
        time = t;
    }

    public String getTime() {
        return time;
    }

    public void setDentist_IdNumber(String did) {
        dentist_idNumber = did;
    }

    public String getDentist_idNumber() {
        return dentist_idNumber;
    }

    public void setProcedure_idNumber(String pid) {
        procedure_idNumber = pid;}
    public String getProcedure_idNumber(){return procedure_idNumber;}
    public void display()
    {
        System.out.println(" Appointment Id number " + getAppt_IdNumber());
        System.out.println(" Date " + getDate());
        System.out.println(" Time "+ getTime());
        System.out.println(" Dentist Id Number"+ getDentist_idNumber());
        System.out.print(" Procedure Id " + getProcedure_idNumber());
    }
    public void select(String apptID)
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader("Appointments.txt"));
            String line;
            while ((line = br.readLine()) !=null){
                if ( line.startsWith(apptID)) {
                    String[] fields = line.split(":");
                    String[] dateTime = fields[1].split("-");
                    this.appt_idNumber = fields [0];
                    this.appt_date = dateTime[0];
                    this.time = dateTime[1];
                    this.dentist_idNumber = fields[2];
                    this.procedure_idNumber = fields[3];
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }public void insert(String apptID, String date, String tm, String dent_ID,String proc){
        this.appt_idNumber = apptID;
        this.appt_date= date;
        this.time = tm;
        this.dentist_idNumber= dent_ID;
        this.procedure_idNumber= proc;
        try{
            new PrintStream( new FileOutputStream("Appointments.txt", true)).println(appt_idNumber  +":" + appt_date + "-" + time + ":" + dentist_idNumber + ":" + procedure_idNumber);
        }catch ( IOException ie) { ie.printStackTrace();}
    }

}//end of class


