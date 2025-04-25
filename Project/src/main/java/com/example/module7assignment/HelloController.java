package com.example.module7assignment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class HelloController implements Resource {

    public enum Major {
        CS, CPIS, English;
    }


    @FXML
    private Label welcomeText;

    Label statusLabel = new Label("Ready");

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Button editButton, deleteButton;

    @FXML
    private MenuItem editMenuItem, deleteMenuItem;

    @FXML
    private TableView<?> tableView;

    public void initialize(URL location, ResourceBundle resources) {
        editButton.setDisable(true);
        deleteButton.setDisable(true);
        editMenuItem.disable();
        deleteMenuItem.disable();

        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            boolean selected = newVal != null;
            editButton.setDisable(!selected);
            deleteButton.setDisable(!selected);
            editMenuItem.disable();
            deleteMenuItem.disable();
        });
    }

}


