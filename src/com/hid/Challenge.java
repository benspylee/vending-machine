package com.hid;

import com.hid.machine.SoftDrinkMachine;
import com.hid.vo.Item;

import java.util.Optional;
import java.util.Scanner;

public class Challenge {

    public static void main(String[] args) {

        boolean orderMore = true;
        SoftDrinkMachine machine = new SoftDrinkMachine();
        while (orderMore) {
            System.out.println("‘l’ -> Display list of drinks");
            System.out.println("‘q’ -> quit program");
            System.out.println("Choose an option");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();

            if (option.equals("l")) {
                machine.printListOfItems();
                Scanner drink = new Scanner(System.in);
                String drinkoption = drink.nextLine();
                int drinkcd = 0;
                try {
                    drinkcd = Integer.valueOf(drinkoption);
                    int finalDrinkcd = drinkcd;
                    Optional<Item> selectedItem = machine.getItemList().stream()
                            .filter(obj -> obj.getItemCd() == finalDrinkcd).findAny();
                    if (selectedItem.isPresent() && finalDrinkcd > 0 && selectedItem.get().getQuantity() > 0) {
                        machine.addItemToCart(selectedItem.get());
                        System.out.println("Drink Price: $" + selectedItem.get().getItemCost());
                    } else if (selectedItem.isPresent() && selectedItem.get().getQuantity() <= 0) {
                        System.out.println("selected drink already sold out");
                    } else {
                        System.out.println("select VALID drink code");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("select VALID drink code");
                }

            } else if (option.equals("q")) {
                machine.calculateSales();
                System.out.println("exiting...");
                orderMore = false;
            } else {
                System.out.println("choose correct option from the list..");
            }


        }

    }

}
