package com.universite.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataService implements DataInterface {

    @Override
    public void createFile(String fileName) {
        create(fileName);
    }

    @Override
    public void writeFile(TextData model) {
        write(model);
    }

    @Override
    public void deleteFile(String fileName) {
        delete(fileName);
    }

    @Override
    public ObservableList<TextData> readFile(String fileName) {
        ObservableList<TextData> list = FXCollections.observableArrayList();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                TextData model = new TextData(new SimpleStringProperty(fileName), new SimpleStringProperty(data),
                        new SimpleStringProperty(""));
                list.add(model);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String readFileStr(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            File myObj = new File(getPath()+fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                sb.append(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void create(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(String fileName){
        File file = new File(fileName);
        file.delete();
    }

    public void write(TextData model) {
        try {
            FileWriter fw = new FileWriter(getPath()+ model.getFileName());
            fw.write(model.getText());
            fw.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void writeStr(String str, String fileName) {
        try {
            FileWriter fw = new FileWriter(getPath()+ fileName);
            fw.write(str);
            fw.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ObservableList<TextData> fileList(String type){
        ObservableList<TextData> list = FXCollections.observableArrayList();

        File directory = new File(getPath()+type);
        for(String s : directory.list()){
            if(s.endsWith(".txt")){
                String txt = readFileStr(type+File.separator+s);
                TextData model = new TextData(new SimpleStringProperty(s), new SimpleStringProperty(txt),
                        new SimpleStringProperty(""));
                list.add(model);
            }
        }

        return list;
    }

    public String getPath() {
        return System.getProperty("user.dir") + File.separator;
    }
}
