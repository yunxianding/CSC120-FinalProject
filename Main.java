import java.util.Scanner;

/**
 * The Main class is where we implement all the classes and run the game
 */
public class Main {
    public static void main(String[] args) {

        //Create all the items needed
        Item bed = new Item("bed", "This is a bed.", false, false, false);
        Item teddyBear = new Item("teddyBear", "This teddy bear feels soft.", true, true, false);
        Item firstSoul = new Item("firstSoul", "This is the first piece of my soul.", true, false, false);
        Item box = new Item("box", "This is a box. Seems like there is something inside.", false, true, false);
        Item leg = new Item("leg", "This looks like my leg. I'd better put it on to walk.", true, false, true);
        Item irisPot = new Item("irisPot", "There is a label on the plantpot saying 'iris pot'. Seems like there is something inside.", false, true, false);
        Item eye = new Item("eye", "This looks like my eye. I'd better put it on for better vision.", true, false, true);
        Item secondSoul = new Item("secondSoul","This is the second piece of my soul.", true, false, false);


        //Create the Bedroom
        Room bedroom = new Room("Bedroom", "This is a bedroom. I can see a bed, a teddy bear, a box and a plant pot.", false, false);
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
        Room lab = new Room("Lab", "This is a lab. I can see a computer.", true,true);
        lab.addItem(secondSoul); 
        Computer computer = new Computer();
        lab.addItem(computer);
        computer.storeItem(secondSoul);

        // Create the player's existence
        Robot player = new Robot("Teddy", bedroom, true, false, false, false);

        // Messages:
        String basicInstructions = "\nType the command with any item to execute that command on that item. \nE.g: open door";
        String cheatSheet1 = "\n- \"use\" to use something.\n" + //
                        "- \"take\" to take something, and add it to your inventory.\n" + //
                        "- \"touch\" to touch an item and see its description.\n" + //
                        "- \"inventory\" to see your inventory. \n" + //
                        "- \"look\" to look around.\n" + //
                        "- \"inspect\" to inspect something.\n" + //
                        "- \"crawl\" to crawl somewhere.\n" + //
                        "- \"walk\" to walk somewhere.";
        String cheatSheeet2 = "\n- \"unlock\" to unlock something.\n" + //
                        "- \"click\" to click a folder.\n" + //
                        "- \"open\" to open something.\n" + //
                        "- \"toggle to toggle buttons on computer.\n" + //
                        "- \"trade\" to trade bodies with another existence.\n" + //
                        "- \"destroy *entity*\" - to attempt to destruct another existence\n" + //
                        "- \"electrocute\" to electrocute another existence\n" + //
                        "- \"fight *hentity* *n* times\" to fight another existence *n* number of times.";

        System.out.println("You wake up in a bedroom, discovering that you only have a broken mechanical body, missing one leg and an eye.");
        System.out.println("Input anything. \nPress h for help");

        Scanner scanner = new Scanner(System.in);
    
        String command = scanner.nextLine();
        if(player.getCanGoToLab() == false) {
            if (command.toLowerCase().equals("h")) {
                System.out.println(basicInstructions);
                System.out.println(cheatSheet1);
            } else {
                System.out.println("Command not understood.");
            } 
        } 
        else if (player.getCanGoToLab() == true) {
            System.out.println(basicInstructions);
            System.out.println(cheatSheeet2);
        }
        scanner.close();
    }
}
