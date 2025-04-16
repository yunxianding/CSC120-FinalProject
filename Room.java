/**
 * The Room class is an abstract base class that provides a template
 * for all room types in the adventure game. Each room should implement
 * its own ways to describe itself and to process player commands.
 */
public abstract class Room {
    
    // A basic description of the room
    public String description;

    public Room() {
        description = "An undefined space.";
    }

    /**
     * Returns the description of the room.
     * 
     * @return A String describing the room.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Allows setting a description for the room.
     * 
     * @param description The description string to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method should print out the description and visible items
     * or aspects of the room based on the game state.
     */
    public abstract void describe();

    /**
     * Handles a command input by the player, such as "look" or "take toolbox".
     * Each subclass must implement command processing relevant to that room.
     *
     * @param cmd The command input by the player.
     */
    public abstract void handleCommand(String cmd);

}