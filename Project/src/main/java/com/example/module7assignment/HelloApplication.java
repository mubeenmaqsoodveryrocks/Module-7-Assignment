package com.example.module7assignment;

import com.sun.javafx.menu.MenuItemBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jdk.internal.icu.text.UnicodeSet;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();



        Menu fileMenu = new Menu("File");
        MenuItem importCSV = new MenuItem("Import CSV");
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("data.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                UnicodeSet dataList = null;
                dataList.add(YourModel.fromCSV(line));
            }
        }

        MenuItem exportCSV = new MenuItem("Export CSV");
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("data.csv"))) {
            YourModel[] dataList = new YourModel[0];
            for (YourModel obj : dataList) {
                writer.write(obj.toCSV());
                writer.newLine();
            }
        }

    }

    

    public static void main(String[] args) {
        launch();
    }
    public static final String NAME_REGEX = "^[A-Z][a-z]+$";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@farmingdale\\.edu$";
    public static final String ZIP_REGEX = "^\\d{5}(-\\d{4})?$";


}