import java.util.ArrayList;
import java.util.Scanner;
/**
 * The Existence class represents the existences that can interact with the items
 */
public class Existence {

    // Attributes
    public String name;
    public Room currentRoom; // To be discussed! Do we need this?
    // Should we also have an attribute for currentLocation? Like near some item?
    protected ArrayList<Item> inventory = new ArrayList<>(); 
    protected int health; // Imaginary health bar
    public Boolean isAlive;
    protected Boolean canGoToLab;
    protected Boolean canWalk;
    protected Boolean canInspect;

    // Constructor

    /**
     * Default player constructor
     * @param name
     * @param currentRoom
     */
    public Existence(String name, Room currentRoom) {
        this.name = "Teddy";
        this.isAlive = true;
        this.health = 100; // User starts the game with full health.
        this.inventory = new ArrayList<Item>();
        this.canGoToLab = false; // Default to false
        this.canWalk = false; // Default to false because the player wake up with one lege missing
        this.canInspect = false; // Default to false because the player wake up with one eye missing

    }

    // Methods

    /**
     * Accessor for an exsitence's name
     * @return name of the existence
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for one's health bar
     * @return Current health bar number
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Accessor for user's isAlive value (true/false)
     */
    public Boolean getIsAlive() {
        return this.isAlive;
    }
    
    /**
     * Accessor for the player's state of whether they can go to the lab yet
     */
    public Boolean getCanGoToLab() {
        return this.canGoToLab;
    }

    /**
     * Accessor for the player's state of whether they can walk yet (only with both legs can)
     */
    public Boolean getCanWalk() {
        return this.canWalk;
    }

    /**
     * Accessor for the player's state of whether they can inspect yet (only with both eyes can)
     */
    public Boolean getCanInspect() {
        return this.canInspect;
    }
    
    /**
     * Decreases health (while fighting)
     */
    public void weaken() {
        this.health -= 20;
    } 

    /**
     * Immediately changes one's isAlive state to false, and health to 0.
     * Often as a result of being electrocuted or hit by a laser beam.
     */
    public void die() {
        if (this.health <= 0) {
            this.isAlive = false;
            System.out.println("You have died.");
            respawnChat();
        }
    }

    /**
     * Become alive again
     */
    public void respawn() {
        if(this.isAlive == false) { // Check that user is actually dead
            this.health = 100;
            this.isAlive = true;
            System.out.println("I am reborn!");
        } else {
            throw new RuntimeException("You are still alive! ");
        }
    }

    /**
    * Starts and runs the conversation with the user
    * Asks the user how many rounds they want to chat for
    */
    public void respawnChat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to die or respawn to play again? Press Y to respawn and N to die.");

        String choice = scanner.nextLine();
        if (choice.equals("Y")) {
            this.respawn();
            System.out.println("You're alive again - Hooray!");
        } else if (choice.equals("N")) {
            System.out.println("Okay, you're dead. Bye!");
        } else {
            System.out.println("I don't understand what you wrote. Try only Y or N.");
        }
        scanner.close();
    }

    // Game Functions

    /**
     * Open an item if there is another item stored inside
     * @param item to be opened
     */
    public void open(Item s) {
        if (s.getCanBeOpened() == true){
            System.out.println("You have opened " + s + ". Inside it is " + s.getContainedItem() + " .");
        } else {
            // To be constructed! A few scenorios:
            // 1. try to open an item that can't be opened
            // 2. try to open an item that has already been opened
            // 3. try to open an item when we are not near it's location
            // Some more?
        }
    }

    /**
     * Overloaded open() method for a computer
     * @param computer to be opened
     */
    public void open(Computer c) {
        if (c.locked == true) {
            c.locked = false;
            System.out.println("\nYou opend the computer. Two folders appear: History and Control Panel.");
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Which folder do you want to see? Press H to open History folder and C to open Control Panel.");
            String choice2 = scanner2.nextLine();
            if (choice2.equals("H")) {
                System.out.println("You opened the History Folder...");
                c.openHistory();
            } else if (choice2.equals("C")) {
                System.out.println("You opened the control Panel...");
                c.openControlPanel(Robot r, Room rm);
                System.out.println("Do you want to toggle any controls? Enter the name of the control to toggle... ");
                System.out.println("Do you want to toggle any controls? Enter the name of the control to toggle... ");
                /** Scanner scanner3 = new Scanner(System.in);
                String choice3 = scanner3.nextLine();
                if (choice3.equals("Reasoning")) {
                    c.toggleReasoning(Robot r);
                } else if (choice3.equals("Power")) {
                    c.togglePower(Robot r);
                } else if (choice3.equals("Memory")) {
                    c.toggleMemory(Robot r);
                } else if (choice3.equals("Laser")) {
                    c.toggleLaser(Room r);
                } else if (choice3.equals("TradeBody") || choice3.equals("SelfDestruct")) {
                    System.out.println("\n[RESTRICTED ACTION FAILED]");
                } else {
                    System.out.println("[INVALID COMMAND]");
                } scanner3.close(); */
            } else {
                System.out.println("[INVALID COMMAND]");
            } scanner2.close();
        } else {
            System.out.println("\nThe computer is unlocked and opened.");
        } //Much to do with this overloaded method!!
    }

    

    /**
     * Touch an item, which gives its description, NOT add it to inventory.
     * @param s The item
     */
    public void touch(Item s) {
        System.out.println(s.getDescription());
    }

    /**
     * Let the user take/own an item (add it to inventory)
     * @param s the item
     */
    public void take(Item s) {
        if(this.inventory.contains(s)) {
            throw new RuntimeException("You already have " + s.getName() + ".");
        } else {
            this.inventory.add(s);
            System.out.println(s.getName() + " successfully added to your inventory!");
        }
    }   

    /**
     * Let the user put down an item at a room (remove it from inventory)
     * @param s the item
     * @param r the room
     */
    public void putDown(Item s, Room r) {
        if (this.inventory.contains(s) && r != null) {
            this.inventory.remove(s);
            System.out.println("You put down the " + s.getName() + " in the " + r.getName() + ".");
        } // This method need to be modified.
          // We need to figure out how to how to represent the current room we are in
          // If we want to put down the item in the current room, we will successfully do that
          // If we want to put down the item in another room, we need to walk to/crawl to that room first
    }

    /**
     * Print the ArrayList of player's inventory.
     */
    public void printInventory() {
        System.out.println("Your inventory contains:");
        System.out.println(this.inventory.toString());
    }

    /**
     * User fights another existence
     * @param e The other entity
     */
    public void fight(Existence e) {
        this.weaken();
        System.out.println("I am fighting!");
    }

    /**
     * See description of the surrounding space.
     * @param r The room one is in
     */
    public void lookAround(Room r) {
        if (r == null) {
        System.out.println("You're not in a room.");
        return;
        } System.out.println("You look around the: " + r.getName() + r.getDescription());
    }

    /**
     * Inspect an item, see its description and the status of whether it can be grabbed
     * @param s the item to be inspected
     */
    public void inspect(Item s) {
        if (s == null) {
            System.out.println("There is nothing to inspect.");
            return;
        }
    
        System.out.println("Inspecting the " + s.getName() + "...");
        System.out.println("Description: " + s.getDescription() + s.getItemStatus());
    }
    
    /**
     * Walk to an item in a room (only with both legs)
     * @param r the room to walk to
     * @param s the item to walk to
     */
    public void walkTo(Room r, Item s) {
        if (this.canWalk = true) {
            System.out.println("You can walk to these items in the current room" + r.getItems());
            if (r == null || s == null) {
                System.out.println("There is nowhere to walk to.");
            } else if (!r.getItems().contains(s)) {
                System.out.println("You can't walk to the " + s.getName() + " because it's not in this room.");
            } else {
                System.out.println(" You walked to " + s.getName() + ".");
                System.out.println("... Walking ...");
                System.out.println("You are now near the " + s.getName() + ".");
            }
        } else {
            System.out.println("You don't have both legs yet. You can only crawl to somewhere.");
        }
    }
    
    /**
     * Crawl to an item in a room
     * @param r the room to crawl to
     * @param s the item to crawl to
     */
    public void crawlTo(Room r, Item s) {
        if (r.getItems().contains(s)) {
            System.out.println("You crawled slowly toward the " + s.getName() + ".");
            System.out.println("....... Crawling ...... \n ...... Crawling ......");
            System.out.println("..... Almost there ......");
            System.out.println("You reached the " + s.getName() + ", catching your breath.");
            System.out.println("You are now near the " + s.getName() + ".");
        } else {
            System.out.println("You can't crawl to the " + s.getName() + " because it's not in this room.");
        }
    }
}
