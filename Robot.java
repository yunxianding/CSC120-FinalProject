import java.util.ArrayList;

/**
 * The Robot class extends Existence class and has the unique method of electrocute human
 */
public class Robot extends Existence {

    //Attributes
    public Boolean poweredOn;
    public Boolean reasoningOn;
    public Boolean memoryOn;

    /**
     * Default constructor for 'Human'
     * @param name
     * @param health
     * @param isAlive
     */
    public Robot(String name, Room room, Boolean isAlive, Boolean canGoToLab, Boolean canWalk, Boolean canInspect) {
        super(name, room);
        this.isAlive = true;
        this.health = 100; // Robot has less health than human.
        this.inventory = new ArrayList<Item>();
        this.canGoToLab = false; // Will unlock after achieving the first four tasks in stage 1
        this.canWalk = false; // Will unlock after adding leg to the body
        this.canInspect = true; // Will unlock after adding eye to the body
        this.poweredOn = true; // Will be able to turn off after unlocking the control panel
        this.reasoningOn = false; // Will be able to turn on after unlocking the control panel
        this.memoryOn = false; // Will be able to turn on after unlocking the control panel
    }
    
    // Methods
    /**
     * The robot can put on items that are mechanical parts of its body
     * @param item s
     */
    public void putOn(Item s) {
        if (this.inventory.contains(s) && s.canBePutOn == true) {
            System.out.println("You have put on " + s.getName() + ".");
            this.inventory.remove(s);
        } else {
            System.out.println("INVALID COMMAND");
        }

    /**
     * The robot can electrocute the human and make the human fall unconscious
     */
    public void electrocute(Human h) {
        h.isUnconscious = true;
        System.out.println(h.getName() + " is temporarily unconscious.");
    }

    // To overload

    // To override

    

}
