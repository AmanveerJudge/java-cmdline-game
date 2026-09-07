package org.uob.a1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

public class PositionTest {
   
    
    @Test
    public void testConstructor() {
        Position position = new Position(1,3);
        int mark = 0;
        mark += (position.x == 1) ? 2 : 0;
        mark += (position.y == 3) ? 2 : 0;
        System.out.println("AUTOMARK::Position.testConstructor: " + mark + "/4");
    }

    @Test
    public void testX() {
        Position position = new Position(1,3);
        double mark = 0;
        mark += (position.x == 1) ? 0.5 : 0;
        System.out.println("AUTOMARK::Position.testX: " + mark + "/0.5");
    }

    @Test
    public void testY() {
        Position position = new Position(4,2);
        double mark = 0;
        mark += (position.y == 2) ? 0.5 : 0;
        System.out.println("AUTOMARK::Position.testY: " + mark + "/0.5");
    }


   

}