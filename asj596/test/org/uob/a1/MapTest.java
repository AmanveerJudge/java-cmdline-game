package org.uob.a1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

public class MapTest {
   
    @Test
    public void testConstructor() {
        Map map = new Map(4,4);
        
        int mark = 0;
        mark += (map.display().equals("....\n....\n....\n....\n")) ? 2 : 0;
        
        System.out.println("AUTOMARK::Map.testConstructor: " + mark + "/2");
    }

    @Test
    public void testPlaceRoom() {
        Map map = new Map(4,4);
        map.placeRoom(new Position(0,0),'r');
        int mark = 0;
        mark += (map.display().equals("r...\n....\n....\n....\n")) ? 2 : 0;
        System.out.println("AUTOMARK::Map.testPlaceRoom: " + mark + "/2");
    }

    @Test
    public void testDisplay() {
        Map map = new Map(4,4);
        map.placeRoom(new Position(0,0),'r');
        map.placeRoom(new Position(3,1),'c');
        int mark = 0;
        mark += (map.display().equals("r...\n...c\n....\n....\n")) ? 3 : 0;
        System.out.println("AUTOMARK::Map.testDisplay: " + mark + "/3");
    }

    @Test
    public void testDisplayEmpty() {
        Map map = new Map(0,0);
        int mark = 0;
        mark += (map.display().equals("")) ? 3 : 0;
        System.out.println("AUTOMARK::Map.testDisplayEmpty: " + mark + "/3");
    }

   

}