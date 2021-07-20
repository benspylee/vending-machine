package com.hid.machine;

import com.hid.vo.Item;

import java.util.ArrayList;
import java.util.List;

public class SoftDrinkMachine {

    private List<Item> itemList;
    private List<Item> cartItems;

    public List<Item> getItemList() {
        return itemList;
    }

    public List<Item> getCartItems() {
        return cartItems;
    }

    public SoftDrinkMachine() {
        itemList = new ArrayList<>();
        cartItems = new ArrayList<>();
        itemList.add(new Item(1, "Coke(can)", 0.75, 8));
        itemList.add(new Item(2, "Coke(bottle)", 1.25, 8));
        itemList.add(new Item(3, "Mountain Dew(can)", 0.75, 8));
        itemList.add(new Item(4, "Water", 1.25, 8));
        itemList.add(new Item(5, "Full throttle", 2.00, 8));
    }

    public boolean addItemToCart(Item item) {
        if (item.getQuantity() == 0) return false;
        itemList.stream().filter(obj -> obj.getItemCd() == item.getItemCd()).forEach(obj -> {
            obj.setQuantity(obj.getQuantity() - 1);
        });
        return cartItems.add(item);
    }

    public void calculateSales() {
        double totalSales = 0.0d;
        totalSales = cartItems.stream().mapToDouble(Item::getItemCost).sum();
        double finalTotalSales = totalSales;
        printResult(finalTotalSales);

    }

    public void printListOfItems() {
        itemList.forEach(obj -> {
            System.out.println("'" + obj.getItemCd() + "' ->" + "\t" + obj.getItemDesc());
        });
        System.out.println("Select an item");
    }


    private void printResult(double finalTotalSales) {
        System.out.println("*****************************Sales Summary*****************************");
        System.out.println(String.format("%30s %20s", "ItemName", "Item Available"));
        System.out.println("***********************************************************************");
        itemList.forEach(obj -> {
            System.out.println(String.format("%30s %20d", obj.getItemDesc(), obj.getQuantity()));
        });
        System.out.println("***********************************************************************");
        System.out.println("Total Sales: $" + finalTotalSales);
        System.out.println("*****************************Sales Summary*****************************");
    }

}
