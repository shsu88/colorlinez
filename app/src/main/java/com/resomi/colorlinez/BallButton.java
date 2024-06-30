package com.resomi.colorlinez;

import android.system.StructMsghdr;
import android.widget.Button;
import android.graphics.Color;
public class BallButton {
    private Button b;

    public BallButton(Button raw) {
        b = raw;
        b.setOnClickListener(v -> {
            b.LightUp(b, "#ffffff");
        });
    }

    public void setText(String s) {
        b.setText(s);
    }
}
