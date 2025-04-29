import java.util.Scanner;

/**
 * The Main class is where we implement all the classes and run the game
 */
public class Main {
    public static void main(String[] args) {

        //Create all the items needed
        Item bed = new Item("bed", "'This is a bed.'", false, false, false);
        Item teddyBear = new Item("teddyBear", "'This teddy bear feels soft.'", true, false, false);
        Item box = new Item("box", "'This is a box. There is a leg inside.'", false, true, false);
        Item leg = new Item("leg", "'This looks like my leg. I'd better put it on to walk.'", true, false, true);
        Item irisPot = new Item("irisPot", "'There is a label on the plantpot saying 'iris pot'. There is an eye inside.'", false, true, false);
        Item eye = new Item("eye", "'This looks like my eye. I'd better put it on for better vision.'", true, false, true);
        Item door = new Item("door", "'This is a door connecting bedroom to another room. I wonder where is it leading to...'", false, true, false);

        //Create the Bedroom
        Room bedroom = new Room("Bedroom", "'This is a bedroom. I can see a bed and a teddy bear.'", false, false);
        bedroom.addItem(bed);
        bedroom.addItem(teddyBear);
        bedroom.addItem(box);
        bedroom.addItem(leg);
        box.storeItem(leg);
        bedroom.addItem(irisPot);
        bedroom.addItem(eye);
        irisPot.storeItem(eye);
        bedroom.addItem(door);

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
        
        // Game loop
        while (true) {

            // Accept a string of player inputs and split them
            String input = scanner.nextLine();
            String[] words = input.split(" ");

            if (words.length > 0) {
                String command = words[0]; // The first word is the command
            
                // If the command is help, we print out cheatsheets based on stages
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

                // If the command is health, we print out the current health of the player
                if (command.equalsIgnoreCase("health")) {
                    System.out.println("Your current health is: " + player.getHealth() + " /100");
                }

                // If the command is inventory, we print out the player's inventory
                if (command.equalsIgnoreCase("inventory")) {
                    player.printInventory();
                }

                // If the command is look, we let the player look around and print out the decription of the room
                if (command.equalsIgnoreCase("look")) {
                    if (player.stageOne == true) {
                        player.lookAround(bedroom);
                    } else if (player.stageTwo == true || player.stageThree == true) {
                        player.lookAround(lab);
                    } 
                } 

                // If the command is take, look for the next word to see what item to pick
                if (command.equalsIgnoreCase("take")) {
                    if (words.length >= 2) {
                        String itemName = words[1]; // The second word is the item's name
                    
                        // The player can take the teddy bear, leg and eye
                        if (itemName.equalsIgnoreCase("leg")) {
                            player.take(leg);
                            System.out.println("'Let me try to put it on...'");
                        } else if (itemName.equalsIgnoreCase("eye")) {
                            player.take(eye);
                            System.out.println("'Let me try to put it on...'");
                        } else if (itemName.equalsIgnoreCase("teddy") || itemName.equalsIgnoreCase("bear")) {
                            player.take(teddyBear);
                        } else {
                            System.out.println("[INVALID COMMAND]");
                        }
                    } else {
                        System.out.println("What do you want to take?");
                    }
                }

                // If the command is touch, we let the player touch the item and return its description
                if (command.equalsIgnoreCase("touch")) {
                    if (words.length >= 2) {
                        String itemName = words[1]; // The second word is the item's name
                    
                        // The player can touch all the items: bed, teddy bear, box, leg, iris pot, eye and door
                        if (itemName.equalsIgnoreCase("bed")) {
                            player.touch(bed);
                        } else if (itemName.equalsIgnoreCase("teddy") || itemName.equalsIgnoreCase("bear")) {
                            player.touch(teddyBear);
                        } else if (itemName.equalsIgnoreCase("box")) {
                            player.touch(box);
                        } else if (itemName.equalsIgnoreCase("leg")) {
                            player.touch(leg);
                        } else if (itemName.equalsIgnoreCase("iris") || itemName.equalsIgnoreCase("pot")) {
                            player.touch(irisPot);
                        } else if (itemName.equalsIgnoreCase("eye")) {
                            player.touch(eye);
                        } else if (itemName.equalsIgnoreCase("door")) {
                            player.touch(door);
                        } else {
                            System.out.println("[INVALID COMMAND]");
                        }
                    } else {
                        System.out.println("What do you want to touch?");
                    }
                }

                // If the command is inspect, we let the player inspect the item and return its description and status
                if (command.equalsIgnoreCase("inspect")) {
                    if (words.length >= 2) {
                        String itemName = words[1]; // The second word is the item's name
                        
                        // The player can only inspect if this attribute is true
                        if (player.canInspect == true) {
                            // The player can inspect all the items: bed, teddy bear, box, leg, iris pot, eye and door
                            if (itemName.equalsIgnoreCase("bed")) {
                                player.inspect(bed);
                            } else if (itemName.equalsIgnoreCase("teddy") || itemName.equalsIgnoreCase("bear")) {
                                player.inspect(teddyBear);
                            } else if (itemName.equalsIgnoreCase("box")) {
                                player.inspect(box);
                            } else if (itemName.equalsIgnoreCase("leg")) {
                                player.inspect(leg);
                            } else if (itemName.equalsIgnoreCase("iris") || itemName.equalsIgnoreCase("pot")) {
                                player.inspect(irisPot);
                            } else if (itemName.equalsIgnoreCase("eye")) {
                                player.inspect(eye);
                            } else if (itemName.equalsIgnoreCase("door")) {
                                player.inspect(door);
                            } else {
                                System.out.println("[INVALID COMMAND]");
                            }
                        } else if (player.canInspect == false) {
                            System.out.println("You cannot inspect with one one eye missing!");
                        }
                    } 
                    else {
                        System.out.println("What do you want to inspect?");
                    }
                } 

                // If the command is crawl to, we let the player crawl to an item
                if (command.equalsIgnoreCase("crawl")) {
                    if (words.length >= 2) {
                        String itemName = words[2]; // The third word is the item's name
                    
                        // The player can crawl to these fixed items: 
                        // bedroom: (bed, box, iris pot, door), lab: (computer)
                        if (itemName.equalsIgnoreCase("bed")) {
                            player.crawlTo(bedroom, bed);
                        }  else if (itemName.equalsIgnoreCase("box")) {
                            player.crawlTo(bedroom, box);
                        } else if (itemName.equalsIgnoreCase("iris") || itemName.equalsIgnoreCase("pot")) {
                            player.crawlTo(bedroom, irisPot);
                        } else if (itemName.equalsIgnoreCase("door")) {
                            player.crawlTo(bedroom, door);
                        } else if (itemName.equalsIgnoreCase("computer")) {
                            player.crawlTo(lab, computer);
                        }
                        
                        // The player can crawl to these transportable items:
                        // teddy bear
                        // The player can't crawl to leg and eye because they are stored inside another item
                        else if (itemName.equalsIgnoreCase("teddy") || itemName.equalsIgnoreCase("bear")) {
                            if (player.stageOne == true) {
                                player.crawlTo(bedroom, teddyBear);
                            } else if (player.stageTwo == true || player.stageThree == true) {
                                if (bedroom.itemsInRoom.contains(teddyBear)) {
                                    player.crawlTo(bedroom, teddyBear);
                                } else if (lab.itemsInRoom.contains(teddyBear)) {
                                    player.crawlTo(lab, teddyBear);
                                } 
                            }   
                        }

                        // If the third word is none of the names of the items, we print out "[INVALID COMMAND]"
                        else {
                            System.out.println("[INVALID COMMAND]");
                        }
                        
                    } else {
                        System.out.println("What do you want to crawl to?");
                    }
                }

                // walk to

                // open

                // put on

                // put down

                // unlock

                // click

                // toggle

                // trade

                // electrocute

                // fight

                // die (we should put the respawn chat here instead of inside the existence class)

                // Task 1

                // Task 2

                // Task 3

                // Stage 2

                // Task 4

                // Task 5

                // Task 6

                // Task 7

                // Stage 3

                // Task 8

                // Task 9

                // Task 10

                // Task 11

                // Task 12

                // Ending 1 (laser)

                // Ending 2 (power off)

                // Ending 3 (self destruct)

                // Ending 4 (forgive)

                // Ending 5 (revenge)
            }
        } scanner.close(); // close the scanner outside of the while loop
    }
}

