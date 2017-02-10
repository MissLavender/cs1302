/**
 * Created by Carmen on 10/12/2016.
 *//****************************************************************
 *                                                               *
 *                  Carmen Lavender                              *
 *                   Mini Project 1                              *
 *                  Test Appointment list                        *
 ****************************************************************/
public class TestAppointmentList {
    public static void main(String[] args) {
        AppointmentList apptList = new AppointmentList();
        apptList.addAppointment(new Appointment());
        apptList.addAppointment(new Appointment("Test", "Test", "Test", "Test", "Test"));
        Dentist d = new Dentist();
        d.setApptL(apptList);
        d.display();
    }
}
