import java.util.ArrayList;
import java.util.Scanner;
/**
 * The Existence class represents the existences that can interact with the items
 */
public class Existence {

    // Attributes
    public String name;
    public Room currentRoom; // The current location of 'Existence'
    
    // Should we also have an attribute for currentLocation? Like near some item?
    protected ArrayList<Item> inventory = new ArrayList<>(); 
    protected int health; // Imaginary health bar
    public Boolean isAlive;
    public Boolean wantsToLive;
    public Boolean canGoToLab;
    public Boolean canWalk;
    public Boolean canInspect;

    // Stages
    public Boolean stageOne;
    public Boolean stageTwo;
    public Boolean stageThree;

    // Constructor

    /**
     * Default player constructor
     * @param name
     * @param currentRoom
     */
    public Existence(String name, Room currentRoom) {
        this.name = "Teddy";
        this.isAlive = true;
        this.wantsToLive = true;
        this.health = 100; // User starts the game with full health.
        this.inventory = new ArrayList<Item>();
        this.currentRoom = currentRoom;
        this.canGoToLab = false; // Default to false
        this.canWalk = false; // Default to false because the player wake up with one lege missing
        this.canInspect = false; // Default to false because the player wake up with one eye missing
        this.stageOne = true;
        this.stageTwo = false;
        this.stageThree = false;

    }

    // Methods
    
    /**
     * Getter for currentRoom
     * @return the current room name
     */
    public String getCurrentLocation(){
        return this.currentRoom.name;
    }
    /**
     * Accessor for one's health bar
     * @return Current health bar number
     */
    public String getHealth() {
        return ("Your current health is: " + this.health + " /100");
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
        this.health = 0;
        this.isAlive = false;
        respawnChat();
    }

    /**
     * Become alive again
     */
    public void respawn() {
        if(this.isAlive == false) { // Check that user is actually dead
            this.health = 100;
            this.isAlive = true;
            System.out.println("'I am reborn!'");
        } else {
            System.out.println("You are still alive! ");
        }
    }

    /**
    * Starts and runs the conversation with the user
    * Asks the user how many rounds they want to chat for
    */
    @SuppressWarnings("resource") // Allows Scanner to stay open for operation in game loop.
    public void respawnChat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDo you want to die or respawn to play again? Press Y to respawn and N to die.");

        String choice = scanner.nextLine();
        if (choice.equals("Y")) {
            this.respawn();
            System.out.println("You're alive again - Hooray!");
        } else if (choice.equals("N")) {
            this.wantsToLive = false;
            System.out.println("Okay, you're dead. Bye!");
        } else {
            System.out.println("I don't understand what you wrote. Try only Y or N.");
        }
        
    }

    // Game Functions

    /**
     * Open an item if there is another item stored inside
     * @param item to be opened
     */
    public void open(Item s) {
        if (s.canBeOpened == true) {
            System.out.println("You have opened " + s.name + ". Inside it is a " + s.getContainedItem().name + ".");
        }
    }
    
    /**
     * Overloaded open method for opening a door leading to a room
     * @param the door to be opened
     * @param the room the door is leading to
     */
    public void open(Item s, Room r) {
        if (s.canBeOpened == true) {
            System.out.println("You opened the " + s.name + " leading to the " + r.name + ".");
        }
    }

    /**
     * Overloaded open method for a computer
     * @param computer to be opened
     */
    public void open(Computer c) {
        c.locked =false;
       System.out.println("You opened the computer and two folders appear: History and Control Panel." + 
       "\n 'I want to try opening one of the folders...'");
    }

    

    /**
     * Touch an item, which gives its description, NOT add it to inventory.
     * @param s The item
     */
    public void touch(Item s) {
        System.out.println(s.description);
    }

    /**
     * Let the user take/own an item (add it to inventory)
     * @param s the item
     */
    public void take(Item s) {
        if (this.inventory.contains(s)) {
            System.out.println("You already have " + s.name + ".");
        } else {
            this.inventory.add(s);
            System.out.println(s.name + " successfully added to your inventory!");
            if (s.canBePutOn == true) {
                System.out.println(s.description);
            }
        }
    }   

    /**
     * Let the user put down an item at a room (remove it from inventory)
     * @param s the item
     * @param r the room
     */
    public void putDown(Item s) {
        if (this.inventory.contains(s) && s.canBeGrabbed == true) {
            this.inventory.remove(s);
            this.currentRoom.itemsInRoom.add(s);
            System.out.println("You put down the " + s.name + ".");
        } else {
            System.out.println("You cannot put down " + s.name + "because it's not in your inventory.");
        }
    }

    /**
     * Print the ArrayList of player's inventory.
     */
    public void printInventory() {
        System.out.println("Your inventory currently contains:");
        System.out.println(this.inventory.toString());
    }

    /**
     * User fights another existence
     * @param e The other entity
     */
    public void fight(Existence e) {
        this.weaken();
        e.weaken();
        System.out.println("You fought with Teddy fiercly, but he's way more stronger than you. \n" 
        + this.getHealth() + "\n 'I couldn't win by fighting. I should find a better way to stop him...'");
    }

    public void run() {
        this.weaken();
        System.out.println("You ran and ran, exhausting your strength.\n"  
        + this.getHealth() + "\n 'I won't stop him by running away. I should find a better way to stop him...'");
    }

    /**
     * See description of the surrounding space.
     * @param r The room one is in
     */
    public void lookAround(Room r) {
        if (r == null) {
        System.out.println("You're not in a room.");

        } System.out.println("You look around the " + r.name + ". "+ r.description);
    }

    /**
     * Inspect an item, see its status
     * @param s the item to be inspected
     */
    public void inspect(Item s) {
        if (s == null) {
            System.out.println("There is nothing to inspect.");
        }
    
        System.out.println("Inspecting the " + s.name + "...");
        System.out.println(s.getItemStatus());
    }
    
    /**
     * Walk to an item in a room (only with both legs)
     * @param r the room to walk to
     * @param s the item to walk to
     */
    public void walkTo(Room rm, Item s) {
        if (this.canWalk = true) {
                System.out.println(" You walked to " + s.name + ".");
                System.out.println("... Walking ...");
                System.out.println("You are now near the " + s.name + ".");
        } else {
            System.out.println("You don't have both legs yet. You can only crawl to somewhere.");
        }
    }
    
    /**
     * Crawl to an item in a room
     * @param r the room to crawl to
     * @param s the item to crawl to
     */
    public void crawlTo(Room rm, Item s) {
        if (rm.itemsInRoom.contains(s)) {
            System.out.println("You crawled slowly toward the " + s.name + " in the " + rm.name + ".");
            System.out.println("....... Crawling ...... \n ...... Crawling ......");
            System.out.println("..... Almost there ......");
            System.out.println("You reached the " + s.name + ", catching your breath.");
            System.out.println("You are now near the " + s.name + ".");
        } else {
            System.out.println("You can't crawl to the " + s.name + " because it's not in this room.");
        }
    }

    /**
     * trade bodies between robot and human
     * @param r robot
     * @param h human
     */
    public void tradeBody(Robot r, Human h) {
        System.out.println("\n Detecting surrounding existences......" +
        "\n There are currently two existence: Robot " + r.name + " and Human" + h.name + " ." +
        "\n -------------------------Trading Body-------------------------" +
        "\n Robot" + r.name + " has successfully traded body with human " + h.name + " ."
        );
    }

}
