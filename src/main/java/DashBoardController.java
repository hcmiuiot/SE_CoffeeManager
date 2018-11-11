import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;


public class DashBoardController implements Initializable {

    @FXML
    private AnchorPane main;

    @FXML
    private TextField jtfSearch;

    @FXML
    private AreaChart<?, ?> areachart;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series series = new XYChart.Series<>();
        XYChart.Series series1 = new XYChart.Series<>();

        series.getData().add(new XYChart.Data("12/2017",1260));
        series.getData().add(new XYChart.Data("01/2018",1560));
        series.getData().add(new XYChart.Data("02/2018",0));
        series.getData().add(new XYChart.Data("03/2018",2100));
        series.getData().add(new XYChart.Data("04/2018",1250));
        series.getData().add(new XYChart.Data("05/2018",1475));
        series.getData().add(new XYChart.Data("06/2018",1350));
        series.getData().add(new XYChart.Data("07/2018",0));

        series1.getData().add(new XYChart.Data("12/2017",750));
        series1.getData().add(new XYChart.Data("01/2018",750));
        series1.getData().add(new XYChart.Data("02/2018",750));
        series1.getData().add(new XYChart.Data("03/2018",750));
        series1.getData().add(new XYChart.Data("04/2018",750));
        series1.getData().add(new XYChart.Data("05/2018",750));
        series1.getData().add(new XYChart.Data("06/2018",750));
        series1.getData().add(new XYChart.Data("07/2018",750));


        //areachart.getData().addAll(series1,series);
        areachart.getData().add(series);
        //areachart.getData().add(series1);

//        JFXTreeTableColumn<User, String> deptName = new JFXTreeTableColumn<>("Amount");
//        deptName.setPrefWidth(150);
//        deptName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
//                return param.getValue().getValue().department;
//            }
//        });
//
//        JFXTreeTableColumn<User, String> ageCol = new JFXTreeTableColumn<>("Product ID");
//        ageCol.setPrefWidth(150);
//        ageCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
//                return param.getValue().getValue().age;
//            }
//        });
//
//        JFXTreeTableColumn<User, String> nameCol = new JFXTreeTableColumn<>("Name");
//        nameCol.setPrefWidth(150);
//        nameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
//                return param.getValue().getValue().userName;
//            }
//        });
//        JFXTreeTableColumn<User, String> priceCol = new JFXTreeTableColumn<>("Price");
//        priceCol.setPrefWidth(150);
//        priceCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
//                return param.getValue().getValue().department1;
//            }
//        });
//        JFXTreeTableColumn<User, String> dateCol = new JFXTreeTableColumn<>("Date");
//        dateCol.setPrefWidth(150);
//        dateCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
//                return param.getValue().getValue().department2;
//            }
//        });
//
//        ObservableList<User> users = FXCollections.observableArrayList();
//        users.add(new User("1   x   $180", "AC7836", "Ultraboost Parley LTD Shoes","$180","20/12/2017",""));
//        users.add(new User("1   x   $130", "AQ1059", "POD-S3.1 Shoes","$130","20/12/2017",""));
//        users.add(new User("1   x   $200", "AQ0482", "Ultraboost Clima Shoes","$200","20/12/2017",""));
//        users.add(new User("1   x   $170", "CM8304", "Pureboost Shoes","$170","20/12/2017",""));
//        users.add(new User("1   x   $100", "AQ0573", "Alphabounce Beyond Shoes","$100","21/12/2017",""));
//        users.add(new User("3   x   $140", "AQ0191", "Adizero Adios 3 Shoes","$420","21/12/2017",""));
//        users.add(new User("2   x   $300", "DB2010", "Predator 18+ Firm Ground","$600","21/12/2017",""));
//
//        users.add(new User("3   x   $200", "CM7687", "Predator Tango 18+ Shoes","$600","15/01/2018",""));
//        users.add(new User("4   x   $140", "BB6608", "Response Trail Shoes","$560","15/01/2018",""));
//        users.add(new User("4   x   $100", "B27814", "Alphabounce EM WC Shoes","$400","15/01/2018",""));
//
//        users.add(new User("3   x   $65", "BB6920", "Duramo 9 Shoes","$195","14/03/2018",""));
//        users.add(new User("3   x   $85", "B22742", "Lucas Premiere Mid Shoes","$255","14/03/2018",""));
//        users.add(new User("3   x   $160", "B22742", "Solarboost Shoes","$480","14/03/2018",""));
//        users.add(new User("6   x   $130", "DA9562", "Adizero 5-Star 7.0 SK Cleats","$780","14/03/2018",""));
//        users.add(new User("2   x   $130", "B41688", "Lucas Premiere Primeknit Shoes","$390","14/03/2018",""));
//
//        users.add(new User("1   x   $140", "BB6622", "Supernova Trail Shoes","$140","17/04/2018",""));
//        users.add(new User("1   x   $150", "B41689", "3ST.002 Primeknit Shoes","$150","17/04/2018",""));
//        users.add(new User("1   x   $160", "CQ3169", "Solarboost Shoes","$160","17/04/2018",""));
//        users.add(new User("1   x   $100", "AQ0536", "Aerobounce 2 Shoes","$100","17/04/2018",""));
//        users.add(new User("1   x   $130", "CP8852", "Adizero Ubersonic 3.0 Shoes","$130","17/04/2018",""));
//        users.add(new User("1   x   $100", "AQ0087", "Adizero Afterburner V Dipped Cleats","$100","17/04/2018",""));
//        users.add(new User("1   x   $100", "CG5218", "Adizero Afterburner V Cleats","$100","17/04/2018",""));
//        users.add(new User("1   x   $70", "B96557", "Run 70s Shoes","$70","17/04/2018",""));
//
//        users.add(new User("10   x   $75", "M20325", "Stan Smith Shoes","$750","16/05/2018",""));
//
//        users.add(new User("1   x   $75", "M20325", "Stan Smith Shoes","$75","14/06/2018",""));
//        users.add(new User("1   x   $120", "B37372", "EQT Support Mid ADV Primeknit Shoes","$120","14/06/2018",""));
//        users.add(new User("1   x   $140", "B37627", "NMD_R1 Primeknit Shoes","$140","14/06/2018",""));
//        users.add(new User("1   x   $110", "B37435", "Nike SB Stefan Janoski Max","$110","14/06/2018",""));
//        users.add(new User("1   x   $50", "B37350", "Converse Chuck Taylor All Star Low Top","$50","14/06/2018",""));
//        users.add(new User("1   x   $50", "M20325", "Jordan Hydro 7","$50","14/06/2018",""));
//        users.add(new User("1   x   $128.97", "AQ2363", "LeBron 15","$128.97","14/06/2018",""));
//        users.add(new User("1   x   $225", "AH6834", "Nike Air VaporMax Flyknit Utility","$225","14/06/2018",""));
//        users.add(new User("1   x   $150", "AR3772", "Nike Epic React Flyknit BETRUE","$150","14/06/2018",""));
//        users.add(new User("1   x   $100", "M20325", "Nike Air Force 1 Low 07 LV8","$100","14/06/2018",""));
//
//     // users.add(new User("1", "D96635", "NMD_R1 Shoes","$130","21/12/2017",""));
////        users.add(new User("2", "22", "Employee 1"));
////        users.add(new User("3", "22", "Employee 2"));
////        users.add(new User("Sales Department", "25", "Employee 4"));
////        users.add(new User("Sales Department", "25", "Employee 5"));
////        users.add(new User("IT Department", "42", "ID 2"));
////        users.add(new User("HR Department", "22", "HR 1"));
////        users.add(new User("HR Department", "22", "HR 2"));
//
//        final TreeItem<User> root = new RecursiveTreeItem<User>(users, RecursiveTreeObject::getChildren);
//        treeView.getColumns().setAll( ageCol, nameCol,deptName,priceCol,dateCol);
//        treeView.setRoot(root);
//        treeView.setShowRoot(false);
//        jtfSearch.textProperty().addListener(new ChangeListener<String>() {
//
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				treeView.setPredicate(new Predicate<TreeItem<User>>() {
//
//					@Override
//					public boolean test(TreeItem<User> user) {
//						Boolean flag = user.getValue().age.getValue().contains(newValue)||user.getValue().userName.getValue().contains(newValue)||user.getValue().department1.getValue().contains(newValue)||user.getValue().department2.getValue().contains(newValue);
//						return flag;
//					}
//
//				});
//
//			}
//
//		});

    }

    @FXML
    private void filter(ActionEvent event) {
    }

//    class User extends RecursiveTreeObject<User> {
//
//        StringProperty userName;
//        StringProperty age;
//        StringProperty department;
//        StringProperty department1;
//        StringProperty department2;
//        StringProperty department3;
//
//        public User(String department, String age, String userName,String department1,String department2,String department3) {
//            this.department = new SimpleStringProperty(department);
//            this.userName = new SimpleStringProperty(userName);
//            this.age = new SimpleStringProperty(age);
//            this.department1 = new SimpleStringProperty(department1);
//            this.department2 = new SimpleStringProperty(department2);
//            this.department3 = new SimpleStringProperty(department3);
//
//        }
//
//    }
}
