import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javafx.stage.Screen;

public class UiController implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;

    private Boolean isMaximize = false;

    //These magic number will be fixed soon - XT
    private Double minimize_X = 40.0;
    private Double minimize_Y = 40.0;
    private Double minimize_width = 1366.0;
    private Double minimize_height = 768.0;

    @FXML
    private AnchorPane parent;

    @FXML
    private AnchorPane contentArea;

    @FXML
    private JFXButton exit_buttom;

    @FXML
    private JFXButton maximize_btn;

    @FXML
    private JFXButton minimal_buton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDrageable();
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void makeStageDrageable() {
        parent.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!isMaximize) {
                    Launch.stage.setX(event.getScreenX() - xOffset);
                    Launch.stage.setY(event.getScreenY() - yOffset);
                    Launch.stage.setOpacity(0.7f);
                }
            }
        });

//        // Work?
//        parent.setOnDragDone((e) -> {
////            System.out.println("Mouse drag done");
//            Launch.stage.setOpacity(1.0f);
//        });


        parent.setOnMouseReleased((e) -> {
//            System.out.println("Mouse release");
//            System.out.println("Y = " + e.getY());
            Launch.stage.setOpacity(1.0f);
            //Unexpected work.. will fix later =))
            if (Launch.stage.getY() < 10 && isMaximize==false){
                maximize_btn.fire();
            }
        });

    }


    @FXML
    void open_drink(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Drinks.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }


    @FXML
    void open_cake(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Cake.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    void open_customer(MouseEvent event) throws IOException {
//    	Parent fxml = FXMLLoader.load(getClass().getResource("import3.fxml"));
//        contentArea.getChildren().removeAll();
//        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    void exit(MouseEvent event) {
        Timer timer = new Timer();
        TimerTask exitApp = new TimerTask() {
            public void run() {
                System.exit(0);
            }
        };
        timer.schedule(exitApp, new Date(System.currentTimeMillis() + 80 * 1));
    }

    @FXML
    void open_dashboard(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    void maximizeWindow(ActionEvent event) {
//        System.out.println("Maximize fireee!!!");
        Screen scr = Screen.getPrimary();
        Rectangle2D bounds = scr.getVisualBounds();

        if (this.isMaximize != true) {
            Launch.stage.setX(bounds.getMinX());
            Launch.stage.setY(bounds.getMinY());
            Launch.stage.setWidth(bounds.getWidth());
            Launch.stage.setHeight(bounds.getHeight());
        } else {
            Launch.stage.setX(this.minimize_X);
            Launch.stage.setY(this.minimize_Y);
            Launch.stage.setWidth(this.minimize_width);
            Launch.stage.setHeight(this.minimize_height);
        }

        this.isMaximize = !this.isMaximize;
    }

    @FXML
    void minimizeWindow(MouseEvent event) {
        Launch.stage.setIconified(true);

    }

    @FXML
    void open_notification(MouseEvent event) {

    }

}




