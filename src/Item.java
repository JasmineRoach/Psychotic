public class Item {
    private String id;
    private String name;
    private String location;
    private int hpPoint;
    private String type;
    private String description;
    private String output;

    public Item(String id, String name, String location, int hpPoint, String type,String description, String output){
     this.id = id;
     this.name = name;
     this.location = location;
     this.hpPoint = hpPoint;
     this.type = type;
     this.description = description;
     this.output = output;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getHpPoint() {
        return hpPoint;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getOutput(){

        return output;
    }

}
