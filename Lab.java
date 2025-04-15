import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab extends Room {
    private Map<String, Item> items;
    private GameState state;

    public Lab(GameState state) {
        this.state = state;
        items = new HashMap<>();

        items.put("computer", new Computer("computer", false, "A computer with folders: History and Controls."));
        items.put("door", new Item("door", false, "A door you cannot open from inside."));
    }

    @Override
    public void describe() {
        if (!state.hasCrawled) {
            System.out.println("Bright lasers block the lab entrance. You must crawl in to avoid them.");
        } else {
            System.out.println("You are in the lab. Equipment surrounds you. A computer catch your eye.");
            System.out.println(items.get("computer").getDescription());
            System.out.println(items.get("door").getDescription());
        }
    }

    @Override
    public void handleCommand(String cmd) {
        if (cmd.equals("look") || cmd.equals("look around")) {
            describe();
        } else if (cmd.equals("crawl")) {
            state.hasCrawled = true;
            System.out.println("You safely crawl into the lab, avoiding the lasers.");
        } else if (cmd.equals("walk")) {
            if (!state.hasCrawled) {
                System.out.println("You walk into the laser. You are vaporized. Game over.");
                state.gameOver = true;
            } else {
                System.out.println("You walk further into the lab.");
            }
        } else if (cmd.equals("inspect teddyBear")) {
            if (state.hasSoul) {
                System.out.println("You inspect the teddy bear closely and find a tag stitched with the number: 1234.");
                state.passwordRevealed = true;
            } else {
                System.out.println("You don’t have the teddy bear with you.");
            }
        } else if (cmd.equals("use computer") || cmd.equals("unlock computer")) {
            if (state.passwordRevealed) {
                System.out.println("You unlock the computer. There are two folders: History and Controls.");
            } else {
                System.out.println("The computer is locked. Maybe something you’re carrying has a clue?");
            }
        } else if (cmd.equals("click history")) {
            System.out.println("You open the History folder. It speaks of Teddy’s creation in 2005.");
            state.historyRead = true;
        } else if (cmd.equals("click controls")) {
            System.out.println("Controls folder contains switches: Reasoning, Memory, Power, Laser.");
        } else if (cmd.equals("toggle reasoning")) {
            if (!state.reasoningOn) {
                state.reasoningOn = true;
                System.out.println("You turn on reasoning: 'It's better for me to have reasoning abilities.'");
            } else {
                System.out.println("Reasoning is already on.");
            }
        } else if (cmd.equals("toggle laser")) {
            state.laserOn = !state.laserOn;
            System.out.println("You toggle the lasers " + (state.laserOn ? "on" : "off") + ".");
        } else {
            System.out.println("I don't understand that command.");
        }
    }

    // For testing the Lab class.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameState gameState = new GameState();
        Lab lab = new Lab(gameState);
        
        System.out.println("Welcome to the Lab. Type commands to interact.");
        while (!gameState.gameOver) {
            System.out.print("> ");
            String command = scanner.nextLine();
            lab.handleCommand(command);
        }
        scanner.close();
    }
}