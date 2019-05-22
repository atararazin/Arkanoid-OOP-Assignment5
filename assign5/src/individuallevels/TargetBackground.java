package individuallevels;

import arkanoidelements.GameLevel;

import biuoop.DrawSurface;
import genericgameelements.Sprite;
/**
 * This is the target background for the directhit level. it is a sprite that will get
 * added to the game.
 * @author Atara Razin
 * @author Benjy Berkowicz
 * AKA Batara Berkorazin
 *
 */
public class TargetBackground implements Sprite {

    /**
     * draws the actual picture. first a black rectangle for the background, the the three
     * circles and then the two lines.
     * @param d the drawsurface
     */
    @Override
    public void drawOn(DrawSurface d) {
        //makes the black background
        d.setColor(java.awt.Color.BLACK);
        d.fillRectangle(0, 30, GameLevel.maxWidth(), GameLevel.maxHeight());

        //makes the three circles, with the radius increasing each time to make it bigger.
        int centerX = (GameLevel.maxWidth() / 2);
        int centerY = (GameLevel.maxHeight() / 3);
        d.setColor(java.awt.Color.BLUE);
        for (int i = 1; i < 4; i++) {
            int radius = 40 * i;
            d.drawCircle(centerX, centerY, radius);
        }

        //makes the two lines, one horizontal, one vertical
        d.drawLine(centerX + 150, centerY, centerX - 150, centerY);
        d.drawLine(centerX, centerY + 150, centerX, centerY - 150);
    }

    /**
     * implemented from Sprite interface.does nothing.
     */
    @Override
    public void timePassed() {
    }

    /**
     * adds to the list of Sprites in the game level.
     * @param g game level
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}