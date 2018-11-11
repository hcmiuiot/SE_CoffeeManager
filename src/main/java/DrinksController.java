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
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class DrinksController implements Initializable {
	private ResultSet result;

    @FXML
    private AnchorPane main;
    @FXML
    private JFXTreeTableView<User> treeView;
    @FXML
    private TextField jtfSearch;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	//loadDB();
    	
        JFXTreeTableColumn<User, String> deptName = new JFXTreeTableColumn<>("Amount");
        deptName.setPrefWidth(150);
        deptName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().amount;
            }
        });

        JFXTreeTableColumn<User, String> productIDCol = new JFXTreeTableColumn<>("Product ID");
        productIDCol.setPrefWidth(150);
        productIDCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().productID;
            }
        });

        JFXTreeTableColumn<User, String> nameCol = new JFXTreeTableColumn<>("Name");
        nameCol.setPrefWidth(150);
        nameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().name;
            }
        });
        JFXTreeTableColumn<User, String> priceCol = new JFXTreeTableColumn<>("Price");
        priceCol.setPrefWidth(150);
        priceCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().price;
            }
        });
        JFXTreeTableColumn<User, String> dateCol = new JFXTreeTableColumn<>("Date");
        dateCol.setPrefWidth(150);
        dateCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().date;
            }
        });

        ObservableList<User> users = FXCollections.observableArrayList();
        users.add(new User("1   x   $180", "AC7836", "Ultraboost Parley LTD Shoes","$180","20/12/2017",""));
        users.add(new User("1   x   $130", "AQ1059", "POD-S3.1 Shoes","$130","20/12/2017",""));
        users.add(new User("1   x   $200", "AQ0482", "Ultraboost Clima Shoes","$200","20/12/2017",""));
        users.add(new User("1   x   $170", "CM8304", "Pureboost Shoes","$170","20/12/2017",""));
        users.add(new User("1   x   $100", "AQ0573", "Alphabounce Beyond Shoes","$100","21/12/2017",""));
        users.add(new User("3   x   $140", "AQ0191", "Adizero Adios 3 Shoes","$420","21/12/2017",""));
        users.add(new User("2   x   $300", "DB2010", "Predator 18+ Firm Ground","$600","21/12/2017",""));

        users.add(new User("3   x   $200", "CM7687", "Predator Tango 18+ Shoes","$600","15/01/2018",""));
        users.add(new User("4   x   $140", "BB6608", "Response Trail Shoes","$560","15/01/2018",""));
        users.add(new User("4   x   $100", "B27814", "Alphabounce EM WC Shoes","$400","15/01/2018",""));

        users.add(new User("3   x   $65", "BB6920", "Duramo 9 Shoes","$195","14/03/2018",""));
        users.add(new User("3   x   $85", "B22742", "Lucas Premiere Mid Shoes","$255","14/03/2018",""));
        users.add(new User("3   x   $160", "B22742", "Solarboost Shoes","$480","14/03/2018",""));
        users.add(new User("6   x   $130", "DA9562", "Adizero 5-Star 7.0 SK Cleats","$780","14/03/2018",""));
        users.add(new User("2   x   $130", "B41688", "Lucas Premiere Primeknit Shoes","$390","14/03/2018",""));

        users.add(new User("1   x   $140", "BB6622", "Supernova Trail Shoes","$140","17/04/2018",""));
        users.add(new User("1   x   $150", "B41689", "3ST.002 Primeknit Shoes","$150","17/04/2018",""));
        users.add(new User("1   x   $160", "CQ3169", "Solarboost Shoes","$160","17/04/2018",""));
        users.add(new User("1   x   $100", "AQ0536", "Aerobounce 2 Shoes","$100","17/04/2018",""));
        users.add(new User("1   x   $130", "CP8852", "Adizero Ubersonic 3.0 Shoes","$130","17/04/2018",""));
        users.add(new User("1   x   $100", "AQ0087", "Adizero Afterburner V Dipped Cleats","$100","17/04/2018",""));
        users.add(new User("1   x   $100", "CG5218", "Adizero Afterburner V Cleats","$100","17/04/2018",""));
        users.add(new User("1   x   $70", "B96557", "Run 70s Shoes","$70","17/04/2018",""));
        users.add(new User("6   x   $50", "M20325", "Jordan Hydro 7","$300","17/04/2018",""));

        users.add(new User("10   x   $75", "M20325", "Stan Smith Shoes","$750","16/05/2018",""));
        users.add(new User("10   x   $50", "M20325", "Converse Chuck Taylor All Star Low Top","$500","16/05/2018",""));
        users.add(new User("1   x   $225", "AH6834", "Nike Air VaporMax Flyknit Utility","$225","16/05/2018",""));

        users.add(new User("1   x   $75", "M20325", "Stan Smith Shoes","$75","14/06/2018",""));
        users.add(new User("1   x   $120", "B37372", "EQT Support Mid ADV Primeknit Shoes","$120","14/06/2018",""));
        users.add(new User("1   x   $140", "B37627", "NMD_R1 Primeknit Shoes","$140","14/06/2018",""));
        users.add(new User("1   x   $110", "B37435", "Nike SB Stefan Janoski Max","$110","14/06/2018",""));
        users.add(new User("1   x   $50", "B37350", "Converse Chuck Taylor All Star Low Top","$50","14/06/2018",""));
        users.add(new User("1   x   $50", "M20325", "Jordan Hydro 7","$50","14/06/2018",""));
        users.add(new User("1   x   $128.97", "AQ2363", "LeBron 15","$128.97","14/06/2018",""));
        users.add(new User("1   x   $225", "AH6834", "Nike Air VaporMax Flyknit Utility","$225","14/06/2018",""));
        users.add(new User("1   x   $150", "AR3772", "Nike Epic React Flyknit BETRUE","$150","14/06/2018",""));
        users.add(new User("1   x   $100", "M20325", "Nike Air Force 1 Low 07 LV8","$100","14/06/2018",""));
        users.add(new User("10   x   $60", "B41767", "Vans Old Skool","$600","14/06/2018",""));
//        try {
//        	while (result.next()) {
//        		String productid = result.getString("Product_ID");
//        		String name = result.getString("Name");
//        		String amount = result.getString("Amount");
//        		String price = result.getString("Price");
//        		String date = result.getString("Date");
//
//        		users.add(new User(amount,productid,name,price,date,""));
//
//        	}
//        	result.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
     // users.add(new User("1", "D96635", "NMD_R1 Shoes","$130","21/12/2017",""));
//        users.add(new User("2", "22", "Employee 1"));
//        users.add(new User("3", "22", "Employee 2"));
//        users.add(new User("Sales Department", "25", "Employee 4"));
//        users.add(new User("Sales Department", "25", "Employee 5"));
//        users.add(new User("IT Department", "42", "ID 2"));
//        users.add(new User("HR Department", "22", "HR 1"));
//        users.add(new User("HR Department", "22", "HR 2"));



      
        
        final TreeItem<User> root = new RecursiveTreeItem<User>(users, RecursiveTreeObject::getChildren);
//        treeView.getColumns().setAll( productIDCol, nameCol,deptName,priceCol,dateCol);
        treeView.getColumns().setAll( productIDCol, nameCol);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
        jtfSearch.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				treeView.setPredicate(new Predicate<TreeItem<User>>() {
					
					@Override
					public boolean test(TreeItem<User> user) {
						Boolean flag = user.getValue().productID.getValue().contains(newValue)||user.getValue().name.getValue().contains(newValue)||user.getValue().price.getValue().contains(newValue)||user.getValue().date.getValue().contains(newValue);
						return flag;
					}
					
				});
				
			}
        	
		});
    
//    Workbook workbook = new HSSFWorkbook();
//    Sheet spreadsheet = workbook.createSheet("sample");
//
//    Row row = spreadsheet.createRow(0);
//
//    for (int j = 0; j < treeView.getColumns().size(); j++) {
//        row.createCell(j).setCellValue(treeView.getColumns().get(j).getText());
//    }
//
//    for (int i = 0; i < treeView.getCurrentItemsCount(); i++) {
//        row = spreadsheet.createRow(i + 1);
//        for (int j = 0; j < treeView.getColumns().size(); j++) {
//            if(treeView.getColumns().get(j).getCellData(i) != null) { 
//                row.createCell(j).setCellValue(treeView.getColumns().get(j).getCellData(i).toString()); 
//            }
//            else {
//                row.createCell(j).setCellValue("");
//            }   
//        }
//    }
//
//    FileOutputStream fileOut;
//	try {
//		fileOut = new FileOutputStream("workbook.xls");
//		try {
//			workbook.write(fileOut);
//			fileOut.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
 }

    @FXML
    private void filter(ActionEvent event) {
    }
    
//    public void loadDB() {
//		try {
//			DbHandler.getInstance();
//			//			Connection connect = null;
////			connect.createStatement().executeQuery("USE topicS");
//			result = DbHandler.ExecSQL("SELECT * FROM Study.product");
//			result.first();
//
////			result1 = DbHandler.getConnection().createStatement().executeQuery("SELECT * FROM topicS.Enroll WHERE studentID LIKE '%"+LoginController.getID()+"%'");
////			result1.first();
//
//
//
//			}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}
//    }

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
