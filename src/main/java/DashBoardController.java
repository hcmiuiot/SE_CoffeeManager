import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.sql.SQLException;
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

        areachart.getData().add(series);
    }

    @FXML
    private void filter(ActionEvent event) {
    }


}
