package eugene.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.prefs.BackingStoreException;

/**
 * Created by DCLab on 2016/11/6.
 */
public class FXApplication extends Application {

    public static void main(String[] args) throws IOException, InterruptedException, BackingStoreException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("Complex.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
