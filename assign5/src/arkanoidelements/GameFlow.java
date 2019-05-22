package arkanoidelements;

import java.util.List;

import biuoop.KeyboardSensor;
import genericgameelements.AnimationRunner;
import genericgameelements.Counter;
import genericgameelements.EndgameScreen;
import individuallevels.LevelInformation;

/**
 * controls the game flow, runs each level, checks if there are no lives and if enough
 * blocks have been destroyed. If we won, it prints the won screen.
 * @author Atara Razin
 * @author Benjy Berkowicz
 * AKA Batara Berkorazin
 *
 */
public class GameFlow {

    private AnimationRunner animation;
    private KeyboardSensor keyboard;
    private Counter livesCounter;
    private Counter scoreCounter;
    private boolean youWon;

    /**
     * constructor.
     * @param ar the animation
     * @param ks the keyboard sensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animation = ar;
        this.keyboard = ks;
        this.livesCounter = new Counter();
        this.scoreCounter = new Counter();
    }

    /**
     * Runs a series of provided levels (given in LevelInformation format), keeping track
     * of its endgame conditions, and terminating when they are reached.
     * @param levels a list of LevelInformations
     */
    public void runLevels(List<LevelInformation> levels) {
        //start the game with three lives
        this.livesCounter.increase(7);
        for (LevelInformation levelInfo : levels) {
            //creates the new level
            GameLevel level = new GameLevel(levelInfo, this.keyboard, this.animation, this.livesCounter,
                    this.scoreCounter);

            level.initialize();

            //plays the turn until either enough blocks have been removed or there are no lives left
            while ((this.livesCounter.getValue() > 0) && !level.destroyedEnoughBlocks()) {
                level.playOneTurn();
            }

            //break out of the loop if there are no lives left,meaning you lost
            if (this.livesCounter.getValue() <= 0) {
                break;
            }
        }

        // do the endgame screen
        this.youWon = this.livesCounter.getValue() > 0;
        this.animation.run(new EndgameScreen(this.keyboard, this.youWon, this.scoreCounter));
    }
}