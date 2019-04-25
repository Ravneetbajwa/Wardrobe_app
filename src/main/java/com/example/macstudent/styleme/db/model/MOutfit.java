package com.example.macstudent.styleme.db.model;

public class MOutfit {
    public byte[] _image;
    Integer _id;
    String _type;


    public MOutfit(){

    }

    public MOutfit(Integer id, String type, byte[] image){
        this._id = id;
        this._type = type;
        this._image= image;

    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
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
}
