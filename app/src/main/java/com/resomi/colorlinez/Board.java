package com.resomi.colorlinez;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.ArrayList;

public class Board {
    private ArrayList<BallButton> buttons;
    private int[][] board;
    private Drawable[] balls;

    private int getIndex(int i, int j) {
        return i * 9 + j;
    }

    public Board() {
        board = new int[9][9];
        buttons = new ArrayList<>();

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                board[i][j] = -1;
            }
        }
    }

    public void addButton(BallButton b) {
        buttons.add(b);
    }

    public void setBalls(Drawable[] b) {
        balls = b;
    }

    public boolean isGameOver() {
        return isNoSpace();
    }

    public boolean isNoSpace() {
        int empty = 0;
        for (int i = 0; i < 9 && empty < 3; ++i) {
            for (int j = 0; j < 9 && empty < 3; ++j) {
                if (board[i][j] == -1) empty++;
            }
        }
        return empty < 3;
    }

    public void generate() {
        ArrayList<Integer> empty = new ArrayList<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == -1) {
                    empty.add(i * 10 + j);
                }
            }
        }
        for (int i = 0; i < 3; ++i) {
            int color = (int) Math.floor(Math.random() * balls.length);
            int index = (int) Math.floor(Math.random() * empty.size());
            int selection = empty.get(index);
            int x = selection / 10;
            int y = selection % 10;
            Log.i("COLORLINZ", String.format("x:%d y:%d c:%d", x, y, color));
            board[x][y] = color;
            buttons.get(getIndex(x, y)).setBall(balls[color]);
            empty.remove(index);
        }
    }

    public void play() {
        generate();
    }
}
