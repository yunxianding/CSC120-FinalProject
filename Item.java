/**
 * The Item class creates items we will use in the rooms.
 * Each item has a name, description and a status of whether can be grabbed.
 */
public class Item{

    //Attributes
    private String name;
    private String description;
    private Boolean canBeGrabbed;
    private Item containedItem;
    private Boolean canBeOpened;

    /* Default Constructor */
    public Item(String name, String description, Boolean canBeGrabbed){
        this.name = name;
        this.description = description;
        this.canBeGrabbed = canBeGrabbed;
        this.containedItem = null;
        this.canBeOpened = false;
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
     * Accessor for whether an item can be opened
     * @return whether the item can be opened(whether it contains another item)
     */
    public Boolean getCanBeOpened(){
        return this.canBeOpened;
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

    /**
     * Method for removing the stored item if the player interacts with the container item
     */
    public void removeItem(Item item){
        //To be constructed: if player takes it, remove the stored item
    }
}