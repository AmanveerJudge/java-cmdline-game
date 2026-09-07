package org.uob.a1;

import java.util.Scanner;

public class Game {

    // Basic game attributes.
    private Map map;
    private Inventory inventory;
    private Score score;
    private Position playerPosition;
    private Room[][] rooms;
    private Scanner scanner;

    public Game() {
        // Creating basic game attributes
        map = new Map(5, 5);
        inventory = new Inventory();
        score = new Score(100);
        scanner = new Scanner(System.in);
        playerPosition = new Position(0, 0);
        setupRooms();
        placeRoomsOnMap();
        map.placePlayer(playerPosition); 
    }

    private void setupRooms() {
        // Creating the 2D array of rooms
        rooms = new Room[5][5];

        // Row 0
        rooms[0][0] = new Room("Cell", "Cramped cell with a loose screw. You notice a locked door.", 'C', new Position(0,0),true);
        rooms[0][1] = new Room("Hallway", "Cold corridor with a camera.", 'H', new Position(1,0),false);
        rooms[0][2] = new Room("Watch Room", "Shows patrols on screen.", 'W', new Position(2,0),false);

        // Row 1
        rooms[1][1] = new Room("Storage Room", "Dusty crates with a toolbox. You notice a crowbar", 'S', new Position(1,1),true);
        rooms[1][2] = new Room("Lab", "Keycard hangs on a peg.", 'L', new Position(2,1),true);
        rooms[1][3] = new Room("Garage", "Sealed shuttle behind glass.", 'G', new Position(3,1),false);
        rooms[1][4] = new Room("Exit Hatch", "Shuttle docking port. Solve all puzzles to access.", 'E', new Position(4,1),false);

        // Row 2
        rooms[2][2] = new Room("Utility Room", "Rusted metal grate covers ladder. You notice a flashlight.", 'U', new Position(2,2),true);
        rooms[2][3] = new Room("Power Room", "Generators hum.", 'P', new Position(3,2),false);
    }

    private void placeRoomsOnMap() {
        // Placing the created rooms onto the 2D array map object
        for (int y = 0; y < rooms.length; y++) {
            for (int x = 0; x < rooms[y].length; x++) {
                if (rooms[y][x] != null) {
                    map.placeRoom(rooms[y][x].getPosition(), rooms[y][x].getSymbol());
                }
            }
        }
    }

    private void look() {
        // Printing the current room's description
        Room room = rooms[playerPosition.y][playerPosition.x];
        System.out.println(room.getDescription());
    }

    private void showInventory() {
        // Printing the player's inventory
        System.out.println(inventory.displayInventory());
    }

    private void showScore() {
        // Printing the player's score
        System.out.println("SCORE: " + score.getScore());
    }

    private void showMap() {
        // Printing the map with the player's current position on it
        map.placePlayer(playerPosition);
        System.out.println(map.display());
    }

    private void move(String direction) {
        // Getting the room that the player is currently in
        Room currentRoom = rooms[playerPosition.y][playerPosition.x];
        
        // Making sure user solves puzzle before progressing
        if (!currentRoom.isPuzzleSolved()) {
            System.out.println("You must solve the puzzle here before leaving!");
            return;
        }
    
        // Declaring new position variables
        int newX = playerPosition.x;
        int newY = playerPosition.y;

        // Handling directional movement
        switch (direction) {
            case "north": newY--; break;
            case "south": newY++; break;
            case "east":  newX++; break;
            case "west":  newX--; break;
            default:
                System.out.println("Invalid direction."); // Making sure the player inputs a valid direction
                return;
        }
        // Making sure the player attempts a valid move.
        if (newX >= 0 && newX < 5 && newY >= 0 && newY < 5 && rooms[newY][newX] != null) {
            map.placeRoom(playerPosition, currentRoom.getSymbol()); // resetting old player position on map

            playerPosition.x = newX;
            playerPosition.y = newY;

            score.visitRoom();
            
            map.placePlayer(playerPosition); // moving player symbol on map

            Room newRoom = rooms[newY][newX];
            System.out.println("You enter the " + newRoom.getName() + ".");

            // Handling if the player beats the game and all other cases
            if (newRoom.getName().equals("Exit Hatch")) {
                if (allPuzzlesSolved()) {
                    System.out.println("All puzzles solved!");
                    System.out.println("You enter the prison escape shuttle. You are free! YOU WIN!");
                    System.exit(0);
                } else {
                    System.out.println("The hatch won't open until you complete all puzzles.");
                }
            }
            } else {
                System.out.println("You can't go that way.");}
            }

    private void help() {
        // Printing the list of valid commands
        System.out.println("Valid commands: move <direction>, look, inventory, score, map, take <item>, use <item>, help, quit");
    }

    private void take(String item) {
        // Allowing the user to take the items if they correctly attempting to 
        Room room = rooms[playerPosition.y][playerPosition.x];
        String roomName = room.getName().toLowerCase();

        if (roomName.equals("cell") && item.equals("screwdriver") || roomName.equals("storage room") && item.equals("crowbar") ||
            roomName.equals("lab") && item.equals("keycard") || roomName.equals("utility room") && item.equals("flashlight")) {
            
            inventory.addItem(item);
            System.out.println("You take the " + item + ".");
        } else {
            System.out.println("You don't see that here.");
        }
    }


    private void use(String item) {
        Room room = rooms[playerPosition.y][playerPosition.x];
        boolean used = false;

        // Making sure users can only use items in the correct rooms
        switch (item) {
            case "screwdriver":
                if (room.getName().equals("Cell")) { used = true; }
                break;
            case "crowbar":
                if (room.getName().equals("Storage Room")) { used = true; }
                break;
            case "keycard":
                if (room.getName().equals("Lab") || room.getName().equals("Control Room")) { used = true; }
                break;
            case "flashlight":
                if (room.getName().equals("Utility Room")) { used = true; }
                break;
        }

        if (used) {
            room.setPuzzleSolved(true);
            System.out.println("You use the " + item + ". Puzzle solved!");
        } else {
            System.out.println("You can't use that here."); /// Handling the case of attempting to use a wrong item
        }
    }

    private void processCommand(String input) {
        // Breaking down user commands into two words and then processing them
        String[] parts = input.trim().toLowerCase().split(" ");
        if (parts[0].equals("move") && parts.length > 1) move(parts[1]);
        else if (parts[0].equals("look")) look();
        else if (parts[0].equals("inventory")) showInventory();
        else if (parts[0].equals("score")) showScore();
        else if (parts[0].equals("map")) showMap();
        else if (parts[0].equals("help")) help();
        else if (parts[0].equals("take") && parts.length > 1) take(parts[1]);
        else if (parts[0].equals("use") && parts.length > 1) use(parts[1]);
        else if (parts[0].equals("quit")) {
            System.out.println("Game over");
            System.exit(0);
        }
        else System.out.println("Unknown command"); // Handling the case of an invalid command
    }

    public void start() {
        // Printing a welcome message
        System.out.println("Welcome to Prison Escape! You are currently in a locked cell.");
        System.out.println("Your goal is to solve all 4 puzzles and reach the exit.\n");
        

        // Main game loop
        while (true) {
            System.out.print(">> ");
            String command = scanner.nextLine().toLowerCase();
            processCommand(command);
        }
    }

    private boolean allPuzzlesSolved() {
        // Checking if all puzzles have been solved
        for (int y = 0; y < rooms.length; y++) {
            for (int x = 0; x < rooms[y].length; x++) {
                if (rooms[y][x] != null && !rooms[y][x].isPuzzleSolved()) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // Starting the game
        Game game = new Game();
        game.start();
    }
}
