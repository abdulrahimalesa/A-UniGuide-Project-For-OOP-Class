package com.universite.data;

import javafx.collections.ObservableList;

public interface DataInterface {

    void createFile(String fileName);
    void writeFile(TextData model);
    void deleteFile(String fileName);
    ObservableList<TextData> readFile(String fileName);
    String readFileStr(String fileName);

}
