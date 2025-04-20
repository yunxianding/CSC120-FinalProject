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
        if (locked) {
            locked = false;
            System.out.println("You hear a click—the computer is now unlocked. Two folders appear: History and Control Panel.");
        } else {
            System.out.println("The computer is already unlocked.");
        }
    }

    /**
     * Clicks on one of the two folders.
     * @param folderName either "history" or "control"
     */
    public void clickFolder(String folderName) {
        if (locked) {
            System.out.println("The computer is locked. You need to unlock it first.");
            return;
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
                System.out.println("No such folder. Try \"History\" or \"Control\".");
        } 
    }

    /** Prints the history. Not completed */
    private void openHistory() {
        System.out.println("Today, April 13, 2005, I created the first Teddy prototype. This is looking great, I’m hoping…");
    }

    /** Displays the control panel with current switch states. */
    private void openControlPanel() {
        System.out.println("=== Control Panel ===");
        System.out.println("Reasoning: " + (reasoning ? "On" : "Off"));
        System.out.println("Power: " + (power ? "On" : "Off"));
        System.out.println("Memory: " + (memory ? "On" : "Off"));
        System.out.println("Laser: " + (laser ? "On" : "Off"));
        System.out.println("TradeBody and SelfDestruct are present but restricted.");
    }

    /** Toggles reasoning on; cannot be turned off once on. */
    public void toggleReasoning() {
        if (!reasoning) {
            reasoning = true;
            System.out.println("Reasoning is now On. I can think more clearly.");
        } else {
            System.out.println("It's better for me to have reasoning abilities.");
        }
    }

    /** Attempts to toggle power off/on; power must remain on. */
    public void togglePower() {
        System.out.println("I need power On to function.");
    }

    /** Toggles memory restoration on; cannot be turned off once on. */
    public void toggleMemory() {
        if (!memory) {
            memory = true;
            System.out.println("Seems like I don’t have any memories. I need to restore them.");
        } else {
            System.out.println("I don’t want to delete these valuable memories!");
        }
    }

    /** Toggles the lab’s lasers off; cannot be turned on again. */
    public void toggleLaser() {
        if (laser) {
            laser = false;
            System.out.println("Laser is now Off. The path to the lab is clear.");
        } else {
            System.out.println("I’d better keep the laser Off for my own safety.");
        }
    }

    /**
     * Attempt to trade bodies between two existences.
     * Always prints restriction because no second existence present.
     */
    public void tradeBody(Existence e1, Existence e2) {
        System.out.println("You can only trade bodies if there is at least another existence present.");
    }

    /**
     * Attempts self-destruction. Only a human operator may trigger it.
     * @param operator the one pressing the button
     * @param robot the robot body to destroy
     */
    public void selfDestruct(Existence operator, Existence robot) {
        if (operator instanceof Human) {
            System.out.println("Self-destruct sequence initiated! Boom!");
            robot.die();
        } else {
            System.out.println("This button is for human use only.");
        }
    }
    
}
