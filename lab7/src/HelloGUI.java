/*********************************************************************
 *                                                                    *
 *              Carmen Lavender                                       *
 *               Lab #7                                              *
 *              GUIs                                        *
 *********************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class HelloGUI extends Application {
    Button btn = new Button();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        btn.setText("Hello");
        FlowPane root = new FlowPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root,300,500);



    }
}
