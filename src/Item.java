public class Item {
    private String id;
    private String name;
    private String description;
    private String output;

    public Item(String id, String name, String description, String output){
     this.id = id;
     this.name = name;
     this.description = description;
     this.output = output;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOutput(){

        return output;
    }

}
