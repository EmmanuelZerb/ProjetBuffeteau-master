package sio.helplerebours;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelpLeReboursApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelpLeReboursApplication.class.getResource("helplerebours-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Help Le Rebours !");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}