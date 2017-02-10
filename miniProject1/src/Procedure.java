/**
 * Created by Carmen on 10/12/2016.
 *//****************************************************************
 *                                                               *
 *                  Carmen Lavender                              *
 *                   Mini Project 1                              *
 *                  Procedure Class                              *
 ****************************************************************/

import java.io.*;


public class Procedure {
    /**************************Properties****************************/

    private String procedure_idNumber;
    private String title;
    private String description;
    private double price;
//**=======================Constructors==========================/

    public Procedure() {
        procedure_idNumber = "";
        title = "";
        description = "";
        price = 0.0;
    }

    public Procedure(String pid, String t, String d, double p) {
        procedure_idNumber = pid;
        title = t;
        description = d;
        price = p;
    }
    //======================Behaviors=============================/

    public void setProcedure_IdNumber(String pid) {
        procedure_idNumber = pid;
    }

    public String getProcedure_IdNumber() {
        return procedure_idNumber;
    }

    public void setTitle(String t) {
        title = t;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String d) {
        description = d;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double p) {
        price = p;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.println("Procedure ID number " + getProcedure_IdNumber());
        System.out.println("Procedure name " + getTitle());
        System.out.println("Procedure details" + getDescription());
        System.out.println("Procedure price" + getPrice());

    }

    public void select(String procedureName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Procedures.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(procedureName)) {
                    String[] fields = line.split(":");
                    this.procedure_idNumber = fields[0];
                    this.title = fields[1];
                    this.description = fields[2];
                    this.price = Double.parseDouble(fields[3]);
                    return;
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();


        }

    }
     public void insert(String procedureID, String title, String description, double price){
         this.procedure_idNumber = procedureID;
         this.title = title;
         this.description = description;
         this.price = price;
         try{
             new PrintStream( new FileOutputStream("Procedures.txt", true)).println(procedureID  +":" + title + ":" + description + ":" + price );
         }catch ( IOException ie) { ie.printStackTrace();}

     }
}



