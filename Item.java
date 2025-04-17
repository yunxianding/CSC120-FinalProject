/**
 * The Item class creates items we will use in the rooms.
 * Each item has a name, description and a status of whether can be grabbed.
 */
public class Item{

    //Attributes
    private String name;
    private String description;
    private Boolean canBeGrabbed;

    /* Default Constructor */
    public Item(String name, String description, Boolean canBeGrabbed){
        this.name = name;
        this.description = description;
        this.canBeGrabbed = canBeGrabbed;
    }

    /**
     * Accessor for item's name
     * @return name of the item
     */
    public String getName(){
        return this.name;
    }

    /**
     * Accessor for item's description
     * @return description of the item
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Accessor for item's status(whether it can be grabbed)
     * @return the status(whether it can be grabbed) of the item
     */
    public Boolean getItemStatus(){
        return this.canBeGrabbed;
    }
    
    /**
     * Main method that creates all the items
     */
    public static void main (String[] args){
        Item bed = new Item("bed", "This is a bed.", false);
        Item teddyBear = new Item("teddyBear", "This looks like a toy. It feels soft.", true);
        Item firstSoul = new Item("firstSoul", "This is the first piece of my soul.", true);
        Item box = new Item("box", "This is a box. Seems like there is something inside.", false);
        Item leg = new Item("leg", "This looks like my leg. I'd better put it on to walk.", true);
        Item irisPot = new Item("irisPot", "This is a plantpot. Seems like there is something inside.", false);
        Item eye = new Item("eye", "This looks like my eye. I'd better put it on for better vision.", true);
        Item secondSoul = new Item("secondSoul","This is the second piece of my soul.", true);
    }
}
