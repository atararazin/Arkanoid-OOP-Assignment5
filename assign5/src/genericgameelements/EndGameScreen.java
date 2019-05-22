package genericgameelements;

import java.awt.Color;

import arkanoidelements.GameLevel;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The Endgame screen animation displays your final score, as well as a messsage
 * depending on whether the game was won or lost. The background changes colour
 * similarly based on win/loss state.
 *
 * @author Benjy Berkowicz
 * @author Atara Razin
 *
 */
public class EndgameScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean winState;
    private Counter scoreCounter;
    private int red;
    private int green;
    private int blue;
    private Color background;
    private String winLossText;

    /**
     * The constructor takes the required parameters.
     *
     * @param keyboard
     *            the keyboard connected to the gui
     * @param winState
     *            whether or not the game was won or lost
     * @param scoreCounter
     *            the final score
     */
    public EndgameScreen(KeyboardSensor keyboard, boolean winState, Counter scoreCounter) {
        this.keyboard = keyboard;
        this.winState = winState;
        this.scoreCounter = scoreCounter;

        // Based on the win or loss state, the initial colours and display text
        // are set
        if (winState) {
            this.blue = 100;
            this.red = 38;
            this.green = 168;
            this.background = new Color(this.red, this.green, this.blue);
            this.winLossText = "You Win!";
        } else {
            this.red = 255;
            this.blue = 110;
            this.green = 38;
            this.background = new Color(this.red, this.green, blue);
            this.winLossText = "Game Over!";
        }

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        // If the game was won, we loop colours along the red 'axis'.
        if (this.winState) {
            this.red = (this.red + 1) % 255;
        } else {
            // If the game was lost, we loop colours along the blue axis.
            this.blue = (this.blue + 1) % 255;
        }

        // The background colour is reset for display, and output.
        this.background = new Color(this.red, this.green, this.blue);
        d.setColor(this.background);
        d.fillRectangle(0, 0, GameLevel.maxWidth(), GameLevel.maxHeight());

        // The inner rectangle for printing
        d.setColor(Color.BLACK);
        d.fillRectangle((GameLevel.maxWidth() / 2) - 200, (GameLevel.maxHeight() / 2) - 100, 400, 200);

        // The final score / winstate text is written on top (centered).
        d.setColor(Color.WHITE);
        String scoreString = "Your score was: " + Integer.toString(this.scoreCounter.getValue());
        d.drawText((GameLevel.maxWidth() / 2) - 70, (GameLevel.maxHeight() / 2) - 30, this.winLossText, 30);
        d.drawText((GameLevel.maxWidth() / 2) - 140, (GameLevel.maxHeight() / 2) + 30, scoreString, 30);

    }

    @Override
    public boolean shouldStop() {
        // The endgame screen persists until the space key is pressed.
        return this.keyboard.isPressed(KeyboardSensor.SPACE_KEY);
    }

}
