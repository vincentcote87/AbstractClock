package com.a3770.vincent.abstractclock;

import android.content.Context;
import android.graphics.Canvas;
//import android.graphics.Color;
import android.graphics.Paint;
//import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.icu.util.Calendar;
import android.util.AttributeSet;
import android.view.View;

import static android.graphics.Color.rgb;

/**
 * Created by Vincent on 3/2/2018.
 */

public class myCanvas extends View {

    private boolean init = false;
    Paint paint;
    int screenWidth;
    int screenHeight;
    int barWidth;
    int barHeight;

    int hour;
    int min;
    int sec;

    int red;
    int green;
    int blue;

//    Drawable scale = ResourcesCompat.getDrawable(R.drawable.color_scale);

    public myCanvas(Context context) {
        super(context);
    }

    public myCanvas(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    public myCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        paint = new Paint();
        screenWidth = getWidth();
        screenHeight = getHeight();
        barWidth = (screenWidth) / 3;
        barHeight = (int)Math.round(screenHeight * 0.75);
        init = true;
    }

    public void onDraw(Canvas canvas) {
        if(!init) {
            init();
        }

        Calendar time = Calendar.getInstance();
        hour = time.get(Calendar.HOUR);
        min = time.get(Calendar.MINUTE);
        sec = time.get(Calendar.SECOND);

        canvas.drawColor(0xff000000);
        drawHour(canvas);
        drawMin(canvas);
        drawSec(canvas);

        postInvalidateDelayed(500);
        invalidate();
    }

    private void getColour(int timeVar) {
        if(timeVar == 0) {
            red = 135;
            green = 0;
            blue = 255;
        }
        else if(timeVar > 0 && timeVar < 15) {
            red = 135 - ((timeVar % 15) * 9);
            green = 0;
            blue = 255;
        }
        else if(timeVar >= 15 && timeVar < 30) {
            red = 0;
            green = ((timeVar % 15) * 13);
            blue = 255;
        }
        else if(timeVar >=30 && timeVar < 45) {
            red = 0;
            green = 195 + ((timeVar % 15) * 4);
            blue = 255 - ((timeVar % 15) * 15);
        }
        else if(timeVar >=45 && timeVar < 60) {
            red = (timeVar % 15) * 17;
            green = 255;
            blue = 30 - ((timeVar % 15) * 2);
        }
        else {
            red = 255;
            green = 255;
            blue = 0;
        }
    }

    private void drawSec(Canvas canvas) {
        paint.reset();
        getColour(sec);
        paint.setColor(rgb(red, green, blue));
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        canvas.drawRect(2*barWidth, 0,3*barWidth, barHeight, paint);
    }

    private void drawMin(Canvas canvas) {
        paint.reset();
        getColour(min);
        paint.setColor(rgb(red, green, blue));
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        canvas.drawRect(barWidth, 0, 2*barWidth, barHeight, paint);
    }

    private void drawHour(Canvas canvas) {
        paint.reset();
        getColour(hour * 5);
        paint.setColor(rgb(red, green, blue));
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        canvas.drawRect(0, 0, barWidth, barHeight, paint);

    }
}
