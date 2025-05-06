import java.util.ArrayList;

/**
 * The Robot class extends Existence class
 * It has unique attribute of boolean poweredOn
 * and unique methods of put on mechanical body parts and electrocute human
 */
public class Robot extends Existence {

    //Attributes
    public Boolean poweredOn;
    
    /**
     * Constructor for Robot
     * @param name robot's name
     * @param currentRoom the robot's current location
     * @param isAlive the robot's life status
     * @param canGoToLab indicator for whether player has finished stage 1 
     * @param canWalk indicator for whether player has put on leg
     * @param canInspect indicator for whether player has put on eye
     */
    public Robot(String name, Room currentRoom, Boolean isAlive, Boolean canGoToLab, Boolean canWalk, Boolean canInspect) {
        super(name, currentRoom);
        this.isAlive = true;
        this.health = 100; // Robot has less health than human.
        this.inventory = new ArrayList<Item>();
        this.canGoToLab = false; // will unlock after achieving the first four tasks in stage 1
        this.canWalk = false; // will unlock after adding leg to the body
        this.canInspect = false; // will unlock after adding eye to the body
        this.poweredOn = true; // will be able to turn off after unlocking the control panel
    }
    
    // Methods

    /**
    * The robot can put on items that are mechanical parts of its body.
    * Handles putting on both the leg and the eye.
    * @param item The item to put on (leg or eye).
    */
    public void putOn(Item item) {
        if (this.inventory.contains(item)) {
            if (item.name.equalsIgnoreCase("leg")) {
                System.out.println("You have put on the leg.");
                this.canWalk = true;
            } else if (item.name.equalsIgnoreCase("eye")) {
                System.out.println("You have put on the eye.");
                this.canInspect = true;
            } else {
                System.out.println("This item cannot be put on.");
            }
        } else {
        System.out.println("You don't have the " + item.name + " in your inventory yet. Take it first!");
    }
}

    /**
     * The robot can electrocute the human and make the human fall unconscious
     */
    public void electrocute(Human h) {
        h.isUnconscious = true;
        System.out.println("You electrocuted " + h.name + " and he temporarily fall unconscious.");
    }
}
