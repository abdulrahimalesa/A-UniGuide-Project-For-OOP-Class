package com.universite.controller.ozel;

import com.universite.utility.FXUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class OzelUniversiteController {

    private FXUtil fxUtil;

    @FXML
    public void initialize(){
        fxUtil = new FXUtil();
    }

    @FXML
    public void openAvantajlar(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/ozel/avantajlar.fxml");
    }

    @FXML
    public void openEnIyi(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/ozel/eniyi.fxml");
    }

    @FXML
    public void openEnIyiYurt(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/ozel/eniyiyurt.fxml");
    }

    @FXML
    public void openIletisim(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/ozel/iletisim.fxml");
    }

    @FXML
    public void openMain(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/Main.fxml");
    }
}
