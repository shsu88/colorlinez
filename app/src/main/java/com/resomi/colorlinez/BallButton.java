package com.resomi.colorlinez;

import android.widget.Button;
import android.graphics.Color;

/**
 * BallButton implements 4 different states:
 * EmptyUnselected -> click -> EmptySelected (no recycle)
 * ColorBallUnselected -> click -> ColorBallSelected -> click -> recycle
 */
public class BallButton {

    public enum State {
        EmptyUnselected,
        EmptySelected,
        ColorBallUnselected,
        ColorBallSelected,
    }

    private final Button b;
    private State s;

    public BallButton(Button raw) {
        b = raw;
        s = State.EmptyUnselected;
        b.setOnClickListener(v -> {
            switch (s) {
                case EmptyUnselected:
                    b.setBackgroundColor(Color.parseColor("#FF00FF"));
                    s = State.EmptySelected;
                    break;
                case ColorBallUnselected:
                    b.setBackgroundColor(Color.parseColor("#FF00FF"));
                    s = State.ColorBallSelected;
                    break;
                case ColorBallSelected:
                    b.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    s = State.ColorBallUnselected;
                    break;
                default:  // EmptySelected
                    break;
            }
        });
    }

    public void setBall(String color) {
        if (s != State.EmptySelected || s != State.EmptyUnselected) {
            throw new IllegalStateException();
        }
        s = State.ColorBallUnselected;
        // TODO: draw a circle filled with the color
    }

    public void removeBall() {
        if (s != State.ColorBallSelected || s != State.ColorBallUnselected) {
            throw new IllegalStateException();
        }
        s = State.EmptyUnselected;
        // TODO: remove the drawn ball
    }

    public void setText(String s) {
        b.setText(s);
    }
}
