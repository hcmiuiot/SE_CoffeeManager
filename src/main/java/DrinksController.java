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
import java.util.ResourceBundle;

public class DrinksController implements Initializable {
    private ResultSet result;

    @FXML
    private AnchorPane main;
    @FXML
    private JFXTreeTableView<User> treeView;
    @FXML
    private TextField jtfSearch;
    @FXML
    private ScrollPane scroll_pane;
    @FXML
    private FlowPane container;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Parent fxml = null;
        try {
            for (int i = 0 ; i<= 10 ; i++){
                fxml = FXMLLoader.load(getClass().getResource("item.fxml"));
                container.getChildren().add(fxml);
            }
            scroll_pane.setContent(container);
            scroll_pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            //scroll_pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void filter(ActionEvent event) {
    }



    class User extends RecursiveTreeObject<User> {

        StringProperty name;
        StringProperty productID;
        StringProperty amount;
        StringProperty price;
        StringProperty date;
        //StringProperty amount3;

        public User(String amount, String productID, String name, String price, String date, String amount3) {
            this.amount = new SimpleStringProperty(amount);
            this.name = new SimpleStringProperty(name);
            this.productID = new SimpleStringProperty(productID);
            this.price = new SimpleStringProperty(price);
            this.date = new SimpleStringProperty(date);
            //this.amount3 = new SimpleStringProperty(amount3);

        }

    }
}
