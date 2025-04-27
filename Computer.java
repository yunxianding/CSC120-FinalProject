/**
 * The computer class represents the lab computer with two folders (History & Control Panel)
 * and a set of toggleable controls.
 */
public class Computer extends Item {

    // Attributes
    public boolean locked;

    /**
     * Constructor for computer
     */
    public Computer() {
        super("computer",
              "This is a lab computer with two folders: History and Control Panel.",
              false, true, false);
        this.locked = true;
    }
 
    /** Prints the history. Not completed */
    public void openHistory() {
        System.out.println("\nHistory: \n Today, April 13, 2005, I created the first Teddy prototype."
        + "This is looking great, I'm hoping that we can be best friends!"
        + "\n Today, May 15, 2005, I started building neural network for teddy."
        + "\n Today, July 28, 2005, I observed that Teddy has learned basic tasks like"
        + "grabbing things and walk around."
        + "\n Today, April 23, 2006, it's been a year and teddy seems to be developing intelligence."
        + "\n Today, June 27, 2006, deep neural network is a good idea!"
        + "\n Today, September 12, 2006, Teddy's artificial intelligence is developing fast." );
        // more history to be added!
        // added reasoning feature
        // implemented control panals
        // self-destroy
        // electrocute
        // trade body mechanism
    }

    /** Displays the control panel with current switch states. 
     * @param r The robot whose controls are being toggled
     * @param rm The room where the lasers are
    */
    public void openControlPanel(Robot r, Room rm) {
        System.out.println("\n=== Control Panel ===");
        System.out.println("\nReasoning: " + "On/Off" + "\nCurrent state: ReasoningOn?" + r.reasoningOn);
        System.out.println("Power: " + "On/Off"+ "\nCurrent state: PoweredOn?" + r.poweredOn);
        System.out.println("Memory: " + "On/Off"+ "\nCurrent state: MemoryOn?" + r.memoryOn);
        System.out.println("Laser: " + "On/Off"+ "\nCurrent room: "+ rm.getName() + "\nCurrent state: LaserOn?" + rm.laserActive);
        System.out.println("TradeBody: " + "RESTRICTED");
        System.out.println("SelfDestruct: " + "RESTRICTED");
    }


    /** Toggles reasoning on/off 
     * @param r The robot 
    */
    public void toggleReasoning(Robot r) {
        if (r.reasoningOn == false) {
            r.reasoningOn = true;
            System.out.println("\n[REASONING ON]");
        } else {
            r.reasoningOn = false;
            System.out.println("\n[REASONING OFF]");
        }
    }

    /** Attempts to toggle power off/on
     * @param r The robot 
    */
    public void togglePower(Robot r) {
        if (r.poweredOn == true) {
            r.poweredOn = false;
            System.out.println("\n[POWERED OFF]");
        } else {
            r.poweredOn = true;
            System.out.println("\n[POWERED ON]");
        }
    }

    /**
     * Toggles memory restoration on; cannot be turned off once on.
     * @param e The Existence whose memory is being toggled
     * @param s The Item being used to toggle the memory input
     */
    public void toggleMemory(Robot r) {
        if (r.memoryOn == false) {
            r.memoryOn = true;
            System.out.println("\n[MEMORIES ON] \nI'm starting to remember things...\n [ACHIEVEMENT UNLOCKED] You have unlocked the second piece of your soul.");
            if(r.reasoningOn == false) {
                System.out.println("\nI don't understand what these memories mean... How can I understand it?");
            } else if (r.reasoningOn == true) {
                System.out.println("\nHmmm... \nThis is MY memory! I AM Teddy!\n [ACHIEVEMENT UNLOCKED] You found out about your true identity.\n Truth is: You used to be a scientist, who tried to make a robot called Teddy, but it outsmarted you and has traded bodies with you. Go get your body back!");
            }
        } else {
            r.memoryOn = false;
            System.out.println("\n[MEMORIES OFF]");
        }
    }

    /** Toggles the lab’s lasers off/on 
     * @param r The room where the lasers are
    */
    public void toggleLaser(Room r) {
        if (r.laserEquipped == true && r.laserActive == true) {
            r.laserActive = false;
            System.out.println("\n[LASER OFF]");
        } else if (r.laserEquipped == true && r.laserActive == false){
            System.out.println("\n[LASER ON]");
        } else {
            System.out.println("\n[ACTION FAILED]-ROOM NOT EQUIPPED WITH LASER");
        }
    }

    /**
     * Attempt to trade bodies between two existences.
     * Always prints restriction because no second existence present.
     * @param e1 The first Existence
     * @param e2 The second Existence
     */
    public void tradeBody(Existence e1, Existence e2) {
        System.out.println("\nYou can only trade bodies if there is at least another existence present.");
        // TO be contructed!!
    }

    /**
     * Attempts self-destruction. Only a human operator may trigger it.
     * @param operator the one pressing the button
     * @param toBeDestroyed the robot body to destroy
     */
    public void selfDestruct(Human operator, Robot toBeDestroyed) {
        System.out.println("\nSelf-destruct sequence initiated! Boom!");
        toBeDestroyed.die();
    }

    /**
     * (Overloaded) Robot tries to destroy another Robot
     * @param operator the one pressing the button
     * @param toBeDestroyed the one being destroyed
     */
    public void selfDestruct(Robot operator, Robot toBeDestroyed) {
        throw new RuntimeException("\nFAILED: A robot cannot do that to another robot.");
    }

    /**
     * (Overloaded)Robot tries to destroy a Human
     * @param operator the one pressing the button
     * @param toBeDestroyed the one being destroyed
     */
    public void selfDestruct(Robot operator, Human toBeDestroyed) {
        throw new RuntimeException("\nFAILED: Only a human can do this to a robot.");
    }
}
