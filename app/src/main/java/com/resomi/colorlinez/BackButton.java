package com.resomi.colorlinez;

import android.graphics.Color;
import android.widget.Button;

public class BackButton {

    private Button b;

    public BackButton(Button raw) {
        b = raw;
        b.setOnClickListener(v -> {
            b.LightUp(b, "#ffffff");
        });
    }



}
