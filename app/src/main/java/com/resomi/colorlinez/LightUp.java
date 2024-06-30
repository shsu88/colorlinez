package com.resomi.colorlinez;

import android.graphics.Color;
import android.widget.Button;
public class LightUp {
    public LightUp(Button button, String color) {
        try {
            button.setBackgroundColor(Color.parseColor(color));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
