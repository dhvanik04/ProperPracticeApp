package com.example.ihavetofly;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.heyletscode.ihavetofly.GameView.screenRatioX;
import static com.heyletscode.ihavetofly.GameView.screenRatioY;

public class Flight {
    public boolean isGoingUp = false;
    int x, y, width, height;
    Bitmap player;
    Bitmap dead;
    private GameView gameView;

    Flight(GameView gameView, int screenY, Resources res) {
        this.gameView = gameView;
        player = BitmapFactory.decodeResource(res, R.drawable.player1_grocery_store);

        width = player.getWidth();
        height = player.getHeight();

        width /= 4;
        height /= 4;

        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        player = Bitmap.createScaledBitmap(player, width, height,false);

        dead = BitmapFactory.decodeResource(res, R.drawable.player1dead);

        y = screenY / 2;
        x = (int)(64 * screenRatioX);


    }

    Rect getCollisionShape() {
        return new Rect(x, y, x+width, y+height);
    }

    Bitmap getDead () {
        return dead;
    }

}
