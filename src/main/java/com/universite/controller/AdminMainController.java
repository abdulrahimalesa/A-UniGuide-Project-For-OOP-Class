package com.universite.controller;

import com.universite.utility.FXUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class AdminMainController {

    private FXUtil fxUtil;

    @FXML
    public void initialize(){
        fxUtil = new FXUtil();
    }

    @FXML
    public void openMain(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/giris.fxml");
    }

    @FXML
    public void openUniversite(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/ozeluniversiteler.fxml");
    }

    @FXML
    public void openYurtlar(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/ozelyurtlar.fxml");
    }

    @FXML
    public void openDevletUniversite(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/devletuniversiteler.fxml");
    }

    @FXML
    public void openDevletYurtlar(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/devletyurtlar.fxml");
    }
}
