package individuallevels;

import java.awt.Color;

import arkanoidelements.GameLevel;
import biuoop.DrawSurface;
import genericgameelements.Sprite;

/**
 * The background for the spaceship level.
 * @author Benjy Berkowicz
 * @author Atara Razin
 *
 */
public class SpaceshipBackground implements Sprite {

    /**
     * The draw on method draws a spaceship.
     * @param d the drawsurface
     */
    @Override
    public void drawOn(DrawSurface d) {
        // Draw the background
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 30, GameLevel.maxWidth(), GameLevel.maxHeight());

        // The cap for the rocket
        d.setColor(new Color(192, 192, 192));
        d.fillCircle(455, 200, 75);

        // The antenna for the rocket
        d.setColor(new Color(181, 20, 71));
        d.fillRectangle(455, 70, 5, 70);

        // The rocket body
        d.setColor(Color.GRAY);
        d.fillRectangle(380, 200, 150, 300);

        // The rocket windows
        for (int i = 0; i < 5; i++) {
            d.setColor(new Color(90 - (20 * i), 25, 50));
            d.fillRectangle(400, 220 + (i * 50), 20, 20);
            d.fillRectangle(490, 220 + (i * 50), 20, 20);
        }

        // The fire at the bottom
        // The yellow flames
        d.setColor(Color.YELLOW);
        d.fillRectangle(440, 505, 30, 30);
        d.fillRectangle(410, 560, 30, 30);
        d.fillRectangle(480, 530, 30, 30);

        // The red flames
        d.setColor(Color.RED);
        d.fillRectangle(390, 515, 30, 30);
        d.fillRectangle(430, 570, 30, 30);
        d.fillRectangle(495, 530, 30, 30);

        // The orange flames
        d.setColor(Color.ORANGE);
        d.fillRectangle(420, 540, 30, 30);
        d.fillRectangle(470, 505, 30, 30);
        d.fillRectangle(496, 550, 30, 30);
    }

    /**
     * The time passed method does nothing in this instance.
     */
    @Override
    public void timePassed() {
        // TODO Auto-generated method stub

    }

    /**
     * Adds the sprite to the game level.
     * @param g the gamelevel.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

}
