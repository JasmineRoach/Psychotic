import java.util.*;
public class Player {
    //private static String help;

    //HashMap<String, Help> help1 = Read.help();
    private static HashMap<String, Help> help1= new HashMap<String, Help>();

    public Player(){

    }

    public void pickup(){

    }

    public void drop(){

    }

    public void equip(){

    }

    public void unequip(){

    }

    public void getInventory(){

    }

    public void getHelp(String help){
     System.out.println(help1.get(help).getName() + "=" + help1.get(help).getDescription());

     }



}
