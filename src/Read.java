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
                String description = "";
                description = description + line;
                line = reader.readLine();
                String output = "";
                while(!line.equals("END")){
                    output = output + line ;
                    line = reader.readLine();
                }
                item.put(name, new Item(id, name, description, output));
                line = reader.readLine();

            }
            return item;
        }
        catch (IOException e) {
            System.out.println("File could not be accessed, please try again!");
        }
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

}
