package org.res.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.res.model.Reservation;

import java.io.IOException;
import java.net.URL;

public class App extends javafx.application.Application
{
    public static App INSTANCE=null;
    private Stage stage;

    public static void main(String[] args) {
        try {
            javafx.application.Application.launch(App.class, args);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public App()  {
       INSTANCE=this;
    }

    @Override
    public void start(Stage stage) throws IOException  {
        this.stage=stage;
        showPerformances();
    }

    public void showPerformances() throws IOException {
        this.showScene("performances.fxml", new PerformancesController(), "Vorstellungen");
    }

    public void showReservation(Reservation r) throws IOException {
        this.showScene("reservation.fxml", new ReservationController(r), "Reservierung");
    }

    public void showScene(String fXmlFile, Object controller, String title) throws IOException
    {
        URL location = getClass().getResource("/"+fXmlFile);
        FXMLLoader loader = new FXMLLoader(location);
        loader.setController(controller);
        Pane root = loader.load();

        Scene scene = new Scene(root);
        String styleSheet=  getClass().getResource("/styles.css").toExternalForm();
        scene.getStylesheets().add(styleSheet);

        this.stage.setTitle(title);
        this.stage.setScene(scene);
        this.stage.show();
    }


}
