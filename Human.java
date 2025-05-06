import java.util.ArrayList;

/**
 * The Human class extends Existence class
 * It has unique attributes of boolean isUnconscious
 * It also has unique methods of initiating the self destruct program in a robot
 */
public class Human extends Existence {
    
    // Attributes
    public Boolean isUnconscious;

    // Constructor

    /**
     * constructor for Human
     * @param name the human's name
     * @param room the current location of the human
     * @param isAlive the human's life status
     * @param canGoToLab indicator for whether the human can go to lab
     * @param canWalk indicator for whether the human can walk
     * @param canInspect indicator for whether the human can inspect
     */
    public Human(String name, Room room, Boolean isAlive, Boolean canGoToLab, Boolean canWalk, Boolean canInspect) {
        super(name, room);
        this.isAlive = true;
        this.health = 1000; // Human has more health so that a robot can't fight over a human.
        this.inventory = new ArrayList<Item>();
        this.canGoToLab = true;
        this.canWalk = true;
        this.canInspect = true;
        this.isUnconscious = false;
    }

    /**
     * start the self-destruct program of the robot
     * @param r the robot body to destroy
     */
    public void destruct(Robot r) {
        System.out.println("\nSelf-destruct sequence initiated! Boom! " + r.name + "bot is gone forever.");
        r.die();
    }
}
