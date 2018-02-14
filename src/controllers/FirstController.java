package controllers;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.logging.Logger;

/**
 * Created by nomanahmedsheikh on 11/02/18.
 */
public class FirstController {


    public Stage MainWindow = null;

    private final static Logger logger
            = Logger.getLogger(FirstController.class.getName());
    private final static String INVOICE_VIEW_FILE_NAME = "Invoice";

    @FXML
    private RadioButton stockRadio;



    public void initialize() {


    }

    @FXML
    private void radioActionCalled(Event event) {
        System.out.println("event.getClass() = " + event.getClass());
        System.out.println("event = " + event);
    }
}
