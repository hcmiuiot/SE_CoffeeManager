import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {

    public static void main(String[] args) {
        System.out.println("Hello World! 2");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainForm.fxml"));
            Parent root = loader.load();
            Scene mainScene = new Scene(root,400,400);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("SE Coffee House Manager");
            primaryStage.show();
        } catch ( IOException e) {
            System.out.println();
        }
    }
}
