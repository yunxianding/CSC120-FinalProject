import java.util.Scanner;

/**
 * The Main class is where we implement all the classes and run the game
 */
public class Main {
    public static void main(String[] args) {
        // Create the player's existence
        Robot player = new Robot("Teddy", 100, true);

        //Create all the items needed
        Item bed = new Item("bed", "This is a bed.", false);
        Item teddyBear = new Item("teddyBear", "This looks like a toy. It feels soft.", true);
        Item firstSoul = new Item("firstSoul", "This is the first piece of my soul.", true);
        Item box = new Item("box", "This is a box. Seems like there is something inside.", false);
        Item leg = new Item("leg", "This looks like my leg. I'd better put it on to walk.", true);
        Item irisPot = new Item("irisPot", "This is a plantpot. Seems like there is something inside.", false);
        Item eye = new Item("eye", "This looks like my eye. I'd better put it on for better vision.", true);
        Item secondSoul = new Item("secondSoul","This is the second piece of my soul.", true);


        //Create the Bedroom
        Room bedroom = new Room("Bedroom", "This is a bedroom.", false);
        bedroom.addItem(bed);
        bedroom.addItem(teddyBear);
        bedroom.addItem(firstSoul);
        teddyBear.storeItem(firstSoul);
        bedroom.addItem(box);
        bedroom.addItem(leg);
        box.storeItem(leg);
        bedroom.addItem(irisPot);
        bedroom.addItem(eye);
        irisPot.storeItem(eye);

        //Create the Lab
        Room lab = new Room("Lab", "This is a lab.", true);
        lab.addItem(secondSoul); 
        Computer computer = new Computer();
        lab.addItem(computer);
        computer.storeItem(secondSoul);

        // Messages:
        String cheatSheet1 = "- \"use\" to use something.\n" + //
                        "- \"take\" to take something.\n" + //
                        "- \"inventory\" to see your inventory. \n" + //
                        "- \"look\" to look around.\n" + //
                        "- \"inspect\" to inspect something.\n" + //
                        "- \"crawl\" to crawl somewhere.\n" + //
                        "- \"walk\" to walk somewhere.";

        System.out.println("You wake up in a bedroom, discovering that you only have a broken mechanical body, missing one leg and an eye.");
        System.out.println("Input anything. \nPress h for help");

        Scanner scanner = new Scanner(System.in);
    
        String command = scanner.nextLine();
        if(player.getCanGoToLab() == false) {
            if (command.toLowerCase().equals("h")) {
                System.out.println(cheatSheet1);
            } else {
                System.out.println("Command not understood.");
            } 
        } 
        else if (player.getCanGoToLab() == true) {
            
        }
        scanner.close();
    }
}
