package com.universite.controller.devlet;

import com.universite.data.DataService;
import com.universite.data.TextData;
import com.universite.utility.FXUtil;
import com.universite.utility.StringUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;

public class DevletEnIyiYurtDetayController {

    private FXUtil fxUtil;

    @FXML
    private Text text;

    @FXML
    private ImageView image;

    private TextData data;

    @FXML
    public void initialize() {
        fxUtil = new FXUtil();
        data = StringUtil.select;
        text.setText(data.getText());
        DataService service = new DataService();
        String imageUrl = service.getPath()+"devletyurt"+ File.separator+data.getFileName()+".png";
        File file = new File(imageUrl);
        Image img = new Image(file.toURI().toString());
        image.setImage(img);
    }

    @FXML
    public void openMain(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/devlet/eniyiyurt.fxml");
    }
}
