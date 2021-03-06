import java.util.HashMap;
import java.util.Scanner;

public class GamePlay {
    public static void main(String[] args) {
        Player p1 = new Player();
        HashMap<String, Item> item = Read.createsItem();
        HashMap<String, Puzzle> puzzle = Read.createsPuzzle();
        HashMap<String, Monster> monster = Read.createsMonster();
        HashMap<String, Room> room = Read.createRoom(item, monster, puzzle);
        Scanner srn = new Scanner(System.in);
        System.out.println("Please use north, south, east, and west for direction!!");
        System.out.println("Type help if you need help!!");
        System.out.println("Type Start Game to Start Game");

        String input = srn.nextLine();
        if(input.equalsIgnoreCase("Start Game")) {
            System.out.println(room.get(Player.getLocation()).getRoomDesc());
            while(true) {
                System.out.println("------------------------------------------");
                String input2 = srn.nextLine();
                input2 = input2.toLowerCase();
                String[] command = input2.split(" ");
                if (command[0].equals("help")) {
                    p1.getHelp();

                }
                else if (command[0].equalsIgnoreCase("pickup")) {
                    if (command.length >= 2) {
                        String temp = "";
                        for (int i = 1; i < command.length; i++) {
                            temp = temp + command[i] + " ";
                        }
                        temp = temp.trim();

                        p1.pickup(temp, room);
                    } else { // else
                        System.out.println(command[1] + " not found/doesn't exist, please try again!");
                    }

                } else if (command[0].equalsIgnoreCase("drop")) {
                    if (command.length >= 2) {
                        String temp = "";
                        for (int i = 1; i < command.length; i++) {
                            temp = temp + command[i] + " ";
                        }
                        temp = temp.trim();
                        p1.drop(temp, room);
                    } else { // else
                        System.out.println(command[1] + "not found/doesn't exist, please try again!");
                    }
                } else if (command[0].equalsIgnoreCase("explore")) {
                    p1.look(room);
                } else if (command[0].equalsIgnoreCase("equip")) {
                    if (command.length >= 2) {
                        String temp = "";
                        // create string of object name
                        for (int i = 1; i < command.length; i++) {
                            temp = temp + command[i] + " ";
                        }
                        temp = temp.trim();
                        p1.equip(temp);
                    } else {
                        System.out.println(command[1] + " not found/doesn's exist, please try again!");
                    }

                } else if (command[0].equalsIgnoreCase("unequip")) {
                    if (command.length >= 2) {
                        String temp = "";
                        // create string of object name
                        for (int i = 1; i < command.length; i++) {
                            temp = temp + command[i] + " ";
                        }
                        temp = temp.trim();
                        p1.unequip(temp);
                    } else {
                        System.out.println(command[1] + " not found/doesn's exist, please try again!");
                    }

                } else if (command[0].equalsIgnoreCase("view")) {
                    if (command.length >= 2) {
                        String temp = "";
                        for (int i = 1; i < command.length; i++) {
                            temp = temp + command[i] + " ";
                        }
                        temp = temp.trim();
                        p1.observe(temp, room);
                    } else if (command.length == 1) {
                        p1.view(room);
                    } else {
                        System.out.println(command[1] + " not found/doesn's exist, please try again!");
                    }
                } else if (command[0].equalsIgnoreCase("attack")) {
                    if (command.length >= 2) {
                        String timp = "";
                        for (int i = 1; i < command.length; i++) {
                            timp = timp + command[i] + " ";
                        }
                        timp = timp.trim();
                        p1.attack(timp, room);
                    } else {
                        System.out.print(command[1] + "not found/doesn't exist, please try again!");
                    }
                } else if (command[0].equalsIgnoreCase("look")) { // if player wants to look
                    // if player wants to look at object
                    if (command.length >= 2) {
                        String temp = "";
                        // create string of object name
                        for (int i = 1; i < command.length; i++) {
                            temp = temp + command[i] + " ";
                        }
                        temp = temp.trim();
                        p1.look(temp);

                    } else { // else
                        System.out.println(command[1] + "not found/doesn't exist, please try again!");
                    }

                } else if (command[0].equalsIgnoreCase("check")) {
                    if (command.length >= 2) {
                        p1.checkHealth();
                    }
                } else if (command[0].equalsIgnoreCase("solve")) {
                    if (command.length >= 2) {
                        String timp = "";
                        for (int i = 1; i < command.length; i++) {
                            timp = timp + command[i] + " ";
                        }
                        timp = timp.trim();
                        p1.solve(timp, room);
                    } else {
                        System.out.print(command[1] + "not found/doesn't exist, please try again!");
                    }
                } else if (command[0].equalsIgnoreCase("consume")) {
                    if (command.length >= 2) {
                        String timp = "";
                        for (int i = 1; i < command.length; i++) {
                            timp = timp + command[i] + " ";
                        }
                        timp = timp.trim();
                        p1.health(timp);
                    } else {
                        System.out.print(command[1] + "not found/doesn't exist, please try again!");
                    }

                }
                else if (command[0].equals("north") || command[0].equals("east") || command[0].equals("south")
                        || command[0].equals("west")) { // wants to move, only by
                    // giving direction
                    p1.move(command[0], room);
                    System.out.println(room.get(p1.getLocation()).getRoomName());
                    System.out.println(room.get(p1.getLocation()).getRoomDesc());
                } else if (command.length == 1) { // else
                    if (command[0].equalsIgnoreCase("inventory")) { // if want to check
                        // inventory
                        p1.getInventory();
                    } else if (command[0].equalsIgnoreCase("Exit")) { // if want to quit
                        System.out.println("Thank you for playing!");
                        System.exit(0);
                    }
                } else { // else no such command
                    System.out.println("No such command, please try again");
                }


            }
        }
        else if(input.equalsIgnoreCase("End Game")){
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
        else {
            System.out.println("Type in Start Game to play!!");
        }
    }
}
