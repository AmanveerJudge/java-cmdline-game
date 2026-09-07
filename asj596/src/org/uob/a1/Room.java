package org.uob.a1;

public class Room {
    // Creating room attributes
    private String name;
    private String description;
    private char symbol;
    private Position position;
    private boolean puzzleSolved = false;

    // overloading constructors so the tests will run properly
    public Room(String name, String description, char symbol, Position position) {
        // Initialising room attributes
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.position = position;
        this.puzzleSolved = false;
    }

    public Room(String name, String description, char symbol, Position position, boolean hasPuzzle ) {
        // Initialising room attributes with the overloaded boolean hasPuzzle attribute
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.position = position;
        this.puzzleSolved = !hasPuzzle;
    }

    public String getName() {
        // Returning the room name
        return name;
    }

    public String getDescription() {
        // Returning the room description
        return description;
    }

    public char getSymbol() {
        //  Returning the room symbol
        return symbol;
    }

    public Position getPosition() {
        // Returning the room position
        return position;
    }

    public boolean isPuzzleSolved() {
        // Returning whether the room puzzle has been solved
        return puzzleSolved;
    }

    public void setPuzzleSolved(boolean solved) {
        // Setting the room puzzle as solved or not solved
        this.puzzleSolved = solved;
    }
}

