import java.util.HashMap;
import java.util.Locale;

public class Room
{
    // attributes
    private String roomID;
    private String roomName;
    private String roomDesc;
    private String difficulty;
    private String artifactID;
    private String monsterID;
    private String puzzleID;
    private int visits;

    //array string for exits of rooms
    private String[] exits;
    // hashmap

    private HashMap<String, Item> item_ = new HashMap<String, Item>();
    private HashMap<String,Puzzle> puzzle_ = new HashMap<String, Puzzle>();

    // no argument constructor
    public Room()
    {
        roomID = "R0";
        roomName = "Nothingness";
        roomDesc = "it's so cold and empty. Like this shouldn't exist in the first place.";
        difficulty = "";
        artifactID = "AR0";
        monsterID = "M0";
        puzzleID = "P0";
        visits = 0;
    }

    // constructor with arguments
    public Room(String roomID, String roomName, String roomDesc, String difficulty, String[] exits, String artifactID, String monsterID, String puzzleID, int visits)
    {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomDesc = roomDesc;
        this.difficulty = difficulty;
        this.exits = exits;
        this.artifactID = artifactID;
        this.monsterID = monsterID;
        this.puzzleID = puzzleID;
        this.visits = visits;
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

    public String getArtifactID()
    {
        return artifactID;
    }

    public void setArtifactID(String artifactID)
    {
        this.artifactID = artifactID;
    }

    public String getMonsterID()
    {
        return monsterID;
    }

    public void setMonsterID(String monsterID)
    {
        this.monsterID = monsterID;
    }

    public String getPuzzleID()
    {
        return puzzleID;
    }

    public void setPuzzleID(String puzzleID)
    {
        this.puzzleID = puzzleID;
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
        return item_;
    }

    public HashMap<String, Puzzle> getDetail() {
        return puzzle_;
    }
}
