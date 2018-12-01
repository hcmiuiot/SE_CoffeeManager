import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DrinksController implements Initializable {
    public static ResultSet result;

    @FXML
    private AnchorPane main;
    @FXML
    private TextField jtfSearch;
    @FXML
    private ScrollPane scroll_pane;
    @FXML
    private FlowPane container;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Parent fxml = null;
        loadDB();
        try {
            while (result.next()) {
                fxml = FXMLLoader.load(getClass().getResource("item.fxml"));
                System.out.println("chay di ma lam on ");
                container.getChildren().add(fxml);
            }
            scroll_pane.setContent(container);
            scroll_pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scroll_pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scroll_pane.setFitToWidth(true);
            scroll_pane.setPannable(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void filter(ActionEvent event) {
    }

    public void loadDB() {
        try {
            DbHandler.getInstance();
            result = DbHandler.ExecSQL("SELECT * FROM SE_Coffee_Manager.Items");
            result.first();



        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
