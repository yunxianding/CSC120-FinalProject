import java.util.Scanner;

/**
 * The Main class is where we implement all the classes and run the game
 */
public class Main {
    public static void main(String[] args) {

        //Create all the items needed
        Item bed = new Item("bed", "This is a bed.", false, false, false);
        Item teddyBear = new Item("teddyBear", "This teddy bear feels soft.", true, false, false);
        Item box = new Item("box", "This is a box. There is a leg inside.", false, true, false);
        Item leg = new Item("leg", "This looks like my leg. I'd better put it on to walk.", true, false, true);
        Item irisPot = new Item("irisPot", "There is a label on the plantpot saying 'iris pot'. There is an inside.", false, true, false);
        Item eye = new Item("eye", "This looks like my eye. I'd better put it on for better vision.", true, false, true);


        //Create the Bedroom
        Room bedroom = new Room("Bedroom", "This is a bedroom. I can see a bed and a toy.", false, false);
        bedroom.addItem(bed);
        bedroom.addItem(teddyBear);
        bedroom.addItem(box);
        bedroom.addItem(leg);
        box.storeItem(leg);
        bedroom.addItem(irisPot);
        bedroom.addItem(eye);
        irisPot.storeItem(eye);

        //Create the Lab
        Room lab = new Room("Lab", "This is a lab. I can see a computer.", true,true);
        Computer computer = new Computer();
        lab.addItem(computer);

        // Create the player's existence
        Robot player = new Robot("Teddy", bedroom, true, false, false, false);

        // Messages:
        String welcomeMessage = 
                        "\n Welcome to ROBO Adventure! Get ready for your journey to discover hidden truths...";
        String basicInstructions = 
                        "\n Here is the basic instruction: Type the command with any item to execute that command on that item." +
                        "(E.g: 'open door')" +
                        "\n Type 'help' to see available commands at current stage, 'exit' to exit the game.";
        String enteringMessage = 
                        "\n Now get ready for the game..." +
                        "\n......LOADING......" +
                        "\n......Entering Game ROBO Adventure......" +
                        "\n*****************" +
                        "\n ROBO Adventure" +
                        "\n*****************";
        String stageOneMessage = 
                        "\n[STAGE 1]" +
                        "\n You wake up on a bed, having no idea who you are." +
                        "\n The only thing you know is that you possess a mechanical body" +
                        "with one leg and one eye missing." +
                        "\n 'Who am I? where am I? I should look around...'";
        String cheatSheet1 = 
                        "- \"take item\" to take something and add it to your inventory.\n" + 
                        "- \"touch item\" to touch an item and see its description.\n" + 
                        "- \"inventory\" to see your inventory. \n" + 
                        "- \"look around\" to look around.\n" + 
                        "- \"inspect item\" to inspect something.\n" + 
                        "- \"crawl to item\" to crawl to something.\n" + 
                        "- \"walk to item\" to walk to something." +
                        "- \"open item\" to open something.\n" + 
                        "- \"put on item\" to put on something.\n" + 
                        "- \"put down item\" to put down something.\n" + 
                        "- \"health\" to check your curent health status.\n";
        String cheatSheet2 = 
                        "- \"unlock item\" to unlock something.\n" + 
                        "- \"click folder\" to click a folder.\n" + 
                        "- \"toggle control\" to toggle control buttons.\n";
        String cheatSheet3 = 
                        "- \"trade\" to trade bodies with another existence.\n" + 
                        "- \"electrocute\" to electrocute another existence\n" + 
                        "- \"fight\" to fight another existence.\n";

        // Starting the game
        System.out.println(welcomeMessage + basicInstructions + enteringMessage + stageOneMessage);
        
        // Open a scanner
        Scanner scanner = new Scanner(System.in);
        
        // game loop
        while (true) {

            // Accept a string of player inputs and split them
            String input = scanner.nextLine();
            String[] words = input.split(" ");

            if (words.length > 0) {
                String command = words[0]; // The first word is the command
            
                // If the command is asking for help, print out cheatsheets based on stages
                if (command.equalsIgnoreCase("help")) {
                    if (player.stageOne ==  true) {
                        System.out.println(cheatSheet1);
                    } else if (player.stageTwo ==  true) {
                        System.out.println(cheatSheet1 + cheatSheet2);
                    } else if (player.stageThree ==  true) {
                        System.out.println(cheatSheet1 + cheatSheet2 + cheatSheet3);
                    } 
                }

                // If the command is exit, we break out of the loop
                if (command.equalsIgnoreCase("exit")) {
                    System.out.println("Goodbye! We hope you enjoyed the game!");
                    break;
                }

                // If the command is take, look for the next word to see what item to pick
                else if (command.equalsIgnoreCase("take")) {
                    if (words.length == 2) {
                        String itemName = words[1]; // The second word is the item's name
                    
                        // The player can take the toy(teddyBear), the leg and the eye
                        if (itemName.equalsIgnoreCase("leg")) {
                            player.take(leg);
                        } else if (itemName.equalsIgnoreCase("eye")) {
                            player.take(eye);
                        } else if (itemName.equalsIgnoreCase("toy")) {
                            player.take(teddyBear);
                        } else {
                            System.out.println("INVALID COMMAND");
                        }
                    } else {
                        System.out.println("INVALID COMMAND");
                    }
          
                } 
            } else {
                System.out.println("INVALID COMMAND");
            }
        scanner.close();
        }
    }
}

