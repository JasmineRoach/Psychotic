import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class  Read {
    public static HashMap<String, Item> createsItem() {
        try {
            @SuppressWarnings("resource")
            BufferedReader reader = new BufferedReader(new FileReader("Psychotic_Items.txt"));
            String line = reader.readLine();
            HashMap<String, Item> item = new HashMap<String, Item>();
            while (line != null) {
                String id = line;
                line = reader.readLine();
                String name = line;
                name = name.toLowerCase();
                line = reader.readLine();
                String location = line.trim();
                line = reader.readLine();
                int hpPoint = Integer.parseInt(line);
                line = reader.readLine();
                String description = "";
                description = description + line;
                line = reader.readLine();
                String output = "";
                while (!line.equals("END")) {
                    output = output + line;
                    line = reader.readLine();
                }
                item.put(name, new Item(id, name, location, hpPoint, description, output));
                line = reader.readLine();

            }
            return item;
        } catch (IOException e) {
            System.out.println("File could not be accessed, please try again!");
        }
        return null;
    }


    public static HashMap<String, Room> createRoom(HashMap<String, Item> itemH, HashMap<String, Monster> monsterH, HashMap<String, Puzzle> puzzleH)
    {
        try {
            @SuppressWarnings("resource")
            BufferedReader reader = new BufferedReader(new FileReader("Room.txt"));
            String line = reader.readLine();
            HashMap<String, Room> room = new HashMap<String, Room>();

            while (line != null) {// while we can still read from file
                String roomID = line;
                line = reader.readLine();
                String name = line;

                line = reader.readLine();

                String[] connections = line.split(",");
                for (int i = 0; i < connections.length; i++) { // travers
                    // neighbors
                    // trim each name
                    connections[i] = connections[i].trim();
                }

                line = reader.readLine();
                String description = "";

                while (!line.equals("FINISH")) { // while reader has not hit "END"
                    // add each line to overall string for description
                    description = description + line;
                    line = reader.readLine();
                }

                // put new room object and rooms name in HashMap
                room.put(name, new Room(roomID, name,connections,description ,itemH, monsterH, puzzleH));

                line = reader.readLine(); // move line to beginning of next
                // section of text
            }

            return room;
        }
        catch (IOException e) {
            System.out.println("File could not be accessed, try again!");
        }
        return null;

    }


    public static HashMap<String, Help> help() {
        try {
            @SuppressWarnings("resource")
            BufferedReader reader = new BufferedReader(new FileReader("Help.txt"));
            String line = reader.readLine();
            HashMap<String, Help> help = new HashMap<String, Help>();
            while (line != null) {
                String name = line;
                line = reader.readLine();
                String description = "";
                while (!line.equals("END")) {
                    description = description + line;
                    line = reader.readLine();
                }
                help.put(name, new Help(name, description));
                line = reader.readLine();

            }
            return help;
        } catch (IOException a) {
            System.out.println("File could not be accessed, please try again!");
        }
        return null;
    }

    public static HashMap<String, Puzzle> createsPuzzle() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Puzzle.txt"));
            String line = reader.readLine();
            HashMap<String, Puzzle> puzzle = new HashMap<String, Puzzle>();
            while (line != null) {
                String id = line;
                line = reader.readLine();
                String name = line;
                name = name.toLowerCase();
                line = reader.readLine();
                String location = line;
                line = reader.readLine();
                String description = "";
                description = description + line;
                line = reader.readLine();
                String difficulty = line;
                line = reader.readLine();
                int numAttempts = Integer.parseInt(line);
                line = reader.readLine();
                String hint = line;
                line = reader.readLine();
                String reward = line;
                line = reader.readLine();
                String solution = "";
                while (!line.equals("END")) {
                    solution = solution + line;
                    line = reader.readLine();
                }
                puzzle.put(name, new Puzzle(id, name, location,description, difficulty, numAttempts, hint, solution, reward));
                line = reader.readLine();
            }
            return puzzle;
        } catch (IOException e) {
            System.out.println("File could not be accessed, please try again!");
        }
        return null;
    }

    //Kingston Code
    public static HashMap<String, Monster> createsMonster() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Monster.txt"));
            String line = reader.readLine();
            HashMap<String, Monster> monster = new HashMap<String, Monster>();
            while (line != null) {
                String monsterID = line;
                line = reader.readLine();
                String monsterName = line;
                monsterName = monsterName.toLowerCase();
                line = reader.readLine();
                String location = line.trim();
                line = reader.readLine();
                String monsterDescription = line;
                line = reader.readLine();
                int monsterHP = Integer.parseInt(line);
                line = reader.readLine();
                String monsterStatus = line;
                line = reader.readLine();
                String solution = "";

                while (!line.equals("END")) {
                    solution = solution + line;
                    line = reader.readLine();

                }
                monster.put(monsterName, new Monster(monsterID, monsterName, monsterDescription, monsterHP, monsterStatus, location));
                line = reader.readLine();
            }
            return monster;
        } catch (IOException e) {
            System.out.println("Monster file is complete");


        }
        return null;
    }
}












