package org.uob.a1;

public class Inventory {
    // declaring inventory attributes
    final int MAX_ITEMS = 10;
    private String[] items;
    private int itemCount;

    public Inventory() {
        // initialising inventory attributes
        items = new String[MAX_ITEMS];
        itemCount = 0;
    }
    
    public void addItem(String item) {
        // Adding items to inventory if there is enough space
        if (itemCount < MAX_ITEMS) {
            items[itemCount] = item;
            itemCount++;
        } 
        else {
            System.out.println("Inventory is full."); // Not allowing items to be added if user inventory is full
        }
    }

    public int hasItem(String item){
        // Checking if a given item is in the inventory
        if (item == null) {
            return -1;
        }
        // Checking the inventory items array for the item
        for (int i = 0; i < itemCount; i++) {
            if (items[i] == (item)) {
                return i;
            }
        }
        return -1; // Returning -1 if the item is not found
    }

    public void removeItem(String item) {
        // Removing an item from the inventory if it exists in the inventory
        int index = hasItem(item);
        if (index != -1) { // Item found in inventory
            for (int i = index; i < itemCount - 1; i++) {
                items[i] = items[i + 1];
            } // Move items back to keep the items in a consistent order
            items[itemCount - 1] = null;
            itemCount--;
        } 
        else {
            System.out.println("Item not found in inventory.");
        }
    }

    public String displayInventory() {
        // Displaying the items in the inventory as a string
        StringBuilder inventoryString = new StringBuilder();
        for (int i = 0; i < itemCount; i++) {
            inventoryString.append(items[i]).append(" "); // Appending each item to the string with a space inbetween
        }
        return inventoryString.toString(); // Returning the final inventory string


    }
}
