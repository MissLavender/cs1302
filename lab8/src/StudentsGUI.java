/*********************************************************************
 *                                                                    *
 *              Carmen Lavender                                       *
 *               Lab #8                                               *
 *              Student GUIs                                          *
 *********************************************************************/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StudentsGUI extends Application implements EventHandler<ActionEvent> {
    Button btn1 = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();
    VBox vBox = new VBox(3);
    HBox hBox = new HBox();
    HBox hBox2 = new HBox();
    HBox hBox3 = new HBox();
    HBox hBox4 = new HBox();
    HBox hBox5 = new HBox();
    Text studentInfoText = new Text("Student Info");
    Text labelTextField1 = new Text(" Student ID");
    Text labelTextField2 = new Text("First Name");
    Text labelTextField3 = new Text(" Last Name");
    Text labelTextField4 = new Text("GPA");
    TextField textField1 = new TextField();
    TextField textField2 = new TextField();
    TextField textField3 = new TextField();
    TextField textField4 = new TextField();


    Stage secondStage = new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        btn1.setText("Find");
        btn2.setText("Update");
        btn2.setOnAction(this);
        btn3.setText("Exit");
        btn4.setText("One Button");
        hBox.getChildren().addAll(labelTextField1, textField1);
        hBox3.getChildren().addAll(labelTextField2, textField2);
        hBox4.getChildren().addAll(labelTextField3, textField3);
        hBox5.getChildren().addAll(labelTextField4, textField4);
        hBox2.getChildren().addAll(btn1, btn2, btn3);
        hBox2.setAlignment(Pos.BASELINE_CENTER);
        vBox.getChildren().addAll(studentInfoText, hBox, hBox3, hBox4, hBox5);

        BorderPane root = new BorderPane();
        root.setCenter(vBox);
        root.setBottom(hBox2);

        Scene scene = new Scene(root, 300, 500);
        primaryStage.setTitle("Student GUI");
        primaryStage.setScene(scene);
        primaryStage.show();


        secondStage.setTitle("My new window");
        BorderPane root2 = new BorderPane();
        root2.setCenter(btn4);
        secondStage.setScene(new Scene(root2, 450, 450));
//        secondStage.show();

    }

    @Override
    public void handle(ActionEvent event) {
        if (btn2 == event.getSource())
            secondStage.show();
    }
}
