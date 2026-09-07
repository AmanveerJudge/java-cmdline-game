package org.uob.a1;

public class Map {
    // Creating map attributes
    private char[][] grid;
    private int width;
    private int height;
    final private char EMPTY = '.';

    public Map(int width, int height){
        // Initialising map attributes
        this.width = width;
        this.height = height;
        grid = new char[height][width];

        // Filling the grid with empty symbols, i represents rows and j represents columns so that it starts at the top left.
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                grid[i][j] = EMPTY;
            }
        }

    }

    public void placeRoom(Position position, char symbol){
        if (position.y >= 0 && position.y < height && position.x >= 0 && position.x < width) { // Ensuring that the room position is on the map grid.
            grid[position.y][position.x] = symbol;
        }
    }

    public String display(){
        // Creating a string that represents the map as a 2D grid
        StringBuilder mapString = new StringBuilder();
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                mapString.append(grid[i][j]); // Appending each symbol in the grid to the string
            }
            mapString.append('\n'); // New line after each row.
        }
        return mapString.toString();
    }

    public void placePlayer(Position position){
        if (position.y >= 0 && position.y < height && position.x >= 0 && position.x < width) { // Ensuring that the player position is on the map grid.
            grid[position.y][position.x] = '@'; // Using '@' symbol to represent the player on the map
        }
    }

}