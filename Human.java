public class Human extends Existence {
    // Attributes


    // Constructor

    /**
     * Default constructor for 'Human'
     * @param name
     * @param health
     * @param isAlive
     */
    public Human(String name, int health,  Boolean isAlive) {
        super(name, health, isAlive);
    }


    // Methods
    

    // To overload
    /**
     * User fights another existence
     */
    public void fight(Robot e, int times) {
        for(int i = 0; i <= times; i++) {
            this.health -= 20;
            System.out.println("I am fighting!");
        }
            System.out.println("I am so tired, but I can keep going!");


    }


    // To override
}
