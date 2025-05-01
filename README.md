# CSC120-FinalProject-Teddy Bot🤖
## Contributors: Clare, Joyce, Tammy, Yunxian

## Deliverables CheckList: 🚧(in construction) ☑️(finished)
 - Your final codebase 🚧
 - Your revised annotated architecture diagram 🚧
 - Design justification (including a brief discussion of at least one alternative you considered) 🚧
 - A map of your game's layout (if applicable) 🚧
 - `cheatsheet.md` 🚧
 - Completed `rubric.md` 🚧

## Design Justification 🚧
Our game centers around a scientist named Teddy who creates a humanoid robot named Teddy in hopes of building a lifelong companion. The story unfolds in two main rooms: a bedroom and a laboratory, and begins after a major twist has already occurred — the robot has traded bodies with its creator.

The player begins the game as Teddy the scientist, now trapped in a robot's body, waking up disoriented and damaged — missing a leg and an eye. The player must recover these parts in the bedroom, then navigate the lab's laser-filled corridors to reach the computer, which reveals the diary history of how things went wrong.

Through this exploration, the player gradually discovers the truth: Teddy the robot developed reasoning, memory, and a desire to become human — ultimately betraying his creator. The player, now inhabiting the robot shell, is faced with a final moral decision: forgive or seek revenge. Forgiveness ends the game peacefully, while revenge triggers a final showdown in which the player must disable the robot and reclaim their body.

**Why This Design?**

We wanted the design to feel like an adventure puzzle wrapped inside a sci-fi short story, where gameplay and narrative are deeply connected — and the player slowly realizes they’re not just fixing a robot, they’re reclaiming a stolen identity.

In Stage 1, the physical repairs symbolize the first step toward regaining control. You’re not just putting on a leg or an eye — you’re beginning to piece together a self that’s been shattered.

In Stage 2, interacting with the control panel isn’t just mechanical. Turning on reasoning and memory becomes symbolic of reclaiming your humanity — you start thinking critically, recalling the past, and questioning your reality.

By the time you reach Stage 3, the final confrontation forces a moral choice: forgive or destroy. This moment shifts from being purely about mechanics to letting the player shape the outcome of the story. If they choose to forgive, it’s a calm resolution — a reflection of empathy and closure. But if they choose revenge, the game becomes more intense and action-driven. They get to fight the robot, face resistance, and ultimately electrocute it to reclaim their body. That path adds tension and excitement, making the gameplay feel dynamic and rewarding.

**Alternative Considered:**

One alternative idea we brainstormed early on involved implementing a Soul class. The concept was that Teddy’s human soul had been fragmented and scattered after the body swap. The player would collect these soul fragments throughout the game, and each soul would unlock parts of Teddy's memory and personality. This would create a longer, more exploratory experience that tied achievements to emotional growth. Unfortunately, due to time constraints, we were unable to fully implement this mechanic — but it remains one of our favorite unbuilt ideas.

## Layout Map 🚧
![Teddy Bot Layout Map](./Image/layout%20map.jpg)
Figure 1: Visual layout of the Teddy Bot Adventure game 


## Additional Reflection Questions
 1. Our **overall approach** to tackling this project is coming up with a game plot first, then write the possible classes we need and their possible interations. After finishing the draft of the classes, we implement them in `Main.java` and write the game loop. 🕹️
 2. We definitely learned so much **new thing(s)** in completing this project: 🤩
    * We learned about contructing an architecture diagram;
    * We learned about working how to effectively use Github for team projects;
    * We learned about how to implement a game loop;
 3. However, there are still many things we wish we had **implemented differently**: 👾
    * We wish we had implemented a `Soul` class and it would be an adventure of collecting the scattered souls along the way;
    * We wish we had implemented a puzzle that players need to solve before they are able to unlock the computer;
    * We wish we had implemented a display bar that displays the player's health bar and a help page that shows the commands available at each stage;
 4. If we had **unlimited time**, we would implement these additional features: 🧸
    * Add more rooms so that it will be a longer adventure;
    * Make more commands available;
 5. The most helpful **piece of feedback** we received: 🚧
    * "Yunxian":  The most useful feedback I got is from Tammy. She told me we can use `switch-case` instead of many `if-else`statements in the main game loop. 
 6. If we could go back in time and give our past selves some **advice** about this project, we would give these tips: 😃
    * Start Small! We came up with so many good ideas but it's hard to implement all of them into our game, so we are abandoing ideas along the way. It could be frustrated if we have a very complicated storyline in our mind but we can't bring them to real life due to limited time.
    * Take advantage of github! Some features like opening an issue and assign people to work on it/ work on separate branches and merge later/reviewing each other's commit messages could be really useful working in a team!
 7. Our **team dynamics** really had a huge impact on our overall experience working on this project! Everyone was very devoted to our project and we learned so much new things, fixed so many problems together. It's very helpful to have our weekly meeting as we discuss what we've been doing throughout the week and we help each other out.🥰
