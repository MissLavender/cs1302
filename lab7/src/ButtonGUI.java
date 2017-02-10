/*********************************************************************
 *                                                                    *
 *              Carmen Lavender                                       *
 *               Lab #7                                              *
 *              GUIs                                        *
 *********************************************************************/
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonGUI extends Application implements EventHandler<ActionEvent> {

    Button btn = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button exit = new Button();
    Button clear = new Button();
    MenuItem exitM = new MenuItem();
    MenuItem open = new MenuItem();
    MenuItem close = new MenuItem();
    MenuItem about = new MenuItem();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        btn.setText("Hello");
        btn2.setText("Good Morning");
        btn3.setText("Good day");
        exit.setText("Exit");
        clear.setText("Clear");
        exitM.setText("Exit");
        open.setText("Open");
        close.setText("Close");
        about.setText("About");

        FlowPane root = new FlowPane();
        BorderPane btnContainer = new BorderPane();
        btnContainer.setLeft(btn);
        btnContainer.setCenter(btn2);
        btnContainer.setRight(btn3);
        btnContainer.setBottom(clear);
        clear.setOnAction(this);
        exit.setOnAction(this);
        root.getChildren().add(btnContainer);
        Scene scene = new Scene(root,300,500);
        primaryStage.setTitle("Hello GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
        //Add menu bar
        MenuBar mb = new MenuBar();
        Menu file = new Menu ("File");
        Menu help = new Menu ("Help");
        exitM.setOnAction(this);
        mb.getMenus().addAll(file,help);
        file.getItems().addAll(exitM,open,close);
        help.getItems().addAll(about);
        btnContainer.setTop(mb);




    }
    @Override
    public void handle(ActionEvent event) {
        if(exitM == event.getSource()){
            System.out.println("Exit Pressed");
            System.exit(0);
        }

        if(clear == event.getSource()){
             btn.setText("   ");
            btn2.setText("   ");
            btn3.setText(" ");

        }


    }
}
