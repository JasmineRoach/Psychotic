//Kingston

public class Monster {

    private String monsterID;
    private String monsterName;
    private String monsterDescription;
    private int monsterHP;
    private String monsterStatus;
    private String location;


    public Monster(String monsterID, String monsterName, String monsterDescription, int monsterHP, String monsterStatus, String location)
    {
        this.monsterID = monsterID;
        this.monsterName = monsterName;
        this.monsterDescription = monsterDescription;
        this.monsterHP = monsterHP;
        this.monsterStatus = monsterStatus;
        this.location = location;

}



public String getMonsterIDID(){
    return monsterID;
}

public String getmonsterName(){
    return monsterName;
}

public String getmonsterDescription() {
    return monsterDescription;
}

public int getmonsterHP() {
    return monsterHP;
}

public String getMonsterStatus(){
    return monsterStatus;

}

    public String getLocation() {
        return location;
    }
}
