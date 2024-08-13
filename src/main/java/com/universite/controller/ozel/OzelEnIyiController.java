package com.universite.controller.ozel;

import com.universite.data.DataService;
import com.universite.data.TextData;
import com.universite.utility.FXUtil;
import com.universite.utility.StringUtil;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.io.IOException;

public class OzelEnIyiController {

    @FXML
    private GridPane dataList;

    private FXUtil fxUtil;

    @FXML
    public void initialize(){
        fxUtil = new FXUtil();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(40);
        dataList.getColumnConstraints().addAll(column1, column1, column1);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(40);
        dataList.getRowConstraints().addAll(row1, row1, row1);
        dataList.setHgap(15);
        dataList.setVgap(15);
        dataList.setPadding(new Insets(10, 10, 10, 10));

        DataService service = new DataService();
        fillData(service.fileList("ozel"));
    }

    public void fillData(ObservableList<TextData> dList){
        int row = 0;
        int col = 0;
        int index = 0;
        DataService service = new DataService();
        for(TextData td : dList){
            VBox pane = new VBox();
            pane.setAlignment(Pos.CENTER);
            pane.setStyle("-fx-border-color: black; -fx-background-color: WHITE;");
            pane.setSpacing(20);

            File file = new File(service.getPath()+"ozel"+File.separator+td.getFileName()+".png");
            Image image = new Image(file.toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(76.0);
            imageView.setFitWidth(88.0);

            Label header = new Label(td.getFileName().replace(".txt", ""));

            Button bilgiButton = new Button("Daha Fazla Bilgi");
            bilgiButton.setStyle("-fx-background-color: #ff0000; -fx-background-radius: 25;");

            pane.getChildren().addAll(imageView, header, bilgiButton);

            bilgiButton.setOnAction(event -> {
                StringUtil.select = td;
                openDetay(event);
            });

            dataList.addRow(row, pane);
            col++;
            index++;
            if(col == 3){
                row++;
                col = 0;
            }
        }
    }

    @FXML
    public void openMain(ActionEvent e) throws IOException {
        fxUtil.redirect(e, "/layout/ozel/ozeluniversite.fxml");
    }

    public void openDetay(ActionEvent e) {
        try {
            fxUtil.redirect(e, "/layout/ozel/eniyidetay.fxml");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
