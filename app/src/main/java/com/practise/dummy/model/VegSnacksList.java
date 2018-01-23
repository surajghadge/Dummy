package com.practise.dummy.model;

/**
 * Created by win 8 pc on 1/16/2018.
 */

public class VegSnacksList {

    private String itemid;
    private String itemname;
    private String price;

    public VegSnacksList(String itemid, String itemname, String price) {
        this.itemid = itemid;
        this.itemname = itemname;
        this.price = price;
    }


    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
