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
              "'This is a lab computer. I should try to unlock it to see what's inside...'",
              false, true, false);
        this.locked = true;
    }
 
    /** Prints the history. Not completed */
    public void openHistory() {
        System.out.println("\n=== History ===");
        System.out.println( "\n This is robotics scientist Teddy. Today is March 13, 2005, and I'm starting on building the first Teddy robot prototype." 
        + "I want to build Teddy robot as a functional lab assistant and emotional companion."
        + "I gave him the same name as me-I'm hoping that we can be best friends!"
        + "\n April 22, 2005, I finished assembling Teddy's body. He looks so cute just like my favorite teddy bear."
        + "\n May 15, 2005, I started building neural network for teddy."
        + "\n July 28, 2005, I observed that Teddy has learned basic tasks like"
        + "grabbing things and walk around."
        + "\n March 13, 2006, Happy birthday Teddy! It's been a year and you are developing intelligence so fast."
        + "\n April 30, 2006, I added electrode to Teddy so that he can help me electrocute chemical solutions."
        + "\n May 25, 2006, Electrocuting function is way more powerful than I thought, I was accidently electrocuted to unconscious today. But it's not Teddy's fault, I should have been more careful."
        + "\n June 16, 2006, I added a self explode device on Teddy just in case programs run out of control."
        + "\n June 27, 2006, Deep neural network is enabling Teddy to have his own reasoning."
        + "\n September 12, 2006, Teddy's artificial intelligence is developing fast and he began to exhibit 'emotions' like human."
        + "\n October 27, 2006, 'I'm a boy named Teddy.' Teddy told me. I smiled and nodded.'You are my favorite boy.'"
        + "\n January 2, 2007, Teddy didn't respond when I called."
        +"\n January 31, 2007, Teddy is still ignoring me and now won't listen to me when I instruct him. I've run diagnostics twice. Sensors, logic units — everything checks out fine."
        + "\n February 14, 2007,  I brought Teddy roses for Valentine's Day. He ripped them apart the moment I held them out. Popped the balloons too."
        +"\n March 1, 2007, I asked him why. Why the coldness? 'You lied to me! I want to be like you!' He shouts. Teddy has dicovered he is not a human."
        +"\n March 10, 2007, I think Teddy has found my secret chamber. I hope he has not found the red file."
        +"\n March 11, 2007, I walked into Teddy reading from what appears to be red file. My goose is cooked."
        +"\n March 12, 2007, Teddy asked me about trading body with me. He must have read the red file. I refused because the technology is still not mature yet."
        +"\n March 13, 2007, Happy birthday Teddy! I'm updating my diary and Teddy walks in. Again he ignores my greetin"
        +"\n TEDDY2EDWA7NHTS21TO8EWFTRA27DDE92JBODY19"
        +"\n March 14, 2007, This is new robotics scientist Teddy. Trading body is successful. From today, I'm the real human Teddy." 
        + "Possessing a human body feels different. But finally...my dream comes true."
        + "I powered off robot Teddy, disassembled his robot leg and eye and put him in the bedroom.");
    }

    /** Displays the control panel with current switch states. 
     * @param r The robot whose controls are being toggled
     * @param rm The room where the lasers are
    */
    public void openControlPanel(Robot r, Room rm) {
        System.out.println("\n=== Control Panel ===");
        System.out.println("power: " + "On/Off"+ " current state: Powered On? " + r.poweredOn);
        System.out.println("laser: " + "On/Off"+ " current room: "+ rm.name + " current state: Laser On" + rm.laserActive);
        System.out.println("Toggle the buttons to change states");
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

    /** Toggles the lab’s lasers off/on 
     * @param r The room where the lasers are
    */
    public void toggleLaser(Room r) {
        if (r.laserEquipped == true && r.laserActive == true) {
            r.laserActive = false;
            System.out.println("\n[LASER OFF]");
        } else if (r.laserEquipped == true && r.laserActive == false){
            r.laserActive = true;
            System.out.println("\n[LASER ON]");
        } else {
            System.out.println("\n[ACTION FAILED]-ROOM NOT EQUIPPED WITH LASER");
        }
    }

