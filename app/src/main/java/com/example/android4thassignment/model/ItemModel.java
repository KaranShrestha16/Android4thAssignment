package com.example.android4thassignment.model;

public class ItemModel {
    private String _id;
    private String itemsName;
    private String itemPrice;
    private String itemImageName;
    private String itemDescriotion;

    public ItemModel(String _id, String itemsName, String itemPrice, String itemImageName, String itemDescriotion) {
        this._id = _id;
        this.itemsName = itemsName;
        this.itemPrice = itemPrice;
        this.itemImageName = itemImageName;
        this.itemDescriotion = itemDescriotion;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemImageName() {
        return itemImageName;
    }

    public void setItemImageName(String itemImageName) {
        this.itemImageName = itemImageName;
    }

    public String getItemDescriotion() {
        return itemDescriotion;
    }

    public void setItemDescriotion(String itemDescriotion) {
        this.itemDescriotion = itemDescriotion;
    }

}
