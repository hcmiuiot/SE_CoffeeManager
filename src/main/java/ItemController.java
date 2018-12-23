import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
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
    DrinksController drinkcontroller = new DrinksController();

    @FXML
    private AnchorPane itemPane;

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

    @FXML
    private JFXButton add_button;

    @FXML
    private StackPane dialog_pane;
    public String Tilename;
    public String Price;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dialog_pane.setVisible(false);
        try {
            Tile.setText(DrinksController.result.getString("name"));
            description.setText(DrinksController.result.getString("description"));
            price.setText(DrinksController.result.getString("price")+" Đ");
            imgView = new ImageView(new Image(DrinksController.result.getString("image")));
            imgView.setFitHeight(100);
            imgView.setFitWidth(100);
            image_box.getChildren().add(imgView);
            Tilename = Tile.getText();
            Price = price.getText();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(itemPane.getId());
    }



    @FXML
    private void filter(ActionEvent event) {
    }

    @FXML
    void add_item(MouseEvent event) {
        drinkcontroller.drinks.add(new Drink(Tilename,Price,Price,Price));
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Label(Tile.getText()));
        Label descrip = new Label();
        descrip.setText("Ok my babe");
        descrip.setWrapText(true);
        content.setBody(descrip);
        JFXDialog dialog = new JFXDialog(dialog_pane,content, JFXDialog.DialogTransition.CENTER);
        JFXButton button = new JFXButton("OK");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });

//            AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("item.fxml"));
            Label label = new Label("text");
            label.setUserData("text");
            label.setId("text");

//            DrinksController.container.getChildren().add(label);

        dialog_pane.setVisible(true);
        content.setActions(button);
        dialog.show();
    }

}
