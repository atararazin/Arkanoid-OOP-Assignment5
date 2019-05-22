package individuallevels;

import biuoop.DrawSurface;
import genericgameelements.Sprite;

import java.awt.Color;

import arkanoidelements.GameLevel;

/**
 * The rainbow background draws a background for the rainbow.
 * @author Benjy Berkowicz
 * @author Atara Razin
 *
 */
public class RainbowBackground implements Sprite {

    /**
     * Draws the ground and some clouds.
     * @param d the drawsurface
     */
    @Override
    public void drawOn(DrawSurface d) {

        // Draw the background
        d.setColor(Color.CYAN);
        d.fillRectangle(0, 30, GameLevel.maxWidth(), GameLevel.maxHeight());

        // Draw the ground
        d.setColor(new Color(173, 255, 47));
        d.fillRectangle(0, 400, 800, 200);

        // Draw a cloud
        d.setColor(Color.WHITE);
        d.fillCircle(500, 110, 40);
        d.setColor(Color.WHITE);
        d.fillCircle(480, 150, 40);
        d.setColor(Color.WHITE);
        d.fillCircle(530, 160, 40);
        d.setColor(Color.WHITE);
        d.fillCircle(550, 110, 40);
        d.setColor(Color.WHITE);
        d.fillCircle(580, 160, 40);

        // Draw the sun
        d.setColor(Color.YELLOW);
        d.fillCircle(150, 150, 60);

        // Draw the spokes of the sun
        int centerX = 150;
        int centerY = 150;
        int spokeLength = 90;
        int numSpokes = 36;

        // Loop through the angles
        for (int i = 0; i < numSpokes; i++) {
            int deltaX = (int) (Math.cos(Math.toRadians((360 / numSpokes) * i)) * spokeLength);
            int deltaY = (int) (Math.sin(Math.toRadians((360 / numSpokes) * i)) * spokeLength);
            d.drawLine(centerX, centerY, centerX + deltaX, centerY + deltaY);
        }

    }

    /**
     * Do nothing as time passes.
     */
    @Override
    public void timePassed() {

    }

    /**
     * Adds itself to the game as a sprite.
     * @param g the game level.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
