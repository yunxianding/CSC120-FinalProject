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
        + "\n Today, September 12, 2006, Teddy's artificial intelligence is developing fast."
        + "\n Today, January 2, 2007, Teddy didn't respond when I called."
        +"\n Today, January 31, 2007, Teddy is still ignoring me and now won't listen to me when I instruct him. I've run diagnostics twice. Sensors, logic units — everything checks out fine."
        + "\n Today, February 14, 2007,  I brought Teddy roses for Valentine's Day. He ripped them apart the moment I held them out. Popped the balloons too."
        +"\n March 1, 2007, I finally asked him why. Why the coldness"
        +"\n 'I want to be like you!' He shouts. 'I want to be a human and not a robot!' I try conviencing him that there is no way that could happen but he gets more and more violent"
        +"\n Today, March 10, 2007, I walk into my Lab and find Teddy in my secret chamber. I'm gagged. 'I hope he has not found the red file'"
        +"\n I walk into Teddy reading from what appears to be red file. Oops! My goose is cooked."
        +"\n Teddy looks at me hysterically. That file contained all my notes about Teddy; how I had build him and how to make him human"
        +"\n 'Why?'Teddy asks.'Why did you lie to me?' 'Listen Teddy, the only way we can make you human is if we find another human whom you can trade bodies and souls with. Possible as it may sound, who will be willing to trade bodies and souls with a robot?'"
        +"\n Teddy throws the red file at me and storms out of the lab"
        +"\n I am in my bedroom, updating my diary. Teddy walks in"
        +"\n 'Hey Teddy!' Again he ignores my greeting. 'I'm sorry Teddy.'"
        +"\n 'Sorry for what?'I'm confused. Based on his approach, this looks like the last entry I shall make on this diary."
        +"\n Oh no! Dear diary, he is walking towards me; face oozing with anger. In case he knocks me out and trade bodies with me, I shall wake up eventually and get everything back. Till then goodbye"
        +"\n Teddy knocks the scientist down trades the body and soul. He places Teddy on a lab bench and disassembles his leg and eyes");
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
