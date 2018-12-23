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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class DrinksController implements Initializable {
    public static ResultSet result;
    public Parent fxml = null;
    @FXML
    private JFXTreeTableView<Drink> treeView;
    @FXML
    private JFXButton sort;
    @FXML
    private JFXButton shopping_cart;
    @FXML
    private AnchorPane main;
    @FXML
    private TextField jtfSearch;
    @FXML
    private ScrollPane scroll_pane;
    @FXML
    private FlowPane container;
    @FXML
    private StackPane shoppingcart_pane;
//    @FXML
//    private JFXButton hide_shoppingcartpane_button;

    public static ObservableList<Drink> drinks = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shoppingcart_pane.setVisible(false);
        loadDB();

        try {
            while (result.next()) {
                fxml = FXMLLoader.load(getClass().getResource("item.fxml"));
                //System.out.println("chay di ma lam on ");
                container.getChildren().add(fxml);
            }
            scroll_pane.setContent(container);
            scroll_pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scroll_pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scroll_pane.setFitToWidth(true);
            scroll_pane.setPannable(true);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void open_shopping_cart(MouseEvent event) {
        JFXTreeTableColumn<Drink, String> NameCol = new JFXTreeTableColumn<>("Name");
        NameCol.setPrefWidth(150);
        NameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Drink, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Drink, String> param) {
                return param.getValue().getValue().Tile;
            }
        });

        JFXTreeTableColumn<Drink, String> priceCol = new JFXTreeTableColumn<>("Price");
        priceCol.setPrefWidth(150);
        priceCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Drink, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Drink, String> param) {
                return param.getValue().getValue().price;
            }
        });

        //drinks.add(new Drink("khoa","khoa","khoa","khoa"));
        final TreeItem<Drink> root = new RecursiveTreeItem<Drink>(drinks, RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll( NameCol,priceCol);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
        treeView.setVisible(false);
        shoppingcart_pane.setVisible(false);
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Label("Shopping Cart"));
        content.setBody(treeView);
        JFXDialog dialog = new JFXDialog(shoppingcart_pane,content, JFXDialog.DialogTransition.TOP);
        JFXButton button = new JFXButton("OK");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
                treeView.setVisible(false);
                shoppingcart_pane.setVisible(false);
            }
        });
        content.setActions(button);
        dialog.show();
        shoppingcart_pane.setVisible(true);
        treeView.setVisible(true);

    }
//    @FXML
//    void hide_shoppingcart_pane(MouseEvent event) {
//    shoppingcart_pane.setVisible(false);
//    }



}
class Drink extends RecursiveTreeObject<Drink> {

    StringProperty Tile;
    StringProperty description;
    StringProperty price;
    StringProperty image;


    public Drink(String Tile, String description, String price,String image) {
        this.Tile = new SimpleStringProperty(Tile);
        this.description = new SimpleStringProperty(description);
        this.price = new SimpleStringProperty(price);
        this.image = new SimpleStringProperty(image);



    }
    public String getTileName(){
        return Tile.get();
    }
    public String getDescription(){
        return description.get();
    }
    public String getPrice(){
        return price.get();
    }
    public String getImage(){
        return image.get();
    }
}

