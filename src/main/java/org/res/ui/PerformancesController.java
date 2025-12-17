package org.res.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.res.model.DataRepository;
import org.res.model.Performance;
import org.res.model.Reservation;

import java.io.IOException;
import java.util.List;

public class PerformancesController
{
    @FXML
    private ListView<Performance> performancesList;
    @FXML
    private Button exitButton;

    @FXML
    public void initialize() {
        List<Performance> performances= DataRepository.INSTANCE.getAllPerformances();
        this.performancesList.getItems().addAll(performances);
    }

    public void performanceItemAction(MouseEvent event) throws IOException
    {
        Performance p = this.performancesList.getSelectionModel().getSelectedItem();
        Reservation r= DataRepository.INSTANCE.newReservation(p);
        r.setPerformanceId(p.getId());
        App.INSTANCE.showReservation(r);
    }
}
