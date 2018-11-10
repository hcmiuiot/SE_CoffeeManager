import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class UiController implements Initializable {

    @FXML
    private AnchorPane parent;
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private AnchorPane contentArea;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        makeStageDrageable();
//        Parent fxml;
//		try {
//			fxml = FXMLLoader.load(getClass().getResource("import5.fxml"));
////		     contentArea.getChildren().removeAll();
//		        contentArea.getChildren().setAll(fxml);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

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
                Launch.stage.setX(event.getScreenX() - xOffset);
                Launch.stage.setY(event.getScreenY() - yOffset);
                Launch.stage.setOpacity(0.7f);
            }
        });
        parent.setOnDragDone((e) -> {
            Launch.stage.setOpacity(1.0f);
        });
        parent.setOnMouseReleased((e) -> {
            Launch.stage.setOpacity(1.0f);
        });

    }



    @FXML
    void open_import(MouseEvent event) throws IOException {
//    	  Parent fxml = FXMLLoader.load(getClass().getResource("import.fxml"));
//          contentArea.getChildren().removeAll();
//          contentArea.getChildren().setAll(fxml);
      }


    @FXML
    void open_export(MouseEvent event) throws IOException {
//    	 Parent fxml = FXMLLoader.load(getClass().getResource("import2.fxml"));
//         contentArea.getChildren().removeAll();
//         contentArea.getChildren().setAll(fxml);
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
            timer.schedule(exitApp, new Date(System.currentTimeMillis()+75*10));
    }
    @FXML
    void open_income(MouseEvent event) throws IOException {
//    	Parent fxml = FXMLLoader.load(getClass().getResource("import4.fxml"));
//        contentArea.getChildren().removeAll();
//        contentArea.getChildren().setAll(fxml);
    }

}




