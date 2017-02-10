/*********************************************************************
 *                                                                    *
 *              Carmen Lavender                                       *
 *                                                                    *
 *              Mini Project 3                                        *
 *********************************************************************/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginGUI extends Application implements EventHandler<ActionEvent> {
    TextField loginTextField = new TextField();
    Text loginText = new Text("Login");
    TextField passwordTextField = new TextField();
    Text passwordText = new Text("Password");
    HBox hBox = new HBox();
    HBox hBox2 = new HBox();
    VBox vBox = new VBox(3);
    Button btn = new Button();
    HBox hbox3 = new HBox();
    Button aptbtn;

    Button showAppointmentButton = new Button("Show Appointment");
    Button showDentistAppointmentButton = new Button("Show Appointments");

    String appointmentID = "";
    AppointmentList appointmentList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        btn.setText("Login");

        hBox.getChildren().addAll(loginText, loginTextField);
        hBox2.getChildren().addAll(passwordText, passwordTextField);
        hbox3.getChildren().addAll(btn);
        vBox.getChildren().addAll(hBox, hBox2, hbox3);
        Scene scene = new Scene(vBox, 300, 500);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
        btn.setText("Login");
        btn.setOnAction(this);
        showAppointmentButton.setOnAction(this);
        showDentistAppointmentButton.setOnAction(this);

    }

    @Override
    public void handle(ActionEvent event) {
        if (btn == event.getSource()) {
            String username = loginTextField.getText();
            String password = passwordTextField.getText();

            if (username.toLowerCase().startsWith("a")) {
                //Create Patient instance
                Patient patient = new Patient();
                //Select Patient by input
                patient.select(username.toUpperCase());
                //Check if valid Patient
                //Check if "password" is correct
                if (patient.getAppt_idNumber().equalsIgnoreCase(username) &&
                        patient.getPatient_idNumber().equalsIgnoreCase(password)) {
                    //If "password" is valid then create & display Patient info screen
                    appointmentID = patient.getAppt_idNumber();
                    Stage patientStage = createPatientStage(patient);
                    patientStage.show();
                } else {
                    handleInvalidLogin();
                }
            } else if (username.toLowerCase().startsWith("d")) {
                //Create Dentist instance
                Dentist dentist = new Dentist();
                //Select Dentist by input
                dentist.select(username.toUpperCase());
                //Check if valid Dentist
                //Check if "password" is correct
                if (dentist.getDentist_idNumber().equalsIgnoreCase(username) &&
                        dentist.getPassword().equalsIgnoreCase(password)) {
                    //If "password" is valid then create & display Dentist info screen
                    appointmentList = dentist.getApptL();
                    Stage dentistStage = createDentistStage(dentist);
                    dentistStage.show();
                } else {
                    handleInvalidLogin();
                }
            } else {
                //Unknown login
                handleInvalidLogin();
            }
        } else if (showAppointmentButton == event.getSource()) {
            Appointment appointment = new Appointment();
            appointment.select(appointmentID);
            Stage appointmentStage = createAppointmentStage(appointment);
            appointmentStage.show();
        } else if (showDentistAppointmentButton == event.getSource()) {
            Stage appointmentListStage = createAppointmentListStage(appointmentList);
            appointmentListStage.show();
        }

    }

    private void handleInvalidLogin() {
        System.out.println("Invalid login");
    }

    private Stage createPatientStage(Patient patient) {
        Stage patientStage = new Stage();
        VBox vBox = new VBox();
        vBox.getChildren().addAll(
                createFormField("Appointment ID", patient.getAppt_idNumber()),
                createFormField("Patient ID", patient.getPatient_idNumber()),
                createFormField("First Name", patient.getFirst_name()),
                createFormField("Last Name", patient.getLast_name()),
                createFormField("Email", patient.getEmail()),
                createFormField("Insurance", patient.getInsurance()),
                showAppointmentButton
        );
        patientStage.setScene(new Scene(vBox));
        return patientStage;
    }

    private Stage createAppointmentStage(Appointment appointment) {
        Stage appointmentStage = new Stage();
        VBox vBox = createAppointmentVBox(appointment);
        appointmentStage.setScene(new Scene(vBox));
        return appointmentStage;
    }

    private Stage createAppointmentListStage(AppointmentList appointmentList) {
        Stage appointmentListStage = new Stage();
        VBox root = new VBox();
        for (Appointment appt : appointmentList.appointment_list) {
            root.getChildren().addAll(
                    new Text(appt.getAppt_IdNumber()),
                    createAppointmentVBox(appt)
            );
        }
        appointmentListStage.setScene(new Scene(root));
        return appointmentListStage;
    }

    private VBox createAppointmentVBox(Appointment appointment) {
        VBox vBox = new VBox();
        vBox.getChildren().addAll(
                createFormField("Appointment ID", appointment.getAppt_IdNumber()),
                createFormField("Date", appointment.getDate()),
                createFormField("Time", appointment.getTime()),
                createFormField("Dentist ID", appointment.getDentist_idNumber()),
                createFormField("Procedure ID", appointment.getProcedure_idNumber())
        );
        return vBox;
    }

    private Stage createDentistStage(Dentist dentist) {
        Stage dentistStage = new Stage();
        aptbtn = new Button();
        aptbtn.setText("Appointment List");
        VBox vbox = new VBox();
        vbox.getChildren().addAll(
                createFormField("Dentist ID", dentist.getDentist_idNumber()),
                createFormField("Password", dentist.getPassword()),
                createFormField("Payrate", String.valueOf(dentist.getPayrate())),
                createFormField("Appointment List", String.valueOf(dentist.getApptL())),
                aptbtn
        );
        Scene scene = new Scene(vbox, 300, 500);
        dentistStage.setScene(scene);
        aptbtn.setOnAction(e -> {
            createAppointmentListStage(dentist.getApptL()).show();
        });
        // Add all fields for dentist (look at other stages)
        // Add dentist show appointments button
        return dentistStage; //TODO actually make stage
    }



    private HBox createFormField(String label, String value) {
        HBox hBox = new HBox();
        hBox.getChildren().add(new Text(label));
        hBox.getChildren().add(new TextField(value));
        return hBox;
    }
}
