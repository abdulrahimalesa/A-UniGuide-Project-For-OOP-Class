package com.universite.controller;

import com.universite.utility.FXUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainController {

    private FXUtil fxUtil;

    @FXML
    public void initialize()
    {
        fxUtil = new FXUtil();
    }

    @FXML
    public void openOzel(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/ozel/ozeluniversite.fxml" );
    }

    @FXML
    public void openDevlet(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/devlet/devletuniversite.fxml");
    }

    @FXML
    public void openGiris(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/giris.fxml");
    }
}
