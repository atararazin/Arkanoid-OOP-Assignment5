package arkanoidelements;

import java.util.ArrayList;
import java.util.List;

import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import genericgameelements.AnimationRunner;
import individuallevels.DirectHitLevel;
import individuallevels.LevelInformation;
import individuallevels.RainbowLevel;
import individuallevels.SpaceshipLevel;
import individuallevels.SunshineLevel;

/**
 * The main class, receives the levels are arguments. If the user doesnt give any arguments,
 * then play the default, 1,2,3,4. 1 - DirectHit,2 - Sunshine, 3 - Rainbow, 4 - Spaceship.
 *
 * @author Benjy Berkowicz & Atara Razin
 *
 */
public class Ass5Game {
    /**
     * The mainline, receives the levels as command line arguments.
     *
     * @param args
     *            unused commandline arguments.
     */
    public static void main(String[] args) {
        //makes the gui
        GUI gui = new GUI("Arkanoid - Batara Berkorazin", GameLevel.maxWidth(), GameLevel.maxHeight());
        KeyboardSensor keyboard = gui.getKeyboardSensor();
        Sleeper sleeper = new Sleeper();
        AnimationRunner runner = new AnimationRunner(gui, sleeper, 60);
        GameFlow game = new GameFlow(runner, keyboard);

        //creates a new List of LevelInformations and adds all four possible levels to it.
        List<LevelInformation> levelsToBePlayed = new ArrayList<LevelInformation>();
        List<LevelInformation> levels = new ArrayList<LevelInformation>();
        levels.add(new DirectHitLevel());
        levels.add(new SunshineLevel());
        levels.add(new RainbowLevel());
        levels.add(new SpaceshipLevel());

        if (args.length == 0) {
            //add the levels to the list in order 1,2,3,4
            for (LevelInformation lev : levels) {
                levelsToBePlayed.add(lev);
            }
        } else {
            //runs through every argument
            for (String argument : args) {
                try {
                    int num = Integer.parseInt(argument);
                    //checks if they are valid levels
                    if (num <= 3 && num >= 0) {
                        //adds them to the list
                        levelsToBePlayed.add(levels.get(num));
                    }
                } catch (NumberFormatException n) {
                    System.out.println("unexpected error");
                    // Don't add anything to the list
                }
            }
        }
        //run the levels
        game.runLevels(levelsToBePlayed);
        //closes the gui
        gui.close();
    }
}