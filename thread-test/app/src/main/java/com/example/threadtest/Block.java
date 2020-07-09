package com.example.threadtest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Block implements GameObject {
    private Bitmap bitmap;

    private Context mContext;

    private long time = System.currentTimeMillis();
    private int progress = 0;

    public Block(Context context) {
        mContext = context;
        bitmap = getScaledBitmap(R.drawable.block_green, 100, 100);
    }

    @Override
    public void draw(Canvas canvas) {
        //Ich bin ein Test
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                canvas.drawBitmap(bitmap, i * 100, progress + j * 100, null);
            }
        }
    }

    public Bitmap getScaledBitmap(int rDrawable, int width, int height)
    {
        Resources res = mContext.getResources();
        Bitmap b = BitmapFactory.decodeResource(res, rDrawable);
        return Bitmap.createScaledBitmap(b, width, height, false);
    }

    @Override
    public void update() {

        int timeInMs = 2000;
        float procent = (float)(System.currentTimeMillis() - time) / timeInMs;
        progress = (int)(1920 * procent);
        if (procent >= 1) {
            time = System.currentTimeMillis();
        }

    }
}
