package com.resomi.colorlinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = new Board();

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                String id = String.format("%d%d", i, j);
                int resId = this.getResources().getIdentifier("b"+id, "id", this.getPackageName());
                board.addButton(new BallButton(findViewById(resId)));
            }
        }

        Resources r = this.getResources();
        Drawable[] balls = {r.getDrawable(R.drawable.red_ball, null),
                r.getDrawable(R.drawable.orange_ball, null),
                r.getDrawable(R.drawable.yellow_ball, null),
                r.getDrawable(R.drawable.green_ball, null),
                r.getDrawable(R.drawable.blue_ball, null),
                r.getDrawable(R.drawable.purple_ball, null),
                r.getDrawable(R.drawable.pink_ball, null),
                r.getDrawable(R.drawable.brown_ball, null)};
        board.setBalls(balls);

        while (!board.isGameOver()) {
            board.play();
        }
    }
}