public class Help {
    private String name;
    private String description;

    public Help(String name, String description){
        this.name =name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }



    @Override
    public String toString() {
        return "," + description;
    }
}
