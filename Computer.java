/**
 * Represents the lab computer with two folders (History & Control Panel)
 * and a set of toggleable controls.
 */
public class Computer extends Item {

    // locked until the player unlocks it
    private boolean locked;
    // control panel states
    private boolean reasoning;   // default off
    private boolean power;       // default on
    private boolean memory;      // default off
    private boolean laser;       // default on

    /**
     * Constructor
     */
    public Computer() {
        super("computer",
              "A lab computer with two folders: History and Control Panel.",
              false);
        this.locked    = true;
        this.reasoning = false;
        this.power     = true;
        this.memory    = false;
        this.laser     = true;
    }

    /** Unlocks the computer so folders can be accessed. */
    public void unlock() {
        if (this.locked == true) {
            this.locked = false;
            System.out.println("\nYou hear a click—the computer is now unlocked. Two folders appear: History and Control Panel.");
        } else {
            System.out.println("\nThe computer is already unlocked.");
        }
    }

    /**
     * Clicks on one of the two folders.
     * @param folderName either "history" or "control"
     */
    public void clickFolder(String folderName) {
        if (this.locked == true) {
            System.out.println("\nThe computer is locked. You need to unlock it first.");
        }
        switch (folderName.toLowerCase()) {
            case "history":
                openHistory();
                break;
            case "control":
            case "control panel":
                openControlPanel();
                break;
            default:
                System.out.println("\nNo such folder. Try \"History\" or \"Control\".");
        } 
    }

    /** Prints the history. Not completed */
    private void openHistory() {
        System.out.println("\nHistory: \n Today, April 13, 2005, I created the first Teddy prototype. This is looking great, I’m hoping that we can be best friends!");
    }

    /** Displays the control panel with current switch states. */
    private void openControlPanel() {
        System.out.println("\n=== Control Panel ===");
        System.out.println("Reasoning: " + (this.reasoning ? "On" : "Off"));
        System.out.println("Power: " + (this.power ? "On" : "Off"));
        System.out.println("Memory: " + (this.memory ? "On" : "Off"));
        System.out.println("Laser: " + (this.laser ? "On" : "Off"));
        System.out.println("TradeBody: " + "(Restricted)");
        System.out.println("SelfDestruct: " + "(Restricted)");
    }

    /** Toggles reasoning on; cannot be turned off once on. */
    public void toggleReasoning() {
        if (this.reasoning == false) {
            this.reasoning = true;
            System.out.println("\nReasoning is now On. I can think more clearly.");
        } else {
            System.out.println("\nIt's better for me to have reasoning abilities.");
        }
    }

    /** Attempts to toggle power off/on; power must remain on. */
    public void togglePower() {
        System.out.println("\nI need power On to function.");
    }

    /** Toggles memory restoration on; cannot be turned off once on. */
    public void toggleMemory(Existence e, Item s) {
        if (this.memory == false) {
            this.memory = true;
            System.out.println("\nI'm starting to remember things...\n [ACHIEVEMENT UNLOCKED] You have unlocked the second piece of your soul.");
            e.take(s); // Add the soul piece to player's inventory.
            if(this.reasoning == false) {
                System.out.println("\nI don't understand what these memories mean... How can I understand it?");
            }
            else if (this.reasoning == true) {
                System.out.println("\nHmmm... \nThis is MY memory! I AM Teddy!\n [ACHIEVEMENT UNLOCKED] You found out about your true identity.\n Truth is: You used to be a scientist, who tried to make a robot called Teddy, but it outsmarted you and has traded bodies with you. Go get your body back!");
            }

        } else {
            System.out.println("\nI don’t want to delete these valuable memories!");
        }
    }

    /** Toggles the lab’s lasers off; cannot be turned on again. */
    public void toggleLaser() {
        if (this.laser == true) {
            this.laser = false;
            System.out.println("\nLaser is now Off. The path to the lab is clear.");
        } else {
            System.out.println("\nI’d better keep the laser Off for my own safety.");
        }
    }

    /**
     * Attempt to trade bodies between two existences.
     * Always prints restriction because no second existence present.
     */
    public void tradeBody(Existence e1, Existence e2) {
        System.out.println("\nYou can only trade bodies if there is at least another existence present.");
    }

    /**
     * Attempts self-destruction. Only a human operator may trigger it.
     * @param operator the one pressing the button
     * @param robot the robot body to destroy
     */
    public void selfDestruct(Human operator, Robot toBeDestroyed) {
        System.out.println("\nSelf-destruct sequence initiated! Boom!");
        toBeDestroyed.die();
    }

    /**
     * (Overloaded) Robot tries to destroy another Robot
     * @param operator
     * @param toBeDestroyed
     */
    public void selfDestruct(Robot operator, Robot toBeDestroyed) {
        throw new RuntimeException("\nFAILED: A robot cannot do that to another robot.");
    }

    /**
     * (Overloaded)Robot tries to destroy a Human
     * @param operator
     * @param toBeDestroyed
     */
    public void selfDestruct(Robot operator, Human toBeDestroyed) {
        throw new RuntimeException("\nFAILED: Only a human can do this to a robot.");
    }

    
}
