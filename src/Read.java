import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Read {
    public static HashMap<String, Item> createsItem() {
        try {
            @SuppressWarnings("resource")
           BufferedReader reader = new BufferedReader(new FileReader("Psychotic_Items.txt"));
            String line = reader.readLine();
            HashMap<String, Item> item = new HashMap<String, Item>();
            while(line != null){
                String id= line;
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
                while(!line.equals("END")){
                    output = output + line ;
                    line = reader.readLine();
                }
                item.put(name, new Item(id, name, location, hpPoint, description, output));
                line = reader.readLine();

            }
            return item;
        }
        catch (IOException e) {
            System.out.println("File could not be accessed, please try again!");
        }
        return null;
    }

    public static HashMap<String, Room> createRoom()
    {
        //placeholder method will be the method that reads the room text file to create the rooms
        return null;
    }




    public static HashMap<String, Help> help(){
        try{
            @SuppressWarnings("resource")
            BufferedReader reader = new BufferedReader(new FileReader("Help.txt"));
            String line = reader.readLine();
            HashMap<String, Help> help = new HashMap<String, Help>();
            while(line != null){
                String name = line;
                line = reader.readLine();
                String description = "";
                while(!line.equals("END")){
                    description = description + line;
                    line = reader.readLine();
                }
                help.put(name, new Help(name, description));
                line = reader.readLine();

            }
            return help;
        }
        catch(IOException a){
            System.out.println("File could not be accessed, please try again!");
        }
        return null;
    }

    public static HashMap<String, Puzzle> createsPuzzle() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Puzzle.txt"));
            String line = reader.readLine();
            HashMap<String, Puzzle> puzzle = new HashMap<String, Puzzle>();
            while(line != null){
                String id= line;
                line = reader.readLine();
                String location = line;
                line = reader.readLine();
                String name = line;
                name = name.toLowerCase();
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
                while(!line.equals("END")){
                    solution = solution + line ;
                    line = reader.readLine();
                }
                puzzle.put(name, new Puzzle(id, location, name, description, difficulty, numAttempts, hint, solution, reward));
                line = reader.readLine();
            }
            return puzzle;
        }
        catch (IOException e) {
            System.out.println("File could not be accessed, please try again!");
        }
        return null;
    }

}
