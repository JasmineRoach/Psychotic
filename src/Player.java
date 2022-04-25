import java.util.*;
public class Player {
    //private static String help;
    private static String location;
    private static double health;
    HashMap<String, Help> help1 = Read.help();
    private static Map<String, Item> inventory = new HashMap<String, Item>();
    //private static HashMap<String, Help> help1= new HashMap<String, Help>();
    //Allows player to observe the monster and get the current status -Kingston
    private static String observe;
    private static String attack;
    public static HashMap<String, Monster> createsMonster;


    public Player(){
        location = "Alpha & Omega";
        health = 5.0;

    }

    public void move(String dir, HashMap<String, Room> room)
    {
        dir = dir.toLowerCase();
        String spot = Player.getLocation();
        Room current = room.get(spot);
        String[] tempRoom = current.getExits();

        if(dir.equalsIgnoreCase("North") || dir.equalsIgnoreCase("N"))
        {
            if(!tempRoom[0].equals("@"))
            {
                spot = tempRoom[0];
            }
            else
            {
                System.out.println("There is no exit in this direction. Try another one.");
            }
        }
        else if(dir.equalsIgnoreCase("East") || dir.equalsIgnoreCase("E"))
        {
            if(!tempRoom[1].equals("@"))
            {
                spot = tempRoom[1];
            }
            else
            {
                System.out.println("There is no exit in this direction. Try another one.");
            }
        }
        else if(dir.equalsIgnoreCase("West") || dir.equalsIgnoreCase("W"))
        {
            if(!tempRoom[2].equals("@"))
            {
                spot = tempRoom[2];
            }
            else
            {
                System.out.println("There is no exit in this direction. Try another one.");
            }
        }
        else if(dir.equalsIgnoreCase("South") || dir.equalsIgnoreCase("S"))
        {
            if(!tempRoom[3].equals("@"))
            {
                spot = tempRoom[3];
            }
            else
            {
                System.out.println("There is no exit in this direction. Try another one.");
            }
        }
        else
        {
            System.out.println("There is no exit in this direction. Try another one.");
        }
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

    public void equip(String item){
        Item timp = null;
        double health2;
        if(inventory.containsKey(item)) {
            timp = inventory.get(item);
            inventory.remove(item);
            health2 = timp.getHpPoint();
            double health3 = health + health2;
            health = health3;
            System.out.println(item + " was successfully equip and hp was added to health " + health);

        }
        else {
            System.out.println("Sorry no" + item +"to equip");
        }


    }

    public void unequip(String item) {
        Item timp = null;

        if(!inventory.containsKey(item)) {
            System.out.println(item + " was successfully unequip ");
            inventory.put(item, timp);
        }
        else {
            System.out.println("Sorry no " + item + " to unequip");
        }

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
                if (puz.equalsIgnoreCase(temp.getSolution())) {
                    current.getDetail().remove(puzzle);
                    current.getInventory().containsKey(item_);
                    item = current.getInventory().get(item_);
                    current.getInventory().remove(item_);

                    inventory.put(item.getName(), item);

                    System.out.println("You have answered this " + temp.getName() + " correctly" + " " + item.getOutput());

                    break;
                }
                else if(sc.equals("hint")) {
                    System.out.println(temp.getHint());
                }
                else if(sc.equals("skip")) {
                    System.out.println("You decided to skip this puzzle.");
                   break;
                }
                else {
                    int attemptsLeft = temp.getNumAttempts() - i;
                    System.out.println("That is incorrect. You have " + attemptsLeft + " attempts left");
                    if(attemptsLeft == 0){
                        double playerHealth = .25 * Player.health;
                        inventory.clear();
                        System.out.println("You have " + playerHealth + "health points left");

                    }
                    }
                }
            }
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
        double health4;
        if(inventory.containsKey(item)) {
            temp = inventory.get(item);
            health4 = temp.getHpPoint();
            double tot = health4 + health;
            health = tot;
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




    //Allows user to view the name and status of the monster -Kingston
    public void observe(String monsterStatus){
        System.out.println("monsterName" + "monsterStatus");
        }

//Allows player to attack monster-Kingston
        public void  attack(String monster, HashMap<String, Room> room) {
            Room current = room.get(location);
            Monster monster1 = null;
            Scanner response = new Scanner(System.in);
            if(current.getDetail().containsKey(monster)) {
                monster1 = current.getDetail().get(monster);
                System.out.println(monster1.getmonsterDescription());
                System.out.println("Would you like to attack or ignore?");
                String input = response.nextLine();
                if(input.equalsIgnoreCase("Ignore")) {
                    current.getDetail().remove(monster);
                    System.out.println("Continue through the mansion");
                }
                else if(input.equalsIgnoreCase("Attack")) {
                    Random hold1 = new Random();
                    int hold2 = hold1.nextInt(7);
                    System.out.println(hold2);
                    if(hold2 < monster.getHold()) {
                        int tot = monster.getmonsterHP() + monster.getmonsterHP();
                        double tot1 = health - tot;
                        health = tot1;
                        System.out.println(health);
                    }
                    else if(hold2 >= monster.getHold()) {
                        int tot2 = health - monster.getmonsterHP();
                        health = tot2;
                        System.out.println(health);
                    }
                    if(health < 0) {
                        System.out.println("You have died. Do you want to quit or start new game");
                        String input1 = response.nextLine();
                        if(input1.equalsIgnoreCase("Quit")) {
                            System.out.println("Goodbye!!");
                            System.exit(0);
                        }
       //                 else if(input1.equalsIgnoreCase("Start New Game")) {
      //                      Player p1 = new Player();
       //                     System.out.println( p1.getLocation()+ " \n " +current.getDescription() );
        //                }
        //            }
         //         else {
           //             System.out.println("Continue the game");
           //             current.getDetail().remove(monster);
         //           }
          //      }
          //      else {
          //          System.out.println("No such command");
          //      }

        //    }
        //    else {
      //          System.out.println("No monster here");
     //       }
   //     }

        }







}
}



