package com.resomi.colorlinez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<BallButton> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                String id = String.format("%d%d", i, j);
                int resId = this.getResources().getIdentifier("b"+id, "id", this.getPackageName());
                BallButton b = new BallButton(findViewById(resId));
                buttons.add(b);
            }
        }
    }
}