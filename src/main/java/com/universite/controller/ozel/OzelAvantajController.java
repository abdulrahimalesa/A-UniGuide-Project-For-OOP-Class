package com.universite.controller.ozel;

import com.universite.data.DataService;
import com.universite.utility.FXUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class OzelAvantajController {

    private FXUtil fxUtil;

    @FXML
    Text text;

    @FXML
    public void initialize(){
        fxUtil = new FXUtil();
        DataService service = new DataService();
        text.setText(service.readFileStr("ozelavantaj.txt"));
    }

    @FXML
    public void openMain(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/ozel/ozeluniversite.fxml");
    }
}
