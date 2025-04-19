import java.util.ArrayList;

public class Existence {

    // Attributes
    public String name;
    protected ArrayList<Item> inventory = new ArrayList<>(); 
    protected int health; // Imaginary health bar
    public Boolean isAlive;

    // Constructor

    /**
     * Default player constructor
     */
    public Existence(String name, int health,  Boolean isAlive) {
        this.name = "Teddy";
        this.isAlive = true;
        this.health = 100; // User starts the game with full health.
        this.inventory = new ArrayList<Item>();
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

    // Game Functions

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
        System.out.println("You are in: " + r.getDescription());
    }


    public void inspect() {

    }

    public void crawlTo(String s) {
        
    }


    public void walkTo(String direction){
        
    }


    
}
