package org.uob.a1;

public class Score {
    // Creating private variables
    private double startingScore;
    private int roomsVisited;
    private int puzzlesSolved;
    private final int PUZZLE_VALUE = 10;

    public Score(int startingScore) {
        // Initialziing the users score
        this.startingScore = startingScore;
        this.roomsVisited = 0;
        this.puzzlesSolved = 0;
    }

    public void visitRoom() {
        // Incrementing the number of rooms visited when a room is visited
        roomsVisited++;
    }

    public void solvePuzzle() {
        // Incrementing the number of puzzles solved when a puzzle is solved
        puzzlesSolved++;
    }

    public double getScore() {
        // Calculating the users score
        return startingScore + (puzzlesSolved * PUZZLE_VALUE) - roomsVisited;
    }
     
}