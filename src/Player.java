import java.util.*;
public class Player {
    //private static String help;
    private static String location;
    private static int health;
    HashMap<String, Help> help1 = Read.help();
    private static Map<String, Item> inventory = new HashMap<String, Item>();
    //private static HashMap<String, Help> help1= new HashMap<String, Help>();

    public Player(){
        location = "Alpha & Omega";
        health = 20;

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

    public void drop(String item, HashMap<String, Room> room) {
        Item temp = null;

        if (inventory.containsKey(item)) { //if item is in inventory
            temp = inventory.get(item);
            inventory.remove(item);

            Room current = room.get(location);

            current.getInventory().put(temp.getName(), temp);
            System.out.println(item + " was successfully dropped");
        }

        else { // else
            System.out.println("Sorry, " + item + " is not in your inventory.");
        }
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
            System.out.print("To many item drop some items");
        }
        else { //else
            for (Map.Entry<String, Item> ilt : inventory.entrySet()) {
                System.out.println(ilt.getKey());
            }
        }
    }

    public void solve(String puzzle, HashMap<String, Room> room) {
        Room current = room.get(location);

        Puzzle temp = null;

        Item item = null;

        Scanner sc = new Scanner(System.in);
        if(current.getDetail().containsKey(puzzle)) {
            temp = current.getDetail().get(puzzle);
            String item_ = temp.getReward();
            System.out.println(temp.getDescription());
            System.out.println(item_);
            for(int i = 1; i <= temp.getNumAttempts(); i++) {
                String puz = sc.nextLine();
                if(puz == temp.getSolution()) {
                    current.getDetail().remove(puzzle);
                    current.getInventory().containsKey(item_);
                    item = current.getInventory().get(item_);
                    current.getInventory().remove(item_);

                    inventory.put(item.getName(), item);

                    System.out.println("You have answered this " + temp.getName() + " correctly" + " " + item.getOutput());

                    break;
                }
                else {
                    int attemptsLeft = temp.getNumAttempts() - i;
                    System.out.println("That is incorrect. You have " + attemptsLeft + " attempts left");
                    double playerHealth = .25 * Player.health;
                    System.out.println("You have " + playerHealth + "health points left");
                    for (int o=0; o < inventory.size(); o++)
                    {
                        inventory.remove(o);
                    }
                    }
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

    public void checkHealth() {
        System.out.println(health);
    }

    public void health(String item) {

        Item temp = null;
        int health4;
        if(inventory.containsKey(item)) {
            temp = inventory.get(item);
            //health4 = temp.getItPoint();
            //int tot = health4 + health;
            //health = tot;
            inventory.remove(item);
            System.out.println("Your health has increase from " + item + " by " );
        }
        else {
            System.out.println("Can't use " + item + " for health");
        }

    }

    public static String getLocation()
    {
        return location;
    }

}
