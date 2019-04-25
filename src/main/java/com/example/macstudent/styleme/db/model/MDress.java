package com.example.macstudent.styleme.db.model;

public class MDress {

    public byte[] _image;
    String _type;

    String _color;
    String _season;

    public MDress(){

    }

    public MDress(String color, byte[] image, String type, String season){
        this._color = color;
        this._type = type;
        this._image = image;
        this._season = season;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public byte[] get_image() {
        return _image;
    }

    public void set_image(byte[] _image) {
        this._image = _image;
    }

    public String get_color() {
        return _color;
    }

    public void set_color(String _color) {
        this._color = _color;
    }

    public String get_season() {
        return _season;
    }

    public void set_season(String _season) {
        this._season = _season;
    }
}

