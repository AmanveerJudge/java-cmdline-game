package org.uob.a1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

public class ScoreTest {
   
    
    @Test
    public void testConstructor() {
        Score score = new Score(100);
        int mark = 0;
        mark += (score.getScore() == 100) ? 2 : 0;
        System.out.println("AUTOMARK::Score.testConstructor: " + mark + "/2");
    }

    @Test
    public void testGetScore() {
        Score score = new Score(100);
        int mark = 0;
        mark += (score.getScore() == 100) ? 4 : 0;
        System.out.println("AUTOMARK::Score.testGetScore: " + mark + "/4");
    }

    @Test
    public void testVisitRoom() {   
        Score score = new Score(100);
        score.visitRoom();
        score.visitRoom();
        int mark = 0;
        mark += (score.getScore() == 98) ? 2 : 0;
        System.out.println("AUTOMARK::Score.testVisitRoom: " + mark + "/2");
    }

    @Test
    public void testSolvePuzzle() {   
        Score score = new Score(100);
        score.solvePuzzle();
        int mark = 0;
        mark += (score.getScore() == 110) ? 2 : 0;
        System.out.println("AUTOMARK::Score.testSolvePuzzle: " + mark + "/2");
    }

   

}