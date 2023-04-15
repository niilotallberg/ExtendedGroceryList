package com.example.fragmentgrocerylist;

public class ShoppingItem {
    private String itemName;
    private String extraInfo;
    private boolean isImportant;

    public ShoppingItem(String itemName, String extraInfo, boolean isImportant) {
        this.itemName = itemName;
        this.extraInfo = extraInfo;
        this.isImportant = isImportant;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }
}