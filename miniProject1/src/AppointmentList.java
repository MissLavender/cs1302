/**
 * Created by Carmen on 10/12/2016.
 */

import java.util.Arrays;

/****************************************************************
 *                                                               *
 *                  Carmen Lavender                              *
 *                   Mini Project 1                              *
 *                  TAppointment list Class                      *
 ****************************************************************/
public class AppointmentList {
/*****************Properties************************************/
    Appointment[]  appointment_list={};
    int count=0;
/*******************Behaviors***********************************/
    public void addAppointment(Appointment a){
        appointment_list = Arrays.copyOf(appointment_list, appointment_list.length + 1);
        appointment_list[appointment_list.length - 1] = a;
        count++;
    }

    public void display(){
        for(Appointment a : appointment_list)
            a.display();
    }

}
