import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.concurrent.TimeoutException;

import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class LaunchTest extends ApplicationTest {

//    @Before
//    public void setUpClass() throws Exception {
//        ApplicationTest.launch(Launch.class);
//    }
    @After
    public void afterEachTest() throws TimeoutException {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainForm.fxml"));
        Scene scene = new Scene(root);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().getClass().getResource("Chart.css");
    }

    @Test
    public void should_test() {
        FxAssert.verifyThat(".button", hasText("    DashBoard"));
    }

//    @Test
//    public void should_test_2() {
////        clickOn("Drinks");
//        //verifyThat(".button", hasText("Exit"));
//    }

}