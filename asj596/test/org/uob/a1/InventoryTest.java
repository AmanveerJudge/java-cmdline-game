package org.uob.a1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

public class InventoryTest {
   
    
    @Test
    public void testConstructor() {
        Inventory inventory = new Inventory();
        int mark = 0;
        mark += ("".equals(inventory.displayInventory())) ? 3 : 0;
        System.out.println("AUTOMARK::Inventory.testConstructor: " + mark + "/3");
    }

    @Test
    public void testAddItem() {
        Inventory inventory = new Inventory();
        inventory.addItem("laser");
        int mark = 0;
        mark += (inventory.hasItem("laser") > -1) ? 3 : 0;
        System.out.println("AUTOMARK::Inventory.testAddItem: " + mark + "/3");
    }

    @Test
    public void testHasItem() {
        Inventory inventory = new Inventory();
        inventory.addItem("laser");
        int mark = 0;
        mark += (inventory.hasItem("laser") > -1) ? 3 : 0;
        System.out.println("AUTOMARK::Inventory.testHasItem: " + mark + "/3");
    }

    @Test
    public void testRemoveItem() {
        Inventory inventory = new Inventory();
        inventory.addItem("laser");
        inventory.addItem("grapple");
        inventory.removeItem("laser");
        int mark = 0;
        mark += (inventory.hasItem("laser") == -1) ? 3 : 0;
        System.out.println("AUTOMARK::Inventory.testRemoveItem: " + mark + "/3");
    }

    @Test
    public void testDisplayInventory() {
        Inventory inventory = new Inventory();
        inventory.addItem("laser");
        inventory.addItem("grapple");
        int mark = 0;
        mark += ("laser grapple ".equals(inventory.displayInventory())) ? 3 : 0;
        System.out.println("AUTOMARK::Inventory.testDisplayInventory: " + mark + "/3");
    }

   

}