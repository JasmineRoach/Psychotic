import java.util.HashMap;
import java.util.Locale;

public class Room
{
    // attributes
    private String roomID;
    private String roomName;
    private String roomDesc;
    private String difficulty;
    //private String artifactID;
    //private String monsterID;
    //private String puzzleID;
    private int visits;

    //array string for exits of rooms
    private String[] exits;

    // hashmap
    private HashMap<String, Item> itemH = new HashMap<String, Item>();
    private HashMap<String,Puzzle> puzzleH = new HashMap<String, Puzzle>();
    private HashMap<String, Monster> monsterH = new HashMap<String, Monster>();



    // constructor with arguments
    public Room(String roomID, String roomName, String roomDesc, String difficulty, String[] exits, int visits, HashMap<String, Item> itemH, HashMap<String, Puzzle> puzzleH, HashMap<String, Monster> monsterH)
    {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomDesc = roomDesc;
        this.difficulty = difficulty;
        this.exits = exits;
        this.visits = visits;
        this.itemH = itemH;
        this.puzzleH = puzzleH;
        this.monsterH = monsterH;


    }

    // explore method that's called when the player types in explore.
    public void explore()
    {
        String[] descArray = roomDesc.split("#");
        System.out.println(roomName);
        for (int d = 0;d < descArray.length;d++)
        {
            System.out.println(descArray[d]);
        }
        if (visits < 1)
        {
            System.out.println("This is the first time you've been in this room.");
        }
        else if (visits > 2 && visits < 10)
        {
            System.out.println("You've been in this room before.");
        }
        else if (visits > 11)
        {
            System.out.println("You have been in this room a lot. Are you lost?");
        }
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

    public String getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
    }

    public int getVisits()
    {
        return visits;
    }

    public void setVisits(int visits)
    {
        this.visits = visits;
    }

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
}
