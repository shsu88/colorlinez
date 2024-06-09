package com.resomi.colorlinez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                String id = String.format("%d%d", i, j);
                int resId = this.getResources().getIdentifier("b"+id, "id", this.getPackageName());
                Button b = findViewById(resId);
                b.setText(id);
                buttons.add(b);
            }
        }
    }
}