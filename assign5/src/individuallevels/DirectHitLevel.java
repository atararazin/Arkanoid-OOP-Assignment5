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
 * gets the information about the direct hit level. the name, paddle width and speed, number of balls,
 * initial velocity of the balls, background, block and number of blocks to remove
 * @author Atara Razin
 * @author Benjy Berkowicz
 * AKA Batara Berkorazin
 *
 */
public class DirectHitLevel implements LevelInformation {

    /**
     * @return the number of balls
     */
    @Override
    public int numberOfBalls() {
        return 1;
    }

    /**
     * Creates the initial velcity of each ball and returns it in a list.
     * @return List of Velocitys
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> listOfVel = new ArrayList<Velocity>();
        Velocity v = Velocity.fromAngleAndSpeed(0, 7);
        listOfVel.add(v);
        return listOfVel;
    }

    /**
     * @return paddle speed
     */
    @Override
    public int paddleSpeed() {
        return 20;
    }

    /**
     * @return paddle width
     */
    @Override
    public int paddleWidth() {
        return 190;
    }

    /**
     * @return level name
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * gets the background.
     * @return the background
     */
    @Override
    public Sprite getBackground() {
        return new TargetBackground();
    }

    /**
     * makes a list of Blocks and their positions and thier number of hitpoints.
     * @return the list of Blocks.
     */
    @Override
    public List<Block> blocks() {
        //each block has one hitpoint necessary for removal.
        int hitPoints = 1;
        int blockX = (GameLevel.maxWidth() / 2) - 20;
        int blockY = (GameLevel.maxHeight() / 3) - 20;
        Point topCorner = new Point(blockX, blockY);
        int width = 40;
        int height = 40;
        Rectangle newBlock = new Rectangle(topCorner, width, height);
        Block block = new Block(newBlock, hitPoints, java.awt.Color.RED);
        List<Block> listOfBlocks = new ArrayList<Block>();
        listOfBlocks.add(block);
        return listOfBlocks;
    }

    /**
     * @return the number of blocks necessary to remove in order to move up to the next level
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}