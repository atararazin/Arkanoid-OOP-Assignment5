package genericgameelements;

import biuoop.DrawSurface;

/**
 * The Animation interface requires methods to perform one frame movement, and dictate when the
 * animation should stop.
 * @author Benjy Berkowicz
 * @author Atara Razin
 *
 */
public interface Animation {
    /**
     * Performs one frame of the given animation.
     * @param d the frame on which the sprites are drawn
     */
    void doOneFrame(DrawSurface d);

    /**
     * Returns whether the animation is supposed to stop or not.
     * @return a boolean, is the animation ready to stop
     */
    boolean shouldStop();
}
