import java.util.*;
public class Player {
    //private static String help;
    private static String location;
    private static int health;
    HashMap<String, Help> help1 = Read.help();
    private static Map<String, Item> inventory = new HashMap<String, Item>();
    //private static HashMap<String, Help> help1= new HashMap<String, Help>();

    public Player(){

    }

    public void pickup(){

    }

    public void drop(){

    }

    public void equip(){

    }

    public void unequip(){

    }

    public void getInventory(){

    }

    public void getHint() {

    }

    public void getHelp(){
       for(String name : help1.keySet()){
           String key = name;
           String value = help1.get(name).toString();
           System.out.println(key + " " + value);
       }


     }



}
