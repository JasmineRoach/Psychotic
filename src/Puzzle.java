
/**
 * Class:Puzzle
 *
 * This class describes the attributes and
 * methods of the Puzzles in the game
 */
public class Puzzle {
    private String id;
    private String name;
    private String description;
    private String solution;

    public Puzzle(String id, String name, String description, String solution)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.solution = solution;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return this.description;
    }

    public String getSolution()
    {
        return solution;
    }

}
