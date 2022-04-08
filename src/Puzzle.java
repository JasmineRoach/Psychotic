import java.util.ArrayList;

/**
 * Class:Puzzle
 *
 * This class describes the attributes and
 * methods of the Puzzles in the game
 */
public class Puzzle {
    private String puzzleID;
    private String puzzleType;
    private String puzzleDescription;
    private String puzzleSolution;
    private static ArrayList<Puzzle> puzzleList = new ArrayList<>();

    public Puzzle(String puzzleID, String puzzleType, String puzzleDescription, String puzzleSolution)
    {
        this.puzzleID = puzzleID;
        this.puzzleType = puzzleType;
        this.puzzleDescription = puzzleDescription;
        this.puzzleSolution = puzzleSolution;
    }

    public String getPuzzleID()
    {
        return this.puzzleID;
    }

    public void setPuzzleID(String puzzleID)
    {
        this.puzzleID = puzzleID;
    }

    public String getPuzzleType()
    {
        return this.puzzleType;
    }

    public void setPuzzleType(String puzzleType)
    {
        this.puzzleType = puzzleType;
    }

    public String getPuzzleDescription()
    {
        return this.puzzleDescription;
    }

    public void setPuzzleDescription(String puzzleDescription)
    {
        this.puzzleDescription = puzzleDescription;
    }

    public String getPuzzleSolution()
    {
        return this.puzzleSolution;
    }

    public void setPuzzleSolution()
    {
        this.puzzleSolution = puzzleSolution;
    }

    public static ArrayList<Puzzle>getPuzzleList()
    {
        return puzzleList;
    }

    public String toString()
    {
        return "\nPuzzle ID = " + puzzleID + "\nPuzzle Type = " + puzzleType + "\nPuzzle Description = " + puzzleDescription + "\nPuzzle Solution = " + puzzleSolution;
    }
}
