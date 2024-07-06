package com.resomi.colorlinez;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;

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

    private final ImageView b;
    private State s;

    public BallButton(ImageView raw) {
        b = raw;
        s = State.EmptyUnselected;
        b.setOnClickListener(v -> {
            switch (s) {
                case EmptyUnselected:
                    s = State.EmptySelected;
                    break;
                case ColorBallUnselected:
                    s = State.ColorBallSelected;
                    break;
                case ColorBallSelected:
                    s = State.ColorBallUnselected;
                    break;
                default:  // EmptySelected
                    break;
            }
            redraw();
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

    public void redraw() {
        Resources r = b.getResources();
        Drawable f = r.getDrawable(R.drawable.empty_rect, null);
        Drawable[] balls = {r.getDrawable(R.drawable.red_ball, null),
                r.getDrawable(R.drawable.orange_ball, null),
                r.getDrawable(R.drawable.yellow_ball, null),
                r.getDrawable(R.drawable.green_ball, null),
                r.getDrawable(R.drawable.blue_ball, null),
                r.getDrawable(R.drawable.purple_ball, null),
                r.getDrawable(R.drawable.pink_ball, null),
                r.getDrawable(R.drawable.brown_ball, null)};
        Drawable ball = balls[(int)Math.floor(Math.random() * balls.length)];
        Drawable[] layers = {f, ball};
        LayerDrawable ld = new LayerDrawable(layers);
        b.setImageDrawable(ld);
        b.invalidate();
    }
}
