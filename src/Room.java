import java.util.HashMap;
import java.util.Locale;
import java.util.HashMap;
import java.util.*;
public class Room
{
    // attributes
    private String roomID;
    private String roomName;
    private String roomDesc;

    private String[] exits;
    private HashMap<String, Item> itemH = new HashMap<String, Item>();
    private HashMap<String,Puzzle> puzzleH = new HashMap<String, Puzzle>();
    private HashMap<String, Monster> monsterH = new HashMap<String, Monster>();


    public Room(String roomID, String roomName, String[] exits,String roomDesc, HashMap<String,Item> items, HashMap<String,Monster> monsters, HashMap<String,Puzzle> puzzles)
    {
        this.roomID = roomID;
        this.roomName = roomName;
        this.exits = exits;
        this.roomDesc = roomDesc;
        setItem(items);
        setPuzzle(puzzles);
        setMonster(monsters);
    }

    public void setItem(HashMap<String, Item> items) {
        for(Map.Entry<String, Item> ilt : items.entrySet()) {
            if(ilt.getValue().getLocation().equals(roomName)) {
                itemH.put(ilt.getKey(), ilt.getValue());
            }
        }
    }

    public void setPuzzle(HashMap<String, Puzzle> puzzles) {
        for(Map.Entry<String, Puzzle> pzzl : puzzles.entrySet()) {
            if(pzzl.getValue().getLocation().equals(roomName)) {
                puzzleH.put(pzzl.getKey(), pzzl.getValue());
            }
        }
    }

    public void setMonster(HashMap<String, Monster> monsters) {
        for(Map.Entry<String, Monster> mons : monsters.entrySet()) {
            if(mons.getValue().getLocation().equals(roomName)) {
                monsterH.put(mons.getKey(), mons.getValue());
            }
        }
    }

    // explore method that's called when the player types in explore.
    public void look() {
        System.out.println(roomDesc);

        System.out.println("Can exit to the ");
        // traverse neighbors array
        if (!exits[0].equals("-")) { // if there is spot to north
            System.out.print("NORTH, ");
        }

        if (!exits[1].equals("-")) { // if there is spot to south
            System.out.print("EAST,");
        }

        if (!exits[2].equals("-")) { // if there is spot to east
            System.out.print("SOUTH,");
        }

        if (!exits[3].equals("-")) { // if there is spot to west
            System.out.print("WEST,");
        }

        System.out.println();
        System.out.println();

        if (itemH.isEmpty()) { // if collection of items in room is empty
            System.out.println("No items in room, sorry.");
        } else { // else, items in room, print them out
            for (Map.Entry<String, Item> ilt : itemH.entrySet()) { // iterate
                System.out.print(ilt.getKey() + ", ");
            }
            System.out.println(" are in the room.");
        }

        if(puzzleH.isEmpty()) {
            System.out.println("No puzzle in room sorry");
        }
        else {
            for(Map.Entry<String, Puzzle> pzzl : puzzleH.entrySet()) {
                System.out.print(pzzl.getKey() + ",");
            }
            System.out.println(" are in the room");
        }

        if(monsterH.isEmpty()) {
            System.out.println("No monster in room sorry");
        }
        else {
            for(Map.Entry<String, Monster> mons : monsterH.entrySet()) {
                System.out.print(mons.getKey() + ",");
            }
            System.out.println(" are in the room");
        }

    }

    // getters and setters
    public String getRoomID()
    {
        return roomID;
    }

    public void setRoomID(String roomID)
    {
        this.roomID = roomID;
    }

    public String getRoomName()
    {
        return roomName;
    }

    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public String getRoomDesc()
    {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc)
    {
        this.roomDesc = roomDesc;
    }


    /**
     *
     * public int getVisits()
     *     {
     *         return visits;
     *     }
     *
     *     public void setVisits(int visits)
     *     {
     *         this.visits = visits;
     *     }
     */

    public String[] getExits()
    {
        return exits;
    }

    public void setExits(String[] exits)
    {
        this.exits = exits;
    }

    public HashMap<String, Item> getInventory() {
        return itemH;
    }

    public HashMap<String, Puzzle> getDetail() {
        return puzzleH;
    }

    public HashMap<String, Monster> getDetail1(){
        return monsterH;
    }
}
