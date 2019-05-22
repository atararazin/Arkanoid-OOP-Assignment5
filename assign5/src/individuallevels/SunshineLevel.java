package individuallevels;

import java.util.ArrayList;

import java.util.List;

import arkanoidelements.Block;
import arkanoidelements.GameLevel;
import arkanoidelements.Velocity;
import genericgameelements.Sprite;
import shapes.Point;
import shapes.Rectangle;

/**
 * gets the information about the sunshine level. the name, paddle width and speed, number of balls,
 * initial velocity of the balls, background, block and number of blocks to remove
 * @author Atara Razin
 * @author Benjy Berkowicz
 * AKA Batara Berkorazin
 */
public class SunshineLevel implements LevelInformation {

    /**
     * @return the number of balls
     */
    @Override
    public int numberOfBalls() {
        return 10;
    }

    /**
     * Creates the initial velcity of each ball and returns it in a list.
     * @return List of Velocitys
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> listOfVel = new ArrayList<Velocity>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Velocity v = Velocity.fromAngleAndSpeed(40, 7);
            listOfVel.add(v);
        }
        return listOfVel;
    }

    /**
     * @return paddle speed
     */
    @Override
    public int paddleSpeed() {
        return 30;
    }

    /**
     * @return paddle width
     */
    @Override
    public int paddleWidth() {
        return 250;
    }

    /**
     * @return level name
     */
    @Override
    public String levelName() {
        return "Sunshine Level";
    }

    /**
     * gets the background.
     * @return the background
     */
    @Override
    public Sprite getBackground() {
        return new SunshineBackground();
    }

    /**
     * makes a list of Blocks and their positions and thier number of hitpoints.
     * @return the list of Blocks.
     */
    @Override
    public List<Block> blocks() {
        List<Block> listOfBlocks = new ArrayList<Block>();
        int topXPos = 10;
        int topYPos = GameLevel.maxHeight() / 3;
        int maxWidth = 78;
        for (int i = 0; i < 10; i++) {
            Point upperLeft = new Point(topXPos + (i * maxWidth), topYPos);
            Rectangle rect = new Rectangle(upperLeft, 78, 20);
            Block block = new Block(rect, 1, GameLevel.colorArray().get(i % 7));
            listOfBlocks.add(block);
        }
        return listOfBlocks;
    }

    /**
     * @return the number of blocks necessary to remove in order to move up to the next level
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 10;
    }
}