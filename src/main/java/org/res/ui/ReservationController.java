package org.res.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.res.model.Reservation;


public class ReservationController
{
    private final Reservation reservation;

    @FXML
    private TextField firstNameTxt;
    @FXML
    private TextField lastNameTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField seatsTxt;
    @FXML
    private Label userMessageTxt;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;

    public ReservationController(Reservation r)  {
        this.reservation=r;
    }

    @FXML
    public void initialize() {
        okButton.setOnAction(this::handleOk);
    }

    private void handleOk(ActionEvent e)
    {
        eraseError();
        if (firstNameTxt.getText().isEmpty()) {
            raiseError("Vorname darf nicht leer sein");
        }
        else if (lastNameTxt.getText().isEmpty()) {
            raiseError("Nachname darf nicht leer sein");
        }
        else if (emailTxt.getText().isEmpty()) {
            raiseError("e-Mail darf nicht leer sein");
        }
        else if (seatsTxt.getText().isEmpty()) {
            raiseError("Anzahl der Plätze darf nicht leer sein");
        }
        else {
            try {
                Integer.parseInt(seatsTxt.getText());
            } catch (NumberFormatException ex) {
                raiseError("Anzahl der Plätze muss eine Zahl >0 sein");
            }
        }
    }

    private void raiseError(String message) {
        userMessageTxt.setText(message);
    }

    private void eraseError() {userMessageTxt.setText("");}

}
