package com.universite.controller.ozel;

import com.universite.data.DataService;
import com.universite.utility.FXUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class OzelIletisimController {

    private FXUtil fxUtil;

    @FXML
    private TextField adsoyad;

    @FXML
    private TextField telefon;

    @FXML
    private TextArea mesaj;

    @FXML
    public void gonder(){
        String adSoyad = adsoyad.getText();
        String tel = telefon.getText();
        String msj = mesaj.getText();
        StringBuilder sb = new StringBuilder();
        sb.append("AdSoyad=").append(adSoyad).append("\n");
        sb.append("Telefon=").append(tel).append("\n");
        sb.append("mesaj=").append(msj);
        DataService service = new DataService();
        service.writeStr(sb.toString(), "ozeliletisim.txt");
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("Onay");
        ButtonType type = new ButtonType("Tamam", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText("Mesaj Gonderildi.");
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();

    }

    @FXML
    public void openOzel(ActionEvent e) throws IOException {
        fxUtil = new FXUtil();
        fxUtil.redirect(e, "/layout/ozel/ozeluniversite.fxml");
    }

}
