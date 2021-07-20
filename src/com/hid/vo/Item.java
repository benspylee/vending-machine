package com.hid.vo;

public class Item {

    private int itemCd;
    private String itemDesc;
    private double itemCost;
    private int quantity;

    public Item(int itemCd, String itemDesc, double itemCost, int quantity) {
        this.itemCd = itemCd;
        this.itemDesc = itemDesc;
        this.itemCost = itemCost;
        this.quantity = quantity;
    }

    public int getItemCd() {
        return itemCd;
    }

    public void setItemCd(int itemCd) {
        this.itemCd = itemCd;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
