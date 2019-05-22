package genericgameelements;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The PauseScreen animation displays text until the player specifies it should continue by pressing space.
 * @author Benjy Berkowicz
 * @author Atara Razin
 *
 */
public class PauseScreen implements Animation {

    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * The constructor takes a keyboard for its terminating condition.
     * @param k a keyboard
     */
    public PauseScreen(KeyboardSensor k) {
       this.keyboard = k;
       this.stop = false;
    }

    /**
     * Performs one frame, which are all identical and consist simply of text on the screen.
     * @param d the draw surface to be drawn on
     */
    public void doOneFrame(DrawSurface d) {
       d.drawText(150, d.getHeight() / 2, "paused -- press space to continue", 32);
       // When a space key is detected, the terminating value boolean is adjusted.
       if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
           this.stop = true;
       }
    }

    /**
     * The animation is supposed to stop when the stop boolean has been set to true.
     * @return should the pausescreen keep displaying or not.
     */
    public boolean shouldStop() {
        return this.stop;
    }
 }