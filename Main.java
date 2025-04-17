/**
 * The Main class is where we implement all the classes and run the game
 */
public class Main {
    public static void main(String[] args) {

        //Create all the items needed
        Item bed = new Item("bed", "This is a bed.", false);
        Item teddyBear = new Item("teddyBear", "This looks like a toy. It feels soft.", true);
        Item firstSoul = new Item("firstSoul", "This is the first piece of my soul.", true);
        Item box = new Item("box", "This is a box. Seems like there is something inside.", false);
        Item leg = new Item("leg", "This looks like my leg. I'd better put it on to walk.", true);
        Item irisPot = new Item("irisPot", "This is a plantpot. Seems like there is something inside.", false);
        Item eye = new Item("eye", "This looks like my eye. I'd better put it on for better vision.", true);
        Item secondSoul = new Item("secondSoul","This is the second piece of my soul.", true);


        //Create the Bedroom
        Room bedroom = new Room("Bedroom", "This is a bedroom.", false);
        bedroom.addItem(bed);
        bedroom.addItem(teddyBear);
        bedroom.addItem(firstSoul);
        bedroom.addItem(box);
        bedroom.addItem(leg);
        bedroom.addItem(eye);
        bedroom.addItem(irisPot);

        //Create the Lab
        Room lab = new Room("Lab", "This is a lab.", true);
        lab.addItem(secondSoul); 
        //Remember to add the computer after Computer.java is finished
    }
}
