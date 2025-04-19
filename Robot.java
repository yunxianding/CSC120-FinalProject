public class Robot extends Existence {

    /**
     * Default constructor for 'Human'
     * @param name
     * @param health
     * @param isAlive
     */
    public Robot(String name, int health,  Boolean isAlive) {
        super(name, health, isAlive);
    }

    // Methods
    public void electrocute(Human h) {
        System.out.println(h.getName() + " is temporarily unconscious.");
    }

    // To overload

    // To override

    /**
     * User fights another existence
     */
    public void fight(Human h, int times) {
        for(int i = 0; i <= 3; i++) {
            this.health -= 20;
            System.out.println("I am fighting!");
        }
            System.out.println("I am so tired, maybe I need to try something else...");

    }
    
    

}
