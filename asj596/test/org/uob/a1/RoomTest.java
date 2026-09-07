package org.uob.a1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

public class RoomTest {
   
    @Test
    public void testConstructor() {
        Position position = new Position(2,2);
        Room room = new Room("Room","a room",'r',new Position(2,2));
        
        int mark = 0;
        mark += (room.getName().equals("Room")) ? 1 : 0;
        mark += (room.getDescription().equals("a room")) ? 1 : 0;
        mark += (room.getSymbol() == 'r') ? 1 : 0;
        mark += (room.getPosition().x == 2 && room.getPosition().y == 2) ? 1 : 0;
        
        System.out.println("AUTOMARK::Room.testConstructor: " + mark + "/4");
    }

    @Test
    public void testGetName() {
        Position position = new Position(2,2);
        Room room = new Room("Room","a room",'r',new Position(2,2));
        int mark = 0;
         mark += (room.getName().equals("Room")) ? 2 : 0;
        System.out.println("AUTOMARK::Room.testGetName: " + mark + "/2");
    }

    @Test
    public void testGetDescription() {
        Position position = new Position(2,2);
        Room room = new Room("Room","a room",'r',new Position(2,2));
        int mark = 0;
        mark += (room.getDescription().equals("a room")) ? 2 : 0;
        System.out.println("AUTOMARK::Room.testGetDescription: " + mark + "/2");
    }

    @Test
    public void testGetPosition() {
        Position position = new Position(2,2);
        Room room = new Room("Room","a room",'r',new Position(2,2));
        int mark = 0;
        mark += (room.getPosition().x == 2 && room.getPosition().y == 2) ? 2 : 0;
        System.out.println("AUTOMARK::Room.testGetPosition: " + mark + "/2");
    }
   

}