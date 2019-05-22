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
 * Rainbow level draws a rainbow with blocks.
 *
 * @author Benjy Berkowicz
 * @author Atara Razin
 *
 */
public class RainbowLevel implements LevelInformation {

    /**
     * The number of balls for the level.
     *
     * @return number of balls
     */
    @Override
    public int numberOfBalls() {
        return 3;
    }

    /**
     * The ball velocities.
     *
     * @return a list of the ball velocities
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocList = new ArrayList<Velocity>();
        velocList.add(Velocity.fromAngleAndSpeed(30, 6));
        velocList.add(Velocity.fromAngleAndSpeed(75, 5));
        velocList.add(Velocity.fromAngleAndSpeed(55, 4));
        return velocList;
    }

    /**
     * The speed of the paddle.
     *
     * @return the paddle speed
     */
    @Override
    public int paddleSpeed() {
        return 8;
    }

    /**
     * The width of the paddle.
     *
     * @return the paddle width
     */
    @Override
    public int paddleWidth() {
        return 140;
    }

    /**
     * The name of the level.
     *
     * @return the level name
     */
    @Override
    public String levelName() {
        return "Rainbow Level";
    }

    /**
     * The background of the level, in this case the rainbow background.
     *
     * @return the rainbow background
     */
    @Override
    public Sprite getBackground() {
        return new RainbowBackground();
    }

    /**
     * A list of all the blocks, arranged as two arcs.
     *
     * @return a list of the blocks
     */
    @Override
    public List<Block> blocks() {

        List<Block> blockList = new ArrayList<Block>();
        Block tempBlock;
        Rectangle tempRectangle;
        Point tempPoint;

        // Intialize the constants
        double baseX = 380;
        double baseY = 410;
        int width = 50;
        int height = 20;
        double radius = 5 * (1.2 * width);
        double deltaAngle;

        // The rainbow consists of seven colours, decremented each time by
        // decreasing the size of the radius
        for (int i = 7; i > 0; i--) {

            // Only the outmost blocks of the rainbow have 2 hitpoints
            int hitPoints = 1 + (int) Math.floor(i / 7);

            deltaAngle = 180 / (i * 2);

            // The right side of the arc of the rainbow
            double calculatedAngle = 0;
            int extraBlock = (int) Math.floor(i / 3);
            for (int j = i + extraBlock; j > 0; j--) {
                int finalX = (int) (baseX + Math.abs(Math.cos(Math.toRadians(calculatedAngle)) * radius));
                int finalY = (int) (baseY - Math.abs(Math.sin(Math.toRadians(calculatedAngle)) * radius));
                tempPoint = new Point(finalX, finalY);
                tempRectangle = new Rectangle(tempPoint, width, height);
                tempBlock = new Block(tempRectangle, hitPoints, GameLevel.colorArray().get(i - 1));
                blockList.add(tempBlock);

                calculatedAngle += deltaAngle;
            }

            // The left side of the arc of the rainbow
            extraBlock = (int) Math.floor(i / 5);
            calculatedAngle = 0;
            for (int j = i + extraBlock; j > 0; j--) {
                int finalX = (int) (baseX - Math.abs(Math.cos(Math.toRadians(calculatedAngle)) * radius));
                int finalY = (int) (baseY - Math.abs(Math.sin(Math.toRadians(calculatedAngle)) * radius));
                tempPoint = new Point(finalX, finalY);
                tempRectangle = new Rectangle(tempPoint, width, height);
                tempBlock = new Block(tempRectangle, hitPoints, GameLevel.colorArray().get(i - 1));
                blockList.add(tempBlock);

                calculatedAngle += deltaAngle;
            }

            radius -= width;
        }

        return blockList;
    }

    /**
     * The number of blocks to remove, in this case 5 can be left.
     * @return the number of blocks to remove.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size() - 5;
    }

}
