import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;

import javax.imageio.IIOException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class LoginController {

    private double xOffset = 0;
    private double yOffset = 0;

    private Boolean isMaximize = false;

    //These magic number will be fixed soon - XT
    private Double minimize_X = 40.0;
    private Double minimize_Y = 40.0;
    private Double minimize_width = 1366.0;
    private Double minimize_height = 768.0;
    private static ResultSet result;
    String id, password;

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
    void maximizeWindow(ActionEvent event) {
//        Screen scr = Screen.getPrimary();
//        Rectangle2D bounds = scr.getVisualBounds();
//
//        if (!this.isMaximize) {
//            Launch.stage.setX(bounds.getMinX());
//            Launch.stage.setY(bounds.getMinY());
//            Launch.stage.setWidth(bounds.getWidth());
//            Launch.stage.setHeight(bounds.getHeight());
//        } else {
//            Launch.stage.setX(this.minimize_X);
//            Launch.stage.setY(this.minimize_Y);
//            Launch.stage.setWidth(this.minimize_width);
//            Launch.stage.setHeight(this.minimize_height);
//        }
//
//        this.isMaximize = !this.isMaximize;
    }

    @FXML
    void minimizeWindow(MouseEvent event) {
        Launch.stage.setIconified(true);
    }

    @FXML
    private JFXButton SignInButton;

    @FXML
    private JFXTextField id_input;

    @FXML
    private JFXPasswordField psw;


    public void loadDB() {
        // try {
        DbHandler.getInstance();
        String command = " SELECT PassWord FROM `Database`.Account where userName='" + id_input.getText() + "'";
        result = DbHandler.ExecSQL(command);
//        //result.first();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    public void onsignin(ActionEvent event) {
        loadDB();
        try {
            while (result.next()) {
                //   id = result.getString("userName");
                password = result.getString("PassWord");
                System.out.println(password);
                if (psw.getText().equals(password)) {
                    Parent root = FXMLLoader.load(getClass().getResource("MainForm.fxml"));
                    Scene scene = new Scene(root);
                    Launch.stage.setScene(scene);
                    Launch.stage.setResizable(true);
                    Launch.stage.show();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

