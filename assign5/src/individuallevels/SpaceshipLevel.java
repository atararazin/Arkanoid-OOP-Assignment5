package individuallevels;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import arkanoidelements.Block;
import arkanoidelements.Velocity;
import genericgameelements.Sprite;
import shapes.Point;
import shapes.Rectangle;

/**
 * The spaceship level involves drawing a spaceship and shooting the stars.
 * @author Benjy Berkowicz
 * @author Atara Razin
 *
 */
public class SpaceshipLevel implements LevelInformation {

    /**
     * The number of balls to draw.
     * @return number of balls
     */
    @Override
    public int numberOfBalls() {
        return 4;
    }

    /**
     * The ball velocities.
     * @return a list of the ball velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> returnList = new ArrayList<Velocity>();
        returnList.add(Velocity.fromAngleAndSpeed(20, 1.5));
        returnList.add(Velocity.fromAngleAndSpeed(45, 1.5));
        returnList.add(Velocity.fromAngleAndSpeed(60, 1.5));
        returnList.add(Velocity.fromAngleAndSpeed(73, 1.5));
        return returnList;
    }

    /**
     * The paddle speed.
     * @return the paddle speed.
     */
    @Override
    public int paddleSpeed() {
        return 5;
    }

    /**
     * The width of the paddle.
     * @return the width of the paddle
     */
    @Override
    public int paddleWidth() {
        return 250;
    }

    /**
     * The name of the level.
     * @return the name of the level
     */
    @Override
    public String levelName() {
        return "Spaceship Level";
    }

    /**
     * The background of the game, in this case, the spaceship background.
     * @return the spaceship sprite.
     */
    @Override
    public Sprite getBackground() {
        return new SpaceshipBackground();
    }

    /**
     * A list of the blocks, sporadically placed.
     * @return a list of blocks.
     */
    @Override
    public List<Block> blocks() {
        List<Block> returnBlock = new ArrayList<Block>();
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(45, 95));
        points.add(new Point(150, 330));
        points.add(new Point(680, 165));
        points.add(new Point(630, 510));
        points.add(new Point(320, 510));
        points.add(new Point(335, 220));

        // Loops through the points and places them as identically sized blocks
        for (Point p : points) {
            Rectangle rect = new Rectangle(p, 25, 25);
            Block b = new Block(rect, 1, Color.WHITE);
            returnBlock.add(b);
        }

        return returnBlock;
    }

    /**
     * The number of blocks to remove is all of the blocks.
     * @return the number of blocks to rermove
     */
    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }

}
