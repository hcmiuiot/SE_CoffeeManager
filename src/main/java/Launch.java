import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Launch extends Application {


    public static Stage stage = null;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getvClass().getResource("MainForm.fxml"));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        this.stage = stage;
        stage.show();
        scene.getStylesheets().getClass().getResource("Chart.css");
    }


    public static void main(String[] args) {


        launch(args);

    }
}
