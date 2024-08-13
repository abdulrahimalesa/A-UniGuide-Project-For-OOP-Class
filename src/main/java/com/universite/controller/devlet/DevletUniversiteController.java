package com.universite.controller.devlet;

import com.universite.utility.FXUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class DevletUniversiteController {

    private FXUtil fxUtil;

    @FXML
    public void initialize(){
        fxUtil = new FXUtil();
    }

    @FXML
    public void openAvantajlar(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/devlet/avantajlar.fxml");
    }

    @FXML
    public void openEnIyi(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/devlet/eniyi.fxml");
    }

    @FXML
    public void openEnIyiYurt(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/devlet/eniyiyurt.fxml");
    }

    @FXML
    public void openIletisim(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/devlet/iletisim.fxml");
    }

    @FXML
    public void openMain(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/Main.fxml");
    }
}
