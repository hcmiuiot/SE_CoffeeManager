import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.scene.control.ScrollPane;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

public class ItemController implements Initializable {



    @FXML
    private Label Tile;

    @FXML
    private Label description;

    @FXML
    private Label price;

    @FXML
    private StackPane image_box;

    @FXML
    private ImageView imgView;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Tile.setText(DrinksController.result.getString("product_name"));
            description.setText(DrinksController.result.getString("product_description"));
            price.setText(DrinksController.result.getString("product_price")+" Đ");
            imgView = new ImageView(new Image(DrinksController.result.getString("product_image")));
            imgView.setFitHeight(100);
            imgView.setFitWidth(100);
            image_box.getChildren().add(imgView);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @FXML
    private void filter(ActionEvent event) {
    }

}
