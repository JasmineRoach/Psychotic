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

    public void pickup(String item, HashMap<String, Room> room) {
        // check whether object is in room you are in
        Room current = room.get(location);

        Item temp = null;

        if (current.getInventory().containsKey(item)) { // item is in room
            temp = current.getInventory().get(item);

            current.getInventory().remove(item);
            inventory.put(temp.getName(), temp);
            System.out.println(item + " " + temp.getOutput());
        } else { //else
            System.out.println("Sorry, " + item + " is not in the room.");
        }
    }

    public void drop(){

    }

    public void equip(){

    }

    public void unequip(){

    }

    public void getInventory() {
        if (inventory.isEmpty()) { //if inventory is empty
            System.out.println("Inventory is empty");
        }
        else if(inventory.size() > 5) {
            System.out.print("To many item");
        }
        else { //else
            for (Map.Entry<String, Item> ilt : inventory.entrySet()) {
                System.out.println(ilt.getKey());
            }
        }
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

    public void look(String item) {
        System.out.println(inventory.get(item).getDescription());

    }



}
