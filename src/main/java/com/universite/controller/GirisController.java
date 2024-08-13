package com.universite.controller;

import com.universite.data.DataService;
import com.universite.utility.FXUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GirisController {

    private FXUtil fxUtil;

    @FXML
    TextField username;

    @FXML
    PasswordField password;

    @FXML
    public void initialize(){

        fxUtil = new FXUtil();
    }

    @FXML
    public void giris(ActionEvent e) throws IOException {
        String kulanıcıadı = username.getText();
        String pasord = password.getText();
        if (kulanıcıadı.equalsIgnoreCase("Admin") && pasord.equalsIgnoreCase("123")) {
            fxUtil.redirect(e, "/layout/adminmain.fxml");
        } else {
            fxUtil.redirect(e, "/layout/girismesaj.fxml");

        }
    }

    @FXML
    public void openLogin(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/giris.fxml");
    }

    @FXML
    public void openMain(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/Main.fxml");
    }
}
