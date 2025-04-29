import java.util.ArrayList;
import java.util.List;

/**
 * The Room class represents a typical room that has a name, decription
 * and a list of items.
 * We currently have two rooms in our game: a bedroom and a lab.
 */
public class Room {
    
    // Attributes
    public String name = "<Name Unknown>";
    public String description = "<Description Unknown>";
    public Boolean laserEquipped;
    public Boolean laserActive;
    public List<Item> itemsInRoom;

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
        this.itemsInRoom = new ArrayList<>();
    }

    /**
     * Add an item to the items arraylist
     */
    public void addItem(Item item) {
        if (item != null) {
            itemsInRoom.add(item);
        }
    }

    /**
     * Remove an item from the items arraylist
     */
    public void removeItem(Item item) {
        if (item != null) {
            itemsInRoom.remove(item);
        }
    }
}
