
/**
 * Class:Puzzle
 *
 * This class describes the attributes and
 * methods of the Puzzles in the game
 */
public class Puzzle {
    private String id;
    private String name;
    private String location;
    private String description;
    private String difficulty;
    private int numAttempts;
    private String hint;
    private String solution;
    private String reward;


    public Puzzle(String id, String name, String location,String description, String difficulty, int numAttempts, String hint, String solution, String reward)
    {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.difficulty = difficulty;
        this.numAttempts = numAttempts;
        this.hint = hint;
        this.solution = solution;
        this.reward = reward;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getLocation() { return location; }

    public String getDescription()
    {
        return this.description;
    }

    public String getDifficulty()
    {
        return this.difficulty;
    }

    public int getNumAttempts() {return this.numAttempts;}

    public String getHint()
    {
        return this.hint;
    }

    public String getSolution()
    {
        return this.solution;
    }

    public String getReward()
    {
        return this.reward;
    }



}
