import java.util.ArrayList;

/**
 * The Human class extends Existence class and has unique features of ???TO BE ADDED
 */
public class Human extends Existence {
    // Attributes
    public Boolean isUnconscious;

    // Constructor

    /**
     * Default constructor for 'Human'
     * @param name
     * @param room
     * @param isAlive
     * @param canGoToLab
     * @param canWalk
     * @param canInspect
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


    // Methods
    

    // To overload
    
    // To override
}
