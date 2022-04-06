import org.w3c.dom.html.HTMLBRElement;

import java.util.HashMap;
import java.util.Scanner;

public class GamePlay {
    public static void main(String[] args){
        Player p1 = new Player();
        HashMap<String, Item> item = Read.createsItem();
        HashMap<String, Help> help = Read.help();
        Scanner srn = new Scanner(System.in);
        String input = srn.nextLine();
        while(input.equals("Start Game")){
            String input2 = srn.nextLine();
            input2 = input2.toLowerCase();
            String[] command = input2.split(" ");
            if(command[0].equals("help")){
                //String temp = "";
                //p1.getHelp(temp, help);
            }

        }
    }
}
