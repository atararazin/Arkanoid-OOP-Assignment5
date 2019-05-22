package individuallevels;

import java.awt.Color;

import arkanoidelements.GameLevel;
import biuoop.DrawSurface;
import genericgameelements.Sprite;
/**
 * a sprite of the actual picture. A sun and its rays.
 */
public class SunshineBackground implements Sprite {

    /**
     * draws the actual picture. a sun that is comprised of three yellow circles, its rays,
     * which are lines decreasing in how close they are to each other as they go rightward.
     * @param d the drawsurface
     */
    @Override
    public void drawOn(DrawSurface d) {
        //creates two shades of yellow.
        Color innerYellow = new Color(242, 214, 95);
        Color middleYellow = new Color(247, 244, 97);
        //centers of the circle
        int xPos = GameLevel.maxHeight() / 6;
        int yPos = GameLevel.maxWidth() / 6;
        d.setColor(innerYellow);
        //draws the lines
        for (int i = 0; i < 400; i++) {
            d.drawLine(xPos, yPos, i + (i ^ 3), GameLevel.maxHeight() / 3);
        }
        //draws the three circles.
        d.setColor(middleYellow);
        d.fillCircle(xPos, yPos, 50);
        d.setColor(java.awt.Color.YELLOW);
        d.fillCircle(xPos, yPos, 40);
        d.setColor(innerYellow);
        d.fillCircle(xPos, yPos, 30);
    }

    /**
     * implemented method from the sprite interface.does nothing.
     */
    @Override
    public void timePassed() {

    }

    /**
     * adds it to the list of sprites.
     * @param g the level
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}