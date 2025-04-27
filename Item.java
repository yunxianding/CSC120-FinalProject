/**
 * The Item class creates items we will use in the rooms.
 * Each item has a name, description and a status of whether can be grabbed.
 */
public class Item {

    //Attributes
    private String name;
    private String description;
    private Boolean canBeGrabbed;
    private Item containedItem;
    private Boolean canBeOpened;
    private Boolean canBePutOn;

    /* Default Constructor */
    public Item(String name, String description, Boolean canBeGrabbed, Boolean canBeOpened, Boolean canBePutOn) {
        this.name = name;
        this.description = description;
        this.canBeGrabbed = canBeGrabbed;
        this.containedItem = null;
        this.canBeOpened = false;
        this.canBePutOn = false;
    }

    /**
     * Accessor for item's name
     * @return name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for item's description
     * @return description of the item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Accessor for item's status(whether it can be grabbed/opened/put on)
     * @return the statusof the item
     */
    public String getItemStatus() {
        return ("Item status for " + this.getName() +
                "\n can be grabbed: " + this.canBeGrabbed +
                "\n can be opened: " + this.canBeOpened +
                "\n can be put on: " + this.canBePutOn);
    }

    /**
     * Accessor for canBeGrabbed
     * We wrote a separate accessor for this because it will be used in the grab method for existence
     */
    public Boolean getCanBeGrabbed() {
        return this.canBeGrabbed;
    }

    /**
     * Accessor for canBeOpened
     * We wrote a separate accessor for this because it will be use in the open method for existence
     */
    public Boolean getCanBeOpened() {
        return this.canBeOpened;
    }

    /**
     * Accessor for canBePutOn
     * We wrote a separate accessor for this because it will be used in the putOn method for robots
     */
    public Boolean getCanBePutOn() {
        return this.canBePutOn;
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
        } else {
            throw new RuntimeException("This item already contains another item.");
        }
    }
}