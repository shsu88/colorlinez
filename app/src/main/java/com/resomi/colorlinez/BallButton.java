package com.resomi.colorlinez;

import android.system.StructMsghdr;
import android.widget.Button;
public class BallButton {
    private Button b;

    public BallButton(Button raw) {
        b = raw;
    }

    public void setText(String s) {
        b.setText(s);
    }
}
