package com.heyletscode.ihavetofly;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.heyletscode.ihavetofly.GameView.screenRatioX;
import static com.heyletscode.ihavetofly.GameView.screenRatioY;

import java.util.Random;

public class Customer {

    public int speed = 20;
    public boolean wasShot = true;
    int x = 0, y, width, height, customerCounter = 1;
    Bitmap customer1, customer2, customer3, customer4;

    Customer(Resources res) {

        final int[] customerArray = {R.drawable.green, R.drawable.green_2,
                                    R.drawable.mohawk, R.drawable.mohawk_2_cart,
                                    R.drawable.mohawk_cart, R.drawable.nm_green,
                                    R.drawable.nm_green_2, R.drawable.nm_mohawk,
                                    R.drawable.nm_mohawk_cart, R.drawable.nm_purple,
                                    R.drawable.nm_purple_cart, R.drawable.nm_red_2_cart,
                                    R.drawable.nm_red_cart, R.drawable.purple,
                                    R.drawable.purple_2, R.drawable.red_2_cart,
                                    R.drawable.red_cart};
        Random rand = new Random();
        int n = rand.nextInt(17);

        customer1 = BitmapFactory.decodeResource(res, customerArray[n]);
        customer2 = BitmapFactory.decodeResource(res, customerArray[n]);
        customer3 = BitmapFactory.decodeResource(res, customerArray[n]);
        customer4 = BitmapFactory.decodeResource(res, customerArray[n]);

        width = customer1.getWidth();
        height = customer1.getHeight();

        //reduce size of customers
        width /= 6;
        height /= 6;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        customer1 = Bitmap.createScaledBitmap(customer1, width, height, false);
        customer2 = Bitmap.createScaledBitmap(customer2, width, height, false);
        customer3 = Bitmap.createScaledBitmap(customer3, width, height, false);
        customer4 = Bitmap.createScaledBitmap(customer4, width, height, false);

        y = -height;
    }

    Bitmap getCustomer () {

        if (customerCounter == 1) {
            customerCounter++;
            return customer1;
        }

        if (customerCounter == 2) {
            customerCounter++;
            return customer2;
        }

        if (customerCounter == 3) {
            customerCounter++;
            return customer3;
        }

        customerCounter = 1;

        return customer4;
    }

    Rect getCollisionShape () {
        return new Rect(x, y, x + width, y + height);
    }

}
