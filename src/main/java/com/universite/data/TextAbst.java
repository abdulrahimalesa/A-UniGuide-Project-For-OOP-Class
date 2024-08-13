package com.universite.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class TextAbst {

    private StringProperty fileName = new SimpleStringProperty();
    private StringProperty text = new SimpleStringProperty();
    private StringProperty action = new SimpleStringProperty();

    public TextAbst(StringProperty fileName, StringProperty text, StringProperty action) {
        this.fileName = fileName;
        this.text = text;
        this.action = action;
    }

    public String getFileName() {
        return fileName.get();
    }

    public StringProperty fileNameProperty() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName.set(fileName);
    }

    public String getText() {
        return text.get();
    }

    public StringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public String getAction() {
        return action.get();
    }

    public StringProperty actionProperty() {
        return action;
    }

    public void setAction(String action) {
        this.action.set(action);
    }
}
