import java.util.ArrayList;
import java.util.List;

/**
 * The Room class represents a typical room that has a name, decription
 * and a list of items.
 * We currently have two rooms in our game: a bedroom and a lab.
 */
public class Room {
    
    // Attributes
    private String name = "<Name Unknown>";
    private String description = "<Description Unknown>";
    public Boolean laserEquipped;
    public Boolean laserActive;
    private List<Item> items;

    /* Default Constructor */
    public Room(String name, String description, Boolean laserEquipped, Boolean laserActive){
        if (name != null){
            this.name = name;
        }
        if (description != null){
            this.description = description;
        }
        this.laserEquipped = laserEquipped;
        this.laserActive = laserActive;
        this.items = new ArrayList<>();
    }

    /**
     * Accessor for the name of the room
     * @return name of the room
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for the description of the room
     * @return description of the room
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Add an item to the items arraylist
     */
    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    /**
     * Remove an item from the items arraylist
     */
    public void removeItem(Item item) {
        if (item != null) {
            items.remove(item);
        }
    }

    /**
     * Accessor for the items arraylist
     */
    public List<Item> getItems() {
        return items;
    }
}
