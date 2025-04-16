import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bedroom extends Room {
    private Map<String, Item> items;
    private GameState state;

    public Bedroom(GameState state) {
        this.state = state;
        items = new HashMap<>();

        items.put("toolbox", new Item("toolbox", true, "A dusty toolbox lies on the floor."));
        items.put("box", new Item("box", false, "A small box sits against the wall."));
        items.put("broom", new Item("broom", false, "An old broom leans in a corner."));
        items.put("leg1", new Item("leg1", true, "A mechanical leg hidden inside the box."));
        items.put("leg2", new Item("leg2", true, "A mechanical leg hidden behind the broom."));
        items.put("eye", new Item("eye", true, "A glowing eye rests in an iris pot on the table."));
        items.put("teddyBear", new Item("teddyBear", true, "A well-loved teddy bear sits on the table."));
        items.put("door", new Item("door", false, "A sturdy door leads to the lab."));
    }

    @Override
    public void describe() {
        System.out.println("You awaken in a dusty, dimly lit bedroom.");
        if (!items.get("toolbox").isTaken()) {
            System.out.println(items.get("toolbox").getDescription());
        }
        System.out.println(items.get("box").getDescription());
        System.out.println(items.get("broom").getDescription());

        if (state.openedBox && !items.get("leg1").isTaken()) {
            System.out.println(items.get("leg1").getDescription());
        }
        if (state.lookedBehindBroom && !items.get("leg2").isTaken()) {
            System.out.println(items.get("leg2").getDescription());
        }
        if (state.canStand()) {
            if (!items.get("eye").isTaken()) {
                System.out.println(items.get("eye").getDescription());
            }
            if (!items.get("teddyBear").isTaken()) {
                System.out.println(items.get("teddyBear").getDescription());
            }
            System.out.println(items.get("door").getDescription());
        }
    }

    @Override
    public void handleCommand(String cmd) {
        if (cmd.equals("look") || cmd.equals("look around")) {
            describe();
        } else if (cmd.equals("take toolbox")) {
            takeItem("toolbox");
            state.hasToolbox = true;
        } else if (cmd.equals("open box")) {
            System.out.println("You open the box. Inside, you see a mechanical leg.");
            state.openedBox = true;
        } else if (cmd.equals("look behind broom")) {
            System.out.println("You move the broom aside. A mechanical leg is hidden behind it.");
            state.lookedBehindBroom = true;
        } else if (cmd.equals("take leg1")) {
            if (state.openedBox) {
                takeItem("leg1");
                state.hasLeg1 = true;
            } else {
                System.out.println("You don't see any leg. Try opening the box first.");
            }
        } else if (cmd.equals("take leg2")) {
            if (state.lookedBehindBroom) {
                takeItem("leg2");
                state.hasLeg2 = true;
            } else {
                System.out.println("You don't see any leg behind the broom.");
            }
        } else if (cmd.equals("attach legs")) {
            if (state.hasLeg1 && state.hasLeg2) {
                System.out.println("You attach both legs to your body. You can now stand up.");
                state.canStand = true;
            } else {
                System.out.println("You need both legs to attach them.");
            }
        } else if (cmd.equals("stand")) {
            if (state.canStand()) {
                System.out.println("You stand up. You can now reach the table.");
            } else {
                System.out.println("You can't stand without legs.");
            }
        } else if (cmd.equals("take eye")) {
            if (state.canStand()) {
                takeItem("eye");
                state.hasEye = true;
            } else {
                System.out.println("You can't reach the eye while crawling.");
            }
        } else if (cmd.equals("take teddyBear")) {
            if (state.canStand()) {
                takeItem("teddyBear");
                state.hasSoul = true;
                System.out.println("You feel a warm sensation. A piece of your soul has returned.");
            } else {
                System.out.println("The teddy bear is out of reach.");
            }
        } else if (cmd.equals("open door")) {
            if (state.readyForLab()) {
                System.out.println("You open the door and move into the lab.");
                state.setCurrentRoom("Lab");
            } else {
                System.out.println("You're not ready to leave the bedroom yet.");
            }
        } else {
            System.out.println("I don't understand that command.");
        }
    }

    private void takeItem(String name) {
        Item item = items.get(name);
        if (item != null && item.canBeGrabbed() && !item.isTaken()) {
            item.setTaken(true);
            System.out.println("You take the " + item.getName() + ".");
        } else {
            System.out.println("You cannot take that.");
        }
    }
    
    // For testing the Bedroom class.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameState gameState = new GameState();
        Bedroom bedroom = new Bedroom(gameState);
        
        System.out.println("Welcome to the Bedroom. Type commands to interact.");
        while (!gameState.isRoomChanged()) {
            System.out.print("> ");
            String command = scanner.nextLine();
            bedroom.handleCommand(command);
        }
        scanner.close();
    }
}