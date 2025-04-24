
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Existence {

    // Attributes
    public String name;
    protected ArrayList<Item> inventory = new ArrayList<>(); 
    protected int health; // Imaginary health bar
    public Boolean isAlive;
    private Object currentRoom;
    private Object currentTarget;
    private Boolean canGoToLab;

    // Constructor

    /**
     * Default player constructor
     */
    public Existence(String name, int health,  Boolean isAlive) {
        this.name = "Teddy";
        this.isAlive = true;
        this.health = 100; // User starts the game with full health.
        this.inventory = new ArrayList<Item>();
        this.canGoToLab = false; // Default to false

    }

    // Methods

    // Accessors / changers

    public String getName() {
        return this.name;
    }
    /**
     * Getter for one's health bar
     * @return Current health bar number
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Get user's isAlive value (true/false)
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
    }

    /**
     * Become alive again
     */
    public void respawn() {
        this.getIsAlive();
        if(this.isAlive == false) { // Check that user is actually dead
            this.health = 100;
            this.isAlive = true;
            System.out.println("I am reborn!");
        }
        else {
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
        this.getIsAlive();
        this.respawn();
        System.out.println("You're alive again - Hooray!");
    }
    else if (choice.equals("N")) {
        System.out.println("Okay, you're dead. Bye!");
    }
    else {
        System.out.println("I don't understand what you wrote. Try only Y or N.");
    }
    scanner.close();
    }

    // Game Functions

    public void open(Item s){
        if (s.getCanBeOpened() == true){
            s.getContainedItem();
            System.out.println(s + " contains " + s.getContainedItem());
        }
    }
    /**
     * Browse all, and utilise a functionality of an item
     */
    public void use(Item s) {
        if(inventory.contains(s)) {
            System.out.println(s.getDescription()); // Placeholder for .getUse()
        }
        else {
            throw new RuntimeException("You to not have " + s.getName() + ". Take it first!.");
        }
    }

    /**
     * Touch an item, which gives its description, NOT add it to inventory.
     * @param s The item
     */
    public void touch(Item s) {
        System.out.println(s.getDescription());
    }

    /**
     * Lets the user take/own an item (add it to inventory)
     * @param s the item
     */
    public void take(Item s) {
        if(this.inventory.contains(s)) {
            throw new RuntimeException("You already have " + s.getName() + ".");
        }
        else {
            this.inventory.add(s);
            System.out.println(s.getName() + " successfully added to your inventory!");
        }
    }   

    /**
     * Print the ArrayList of player's inventory.
     */
    public void printInventory() {
        System.out.println("Your inventory contains:");
        System.out.println(this.inventory.toString());
    }

    /**
     * Lets the user access history of an item
     * @param s The item
     */
    public void think(Item s) {
        System.out.println("I am thinking...");
        // s.getHistory() //Placeholder for that as well
    }

    /**
     * User fights another existence for a specified number of times
     * @param e The other entity
     * @param times The number of times to fight
     */
    public void fight(Existence e, int times) {
        System.out.println("I am fighting!");
    }

    /**
     * See description of the surrounding space.
     * @param r The room one is in
     */
    public void lookAround(Room r) {
        if (r == null) {
        System.out.println("You’re not in a room.");
        return;
    }

    System.out.println("You look around the room: " + r.getName());
    List<Item> items = r.getItems();
    if (items.isEmpty()) {
        System.out.println("The room seems empty.");
    } else {
        System.out.println("You see the following items:");
        for (Item item : items) {
            System.out.println("- " + item.getName());
        }
    }
    }

    
    public void inspect(Item s) {
        if (s == null) {
            System.out.println("There is nothing to inspect.");
            return;
        }
    
        System.out.println("Inspecting the " + s.getName() + "...");
        System.out.println("Description: " + s.getDescription());
        System.out.println("Can be grabbed? " + (s.getItemStatus() ? "Yes" : "No"));
    }
    
    public void walkTo(Item s) {
        if (s == null) {
            System.out.println("There is nowhere to walk to.");
            return;
        }
    
    
        if (currentTarget != null && currentTarget.equals(s)) {
            System.out.println("You’re already near the " + s.getName() + ".");
            return;
        }
    
        if (currentRoom != null && !((Room) currentRoom).getItems().contains(s)) {
            System.out.println("You can't walk to the " + s.getName() + " — it’s not in this room.");
            return;
        }
    
        currentTarget = s;
        System.out.println(" You walk to " + s.getName() + ".");
        System.out.println("You are now near the " + s.getName() + ".");
    }
    


    public void crawlTo(Item s) {
        if (s == null) {
            System.out.println("There is nowhere to crawl to.");
            return;
        }
    
        if (currentTarget != null && currentTarget.equals(s)) {
            System.out.println("You’re already near the " + s.getName() + ".");
            return;
        }
    
        if (currentRoom != null && !((Room) currentRoom).getItems().contains(s)) {
            System.out.println("You can't crawl to the " + s.getName() + " — it’s not in this room.");
            return;
        }
    
        currentTarget = s;
        System.out.println(this.name + " crawls slowly toward the " + s.getName() + ".");
        System.out.println("You reach the " + s.getName() + ", catching your breath.");
    }
    
}
