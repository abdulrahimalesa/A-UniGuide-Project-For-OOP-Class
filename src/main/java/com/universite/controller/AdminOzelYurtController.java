package com.universite.controller;

import com.universite.data.DataService;
import com.universite.data.TextData;
import com.universite.utility.FXUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AdminOzelYurtController {

    private FXUtil fxUtil;

    private Stage dialogStage;

    @FXML
    private TextField fileName;

    @FXML
    private TextField imagePath;

    @FXML
    private TextArea text;

    @FXML
    private TableView table;

    @FXML
    public void initialize(){
        fxUtil = new FXUtil();
        if(table != null){
            TableColumn<TextData, String> dosyaAdiColumn = new TableColumn<>("Dosya Adı");
            dosyaAdiColumn.setCellValueFactory(new PropertyValueFactory<>("fileName"));
            dosyaAdiColumn.setStyle("-fx-alignment: CENTER;");

            TableColumn<TextData, String> icerikColumn = new TableColumn<>("İçerik");
            icerikColumn.setCellValueFactory(new PropertyValueFactory<>("text"));
            icerikColumn.setStyle("-fx-alignment: CENTER;");

            TableColumn<TextData, String> actionColumn = new TableColumn<>("Action");
            actionColumn.setCellValueFactory(new PropertyValueFactory<>("Action"));
            actionColumn.setStyle("-fx-alignment: CENTER;");

            Callback<TableColumn<TextData, String>, TableCell<TextData, String>> cellFactory
                    = new Callback<TableColumn<TextData, String>, TableCell<TextData, String>>() {
                @Override
                public TableCell call(final TableColumn<TextData, String> param) {
                    final TableCell<TextData, String> cell = new TableCell<TextData, String>() {

                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                                setText(null);
                            } else {
                                final Button delete = new Button("Sil");
                                delete.setOnAction(event -> {
                                    TextData model = getTableView().getItems().get(getIndex());
                                    DataService service = new DataService();
                                    service.deleteFile(service.getPath() + "ozelyurt"+ File.separator+model.getFileName());
                                    service.deleteFile(service.getPath() + "ozelyurt"+File.separator+model.getFileName()+".png");
                                    fillTable();
                                });

                                setGraphic(delete);
                                setText(null);
                            }
                        }
                    };
                    return cell;
                }
            };
            actionColumn.setCellFactory(cellFactory);
            table.getColumns().addAll(dosyaAdiColumn, icerikColumn, actionColumn);
            fillTable();
        }
    }

    public void fillTable(){
        DataService service = new DataService();
        table.getItems().clear();
        table.getItems().addAll(service.fileList("ozelyurt"));
    }

    @FXML
    void kaydet(ActionEvent event) throws IOException {
        TextData data = new TextData(new SimpleStringProperty("ozelyurt"+ File.separator+fileName.getText()), new SimpleStringProperty(text.getText()), new SimpleStringProperty(""));
        DataService service = new DataService();
        service.writeFile(data);
        String src = imagePath.getText();
        String dst = service.getPath()+"ozelyurt"+File.separator+fileName.getText()+".png";
        if(new File(src).isFile()){
            Files.copy(new File(src).toPath(), new File(dst).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        closeStage(event);
    }

    @FXML
    void ekle(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/layout/ozelyurtekle.fxml"));
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent);
        dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
        fillTable();
    }

    private void closeStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void openAdmin(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/adminmain.fxml");
    }
}
