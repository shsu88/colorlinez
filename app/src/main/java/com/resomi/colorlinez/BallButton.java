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
    private Drawable ball;
    private int index;

    public BallButton(ImageView raw) {
        b = raw;
        s = State.EmptyUnselected;
        ball = null;
        index = -1;
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
        });
    }

    public void setBall(Drawable newBall) {
        if (s != State.EmptySelected && s != State.EmptyUnselected) {
            throw new IllegalStateException();
        }
        s = State.ColorBallUnselected;
        ball = newBall;
        Resources r = b.getResources();
        Drawable f = r.getDrawable(R.drawable.empty_rect, null);
        Drawable[] layers = {f, ball};
        LayerDrawable ld = new LayerDrawable(layers);
        b.setImageDrawable(ld);
        b.invalidate();
    }

    public void removeBall() {
        if (s != State.ColorBallSelected && s != State.ColorBallUnselected) {
            throw new IllegalStateException();
        }
        s = State.EmptyUnselected;
        ball = null;
        Resources r = b.getResources();
        Drawable f = r.getDrawable(R.drawable.empty_rect, null);
        b.setImageDrawable(f);
        b.invalidate();
    }
}
