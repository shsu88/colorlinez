package com.resomi.colorlinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

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
                b.setIndex(buttons.size() - 1);
            }
        }

        generateBalls();
        while (!gameOver()) {
            /*
            while (true) {
                // wait for player to select a ball
                // wait for player to select an empty space
                // if can move, move the ball and exit loop
                break;
            }
            // generate 3 balls randomly
            if (!generateBalls()) {
                break;
            }

             */
        }

        // TODO: Game Over
    }

    protected boolean generateBalls() {
        ArrayList<BallButton> emptyButtons = new ArrayList<BallButton>();
        for (BallButton b : buttons) {
            if (b.isEmpty()) {
                emptyButtons.add(b);
            }
        }

        if (emptyButtons.size() < 3) {
            // game over
            return false;
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

        for (int i = 0; i < 3; ++i) {
            Drawable ball = balls[(int) Math.floor(Math.random() * balls.length)];
            int index = (int) Math.floor(Math.random() * emptyButtons.size());
            emptyButtons.get(index).setBall(ball);
            emptyButtons.remove(index);
        }

        return true;
    }

    protected boolean gameOver() {
        // no movement available for player
        return true;
    }
}