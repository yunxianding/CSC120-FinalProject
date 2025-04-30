/**
 * The Item class creates items we will use in the rooms.
 * Each item has a name, description and a status of whether can be grabbed.
 */
public class Item {

    //Attributes
    public String name;
    public String description;
    public Boolean canBeGrabbed;
    private Item containedItem;
    public Boolean canBeOpened;
    public Boolean canBePutOn;

    /* Default Constructor */
    public Item(String name, String description, Boolean canBeGrabbed, Boolean canBeOpened, Boolean canBePutOn) {
        this.name = name;
        this.description = description;
        this.canBeGrabbed = canBeGrabbed;
        this.containedItem = null;
        this.canBeOpened = canBeOpened;
        this.canBePutOn = canBePutOn;
    }

    /**
     * toString for Item's name
     * @return Item's name
     */
    public String toString(){
        return this.name;
    }

    /**
     * Accessor for item's status(whether it can be grabbed/opened/put on)
     * @return the statussof the item
     */
    public String getItemStatus() {
        return ("\n Item status for " + this.name +
                "\n can be grabbed: " + this.canBeGrabbed +
                "\n can be opened: " + this.canBeOpened +
                "\n can be put on: " + this.canBePutOn);
    }

    /**
     * Accessor for the item contained inside
     * @return the item contained inside
     */
    public Item getContainedItem(){
        return this.containedItem;
    }

    /**
     * Method for an item to store another item
     */
    public void storeItem(Item item){
        if (this.containedItem == null) {
            this.containedItem = item;
            this.canBeOpened = true;
        } 
    }
}