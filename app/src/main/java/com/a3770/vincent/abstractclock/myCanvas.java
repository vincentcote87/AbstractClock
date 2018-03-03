package com.a3770.vincent.abstractclock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.icu.util.Calendar;
import android.util.AttributeSet;
import android.view.View;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.RED;

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
//        paint.setColor(BLUE);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        screenWidth = getWidth();
        screenHeight = getHeight();
//        barWidth = (screenWidth - 120) / 3;
        barWidth = (screenWidth) / 3;
        barHeight = (int)Math.round(screenHeight * 0.75);

        init = true;
    }

    public void onDraw(Canvas canvas) {
        if(!init) {
            init();
        }

        canvas.drawColor(0xff000000);
        drawHour(canvas);
        drawMin(canvas);
        drawSec(canvas);

        postInvalidateDelayed(500);
        invalidate();
    }

    private void drawSec(Canvas canvas) {
        paint.reset();
        paint.setColor(0xfff34faf);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
//        canvas.drawRect(90 + 2*barWidth, 100, 90 + 3*barWidth, barHeight, paint);
        canvas.drawRect(2*barWidth, 100,3*barWidth, barHeight, paint);
    }

    private void drawMin(Canvas canvas) {
        paint.reset();
        paint.setColor(0xfff6bf3f);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
//        canvas.drawRect(60 + barWidth, 100, 60 + 2*barWidth, barHeight, paint);
        canvas.drawRect(barWidth, 100, 2*barWidth, barHeight, paint);
    }

    private void drawHour(Canvas canvas) {
        paint.reset();
        paint.setColor(0xffffffff);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
//        canvas.drawRect(30, 100, 30 + barWidth, barHeight, paint);
        canvas.drawRect(0, 100, barWidth, barHeight, paint);

    }
}

//
//public class myCanvas extends View {
//
//    boolean init=false;
//    Paint pt;
//
//    //all three constructors are needed here
//    public myCanvas(Context context) {
//        super(context);
//    }
//
//    public myCanvas(Context context, AttributeSet attrs)
//    {
//        super(context,attrs);
//    }
//
//    public myCanvas(Context context, AttributeSet attrs, int defStyleAttr)
//    {
//        super(context, attrs, defStyleAttr);
//    }
//
//    void init()
//    {
//        pt = new Paint();
//        pt.setColor(Color.BLACK);
//        pt.setStyle(Paint.Style.FILL_AND_STROKE);
//        pt.setTextSize(100);
//        pt.setFakeBoldText(true);
//
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas){
//
//        if(!init){
//            init();
//            init=true;
//        }
//
//        canvas.drawColor(Color.WHITE);
//
//        //get the time
//        Calendar ctime = Calendar.getInstance();
//
//        String hour = Integer.toString(ctime.get(Calendar.HOUR));
//        String min = Integer.toString(ctime.get(Calendar.MINUTE));
//        String sec = Integer.toString(ctime.get(Calendar.SECOND));
//
//        if(ctime.get(Calendar.MINUTE)>=10&&ctime.get(Calendar.SECOND)>=10) {
//            canvas.drawText(hour + ":" + min + ":" + sec, 300, 200, pt);
//        } else if(ctime.get(Calendar.MINUTE)>=10){
//            canvas.drawText(hour + ":" + min + ":0" + sec, 300, 200, pt);
//        } else {
//            canvas.drawText(hour + ":0" + min + ":" + sec, 300, 200, pt);
//        }
//
//        //maybe possible to delay invalidating a bit.
//        invalidate();
//    }
//}
