import java.util.Scanner;

/**
 * The Main class is where we implement all the classes and run the game
 */
public class Main {
    public static void main(String[] args) {

        // Set game status
        Boolean gameOn = true;
        Boolean task1 = false;
        Boolean task2 = false;
        Boolean task3 = false;
        Boolean task4 = false;
        Boolean task5 = false;
        Boolean task6 = false;
        Boolean task7 = false;
        Boolean task8 = false;
        Boolean task9 = false;
        Boolean task10 = false;

        //Create all the items needed
        Item bed = new Item("bed", "'This is a bed.'", false, false, false);
        Item teddyBear = new Item("teddyBear", "'This teddy bear feels soft.'", true, false, false);
        Item box = new Item("box", "'This is a box. There is a leg inside.'", false, true, false);
        Item leg = new Item("leg", "This looks like my leg. I'd better put it on to walk.", true, true, true);
        Item irisPot = new Item("irisPot", "'There is a label on the plantpot saying 'iris pot'. There is an eye inside.'", false, true, false);
        Item eye = new Item("eye", "'This looks like my eye. I'd better put it on for better vision.'", true, false, true);
        Item door = new Item("door", "'This is a door connecting bedroom to another room. I wonder where is it leading to...'", false, true, false);

        //Create the Bedroom
        Room bedroom = new Room("Bedroom", "'This is a bedroom. I can see a bed, a teddy bear and a box.'", false, false);
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
        Human scientist = new Human("Teddy", lab, true, true, true, true);

        // Messages:
        String welcomeMessage = 
                        "\n Welcome to Teddy Bot! Get ready for your journey to discover hidden truths...";
        String basicInstructions = 
                        "\n Here is the basic instruction: Type the command with any item to execute that command on that item." +
                        "(E.g: 'open door')" +
                        "\n Type 'help' to see available commands at current stage, 'exit' to exit the game.";
        String enteringMessage = 
                        "\n Now get ready for the game..." +
                        "\n......LOADING......" +
                        "\n......Entering Game Teddy Bot......" +
                        "\n*****************" +
                        "\n Teddy Bot" +
                        "\n*****************";
        String stageOneMessage = 
                        "\n[STAGE 1]" +
                        "\n You wake up on a bed, having no idea who you are." +
                        "\n The only thing you know is that you possess a mechanical body" +
                        "with one leg and one eye missing." +
                        "\n 'Who am I? where am I? I should look around...'";
        String stageTwoMessage = 
                        "\n[STAGE 2]" +
                        "\n In front of you is a relatively empty lab with a giant computer." +
                        "\n However, red laser is all over the lab, blocking your way to get to the computer." +
                        "\n 'The red laser looks dangerous, I need to figure out a safe to get in...'";
        String stageThreeMessage = 
                        "\n[STAGE 3]" +
                        "\n Crrreeeaaak...You heard sound of door opening." +
                        "\n You turned your head to the direction of the sound and was surprised to see" +
                        "a scientist entered the lab through another door you didn't notice before." +
                        "\n 'Teddy???''Teddy???'" +
                        "[CONVERSATION TO BE ADDED]";
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
                        "- \"toggle control\" to toggle control buttons.\n";
        String cheatSheet3 = 
                        "- \"trade\" to trade bodies.\n" + 
                        "- \"electrocute\" to electrocute another existence\n" + 
                        "- \"destruct\" to initiate the self-destruct program of a robot.\n" +
                        "- \"fight\" to fight another existence.\n";

        // Starting the game
        System.out.println(welcomeMessage + basicInstructions + enteringMessage + stageOneMessage);
        
        // Open a scanner
        Scanner scanner = new Scanner(System.in);
        
        // Game loop
        while (gameOn == true) {

            // Accept a string of player inputs and split them
            String input = scanner.nextLine();
            String[] words = input.split(" ");

            if (words.length > 0) {
                String command = words[0]; // The first word is the command
            
                // Trying switch case
                switch(command) {

                    // Print cheatsheets based on current stage
                    case "help":
                        if (player.stageOne ==  true) {
                            System.out.println(cheatSheet1);
                        } else if (player.stageTwo ==  true) {
                            System.out.println(cheatSheet1 + cheatSheet2);
                        } else if (player.stageThree ==  true) {
                            System.out.println(cheatSheet1 + cheatSheet2 + cheatSheet3);
                        } 
                        break;
                    
                    // Let the player exit at any point in the game
                    case "exit":
                        System.out.println("Goodbye! We hope you enjoyed the game!");
                        // Change game state to break out the user input loop (because the game ended)
                        gameOn = false; 
                        break;
                    
                    // Print current health
                    case "health":
                        System.out.println(player.getHealth());
                        break;

                    // Print inventory
                    case "inventory":
                        player.printInventory();
                        break;

                    // Look around -> Print description of Room (based on current stage)
                    case "look":
                        if (player.stageOne == true) {
                            player.lookAround(bedroom);
                        } else if (player.stageTwo == true || player.stageThree == true) {
                            player.lookAround(lab);
                        } else {
                            System.out.println("[INVALID COMMAND]");
                        }
                        break;

                    // Fight the scientist (body occupied by the initial robot)
                    case "fight": 
                        player.fight(scientist);
                        break;

                    // electrocute the scientist
                    case "electrocute":
                        player.electrocute(scientist);
                        task8 = true;
                        break;

                    // Take items -> Look for user's next word to specify the Item being taken
                    case "take":
                        if (words.length >= 2) {
                            String itemName = words[1]; // The second word is the item's name
                        
                            // Allow 3 items to be taken: the teddy bear, leg and eye
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
                        break;

                    // Touch things to get their descriptions
                    case "touch":
                        if (words.length >= 2) {
                            // The second word is the item's name
                            String itemName = words[1]; 
                        
                            // The player can touch: bed, teddy bear, box, leg, iris pot, eye, door and computer
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
                            } else if (itemName.equalsIgnoreCase("computer")) {
                                player.touch(computer);
                            } else {
                                System.out.println("[INVALID COMMAND]");
                            } 
                        } else {
                            // There is only one word
                            System.out.println("What do you want to touch?");
                        }
                        break;

                    // Open items
                    case "open":
                        if (words.length >= 2) {
                            String itemName = words[1]; // The second word is the item's name
                        
                            // The player can open the box and the iris pot
                            if (itemName.equalsIgnoreCase("box")) {
                                player.open(box);
                            } else if (itemName.equalsIgnoreCase("iris") || itemName.equalsIgnoreCase("pot")) {
                                player.open(irisPot);
                            } else if (itemName.equalsIgnoreCase("door")) {
                                player.open(door, lab);
                                task3 = true;
                            } else if (itemName.equalsIgnoreCase("computer")) {
                                player.open(computer);
                                task5 = true;
                            } else if (itemName.equalsIgnoreCase("history")) {
                                computer.openHistory();
                                task6 = true;
                            } else if (itemName.equalsIgnoreCase("control")) {
                                computer.openControlPanel(player, lab);
                                task7 = true;
                            } else {
                                System.out.println("[INVALID COMMAND]");
                            } 
                        } else {
                            System.out.println("What do you want to open?");
                        }
                        break;

                    // Inspect items to get its description and status
                    case "inspect":
                        if (words.length >= 2) {
                            String itemName = words[1]; // The second word is the item's name
                            
                            // The player can only inspect if this attribute is true
                            if (player.canInspect == true) {
                                // The player can inspect all the items: bed, teddy bear, box, leg, iris pot, eye, door and computer
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
                                } else if (itemName.equalsIgnoreCase("computer")) {
                                    player.inspect(computer);
                                } else {
                                System.out.println("[INVALID COMMAND]");
                                }
                            } else if (player.canInspect == false) {
                                System.out.println("You cannot inspect with one one eye missing!");
                            }
                        } else {
                            System.out.println("What do you want to inspect?");
                        }
                        break;

                    // Crawl to an item in a room
                    case "crawl" :
                        if (words.length > 2) {
                            String itemName = words[2]; // The third word is the item's name
                    
                            // The player can crawl to these fixed items: 
                            // bedroom: (bed, box, iris pot, door), lab: (computer)
                            if (itemName.equalsIgnoreCase("bed")) {
                                player.crawlTo(bedroom, bed);
                                player.currentRoom = bedroom;
                            }  else if (itemName.equalsIgnoreCase("box")) {
                                player.crawlTo(bedroom, box);
                                player.currentRoom = bedroom;
                            } else if (itemName.equalsIgnoreCase("iris") || itemName.equalsIgnoreCase("pot")) {
                                player.crawlTo(bedroom, irisPot);
                                player.currentRoom = bedroom;
                            } else if (itemName.equalsIgnoreCase("door")) {
                                player.crawlTo(bedroom, door);
                                player.currentRoom = bedroom;
                            } else if (itemName.equalsIgnoreCase("computer")) {
                                player.crawlTo(lab, computer);
                                player.currentRoom = lab;
                                task4 = true;
                            }
                        
                            // The player can crawl to these transportable items:
                            // teddy bear
                            // The player can't crawl to leg and eye because they are stored inside another item
                            else if (itemName.equalsIgnoreCase("teddy") || itemName.equalsIgnoreCase("bear")) {
                                
                                if (bedroom.itemsInRoom.contains(teddyBear)) {
                                    player.crawlTo(bedroom, teddyBear);
                                    player.currentRoom = bedroom;
                                } else if (lab.itemsInRoom.contains(teddyBear)) {
                                    player.crawlTo(lab, teddyBear);
                                    player.currentRoom = lab;
                                } else if (player.inventory.contains(teddyBear)) {
                                    System.out.println("You can't crawl to the teddy bear because it's in your inventory!");
                                }
                                  
                            }

                            // If the third word is none of the names of the items, we print out "[INVALID COMMAND]"
                            else {
                                System.out.println("[INVALID COMMAND]");
                            }
                        
                        } else {
                            System.out.println("What do you want to crawl to?");
                        }
                        break;
                    
                    // walk to an item in a room
                    case "walk":
                        if (words.length > 2) {
                            String itemName = words[2]; // The third word is the item's name
                            
                            // The player can only walk if this attribute is true
                            if (player.canWalk == true) {

                                // The player can walk to these fixed items: 
                                // bedroom: (bed, box, iris pot, door), lab: (computer)
                                if (itemName.equalsIgnoreCase("bed")) {
                                    player.walkTo(bedroom, bed);
                                    player.currentRoom = bedroom;
                                }  else if (itemName.equalsIgnoreCase("box")) {
                                    player.walkTo(bedroom, box);
                                    player.currentRoom = bedroom;
                                } else if (itemName.equalsIgnoreCase("iris") || itemName.equalsIgnoreCase("pot")) {
                                    player.walkTo(bedroom, irisPot);
                                    player.currentRoom = bedroom;
                                } else if (itemName.equalsIgnoreCase("door")) {
                                    player.walkTo(bedroom, door);
                                    player.currentRoom = bedroom;
                                } else if (itemName.equalsIgnoreCase("computer")) {
                                    player.walkTo(lab, computer);
                                    player.currentRoom = lab;
                                }
                            
                                // The player can walk to these transportable items:
                                // teddy bear
                                // The player can't walk to leg because it's put on and eye because it's stored inside another item
                                else if (itemName.equalsIgnoreCase("teddy") || itemName.equalsIgnoreCase("bear")) {
                                
                                    if (bedroom.itemsInRoom.contains(teddyBear)) {
                                        player.walkTo(bedroom, teddyBear);
                                        player.currentRoom = bedroom;
                                    } else if (lab.itemsInRoom.contains(teddyBear)) {
                                        player.walkTo(lab, teddyBear);
                                        player.currentRoom = lab;
                                    } else if (player.inventory.contains(teddyBear)) {
                                        System.out.println("You can't walk to the teddy bear because it's in your inventory!");
                                    }
                                      
                                }

                                // If the third word is none of the names of the items, we print out "[INVALID COMMAND]"
                                else {
                                    System.out.println("[INVALID COMMAND]");
                                }

                            } else if (player.canWalk == false) {
                                System.out.println("You cannot walk with one one leg missing! Try crawling instead.");
                            } 
                        } else {
                            System.out.println("What do you want to walk to?");
                        }
                        break;

                    // put on an item or put down an item
                    case "put":
                        if (words.length > 2) {
                            String preposition = words[1].toLowerCase(); // The second word is the preposition: on/down
                            String itemName = words[2].toLowerCase(); // The third word is the item's name
                            
                            // If the preposition is on, we perform `putOn` 
                            if (preposition.equals("on")) {

                                // The player can put on these fixed items: 
                                // leg and eye
                                if (itemName.equals("leg")) {
                                    player.putOn(leg);
                                    player.canWalk = true; // The player can walk after putting on the leg
                                    task1 = true; // [Task 1] 
                                } else if (itemName.equals("eye")) {
                                    player.putOn(eye);
                                    player.canInspect = true; // The player can inspect after putting on the eye
                                    task2 = true; // [Task 2] completed
                                } else {
                                    System.out.println("You cannot put on " + itemName);
                                }
                            }

                            // If the preposition is down, we perform `putDown`
                            else if (preposition.equalsIgnoreCase("down")) {

                                // The player can put down these transportable items:
                                // leg, eye, teddy bear
                                if (itemName.equalsIgnoreCase("teddy") || itemName.equalsIgnoreCase("bear")) {
                                        player.putDown(teddyBear);
                                } else if (itemName.equalsIgnoreCase("leg")) {
                                        player.putDown(leg);
                                        player.canWalk = false;
                                } else if (itemName.equalsIgnoreCase("eye")) {
                                        player.putDown(eye);
                                        player.canInspect = false;
                                } else {
                                    System.out.println("You cannot put down" + itemName);
                                }
                            }

                            // If the preposition is neither on or down, we print out "[INVALID COMMAND]"
                            else {
                                    System.out.println("You can only 'put on' or 'put down'");
                            }

                        } else {
                            System.out.println("What do you want to put on/down?");
                        }
                        break;

                    // toggle a control button on the control panel
                    case "toggle":
                        if (words.length >= 2) {
                            String control = words[1]; // The second word is the control

                                // The player can toggle these control items: 
                                // power and laser
                                if (control.equalsIgnoreCase("power")) {
                                    computer.togglePower(player);
                                }  else if (control.equalsIgnoreCase("laser")) {
                                    computer.toggleLaser(lab);
                                } else {
                                    System.out.println("[INVALID COMMAND]");
                                }
                        } else {
                            System.out.println("What do you want to toggle?");
                        }
                        break;
                
                    // trade bodies
                    case "trade":
                        player.tradeBody(player, scientist);
                        task9 = true;
                        break;

                    // initiate the self-destrcuct program in the robot
                    case "destruct":
                        // If task 10 is done, can perform destruct
                        scientist.selfDestruct(player);
                        // Completed task 11
                        // Print ending message 
                        break;
                } // close parenthesis for switch(command)
            } // close parenthesis for if(words.length > 0)

            // When Task 1, 2, 3 are finished, enter stage 2
            if ((task1 == true) && (task2 == true) && (task3 == true)) {
                player.stageOne = false;
                player.stageTwo = true;
                player.stageThree = false;
                System.out.println(stageTwoMessage);
            }

            // When Task 4, 5, 6, 7 are finished, enter stage 3
            if ((task4 == true) && (task5 == true) && (task6 == true) && (task7 == true)) {
                player.stageOne = false;
                player.stageTwo = false;
                player.stageThree = true;
            }
            

        } scanner.close(); // close the scanner outside of the while loop
    } // close parenthesis for public static void main(String[] args)
} // close parenthesis for public Class Main

