package com.nataliajastrzebska.besetupcheckpoints;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nataliajastrzebska on 18/11/15.
 */


public class BeaconsView extends View {

    List <BeaconLocation> beaconLocationList;
    int RSSI;
    public BeaconsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        RSSI = 0;
        beaconLocationList = new ArrayList<>();
    }



    @Override
    public void onDraw(Canvas canvas) {
        if (beaconLocationList.size() > 0){
            //drawPower(canvas, 300, 300, String.valueOf(RSSI), 70);
            for (int i = 0; i <beaconLocationList.size(); i++) {
                Log.d("natalia", "radius " + beaconLocationList.get(i).getRadius());
                        drawCircle(canvas, beaconLocationList.get(i).getX(), beaconLocationList.get(i).getY(), Color.GREEN, 20);
                drawCircle(canvas, beaconLocationList.get(i).getX(), beaconLocationList.get(i).getY(), Color.argb(100, 0, 255, 0), beaconLocationList.get(i).getRadius());
            }
        }

    }

    public void addBeaconLocation(BeaconLocation beaconLocation){
        beaconLocationList.add(beaconLocation);
    }

    public void setPower(int rssi){
        this.RSSI = rssi;
    }

    public void setList(List<BeaconLocation> beaconLocationList){
        this.beaconLocationList = beaconLocationList;
    }



    void drawCircle(Canvas c,float x,float y, int color, float radius){
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        c.drawCircle(x, y, radius, paint);
    }

    void drawPower(Canvas canvas, float x, float y, String rssi, int fontSize){
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setTextSize(fontSize);
        canvas.drawText(rssi, x - 20, y + 5, paint);
    }

    void drawSquare(Canvas canvas, float x, float y, int color){
        Paint paint= new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        canvas.drawRect(x - 375, y - 700, x + 375, y + 700, paint);
    }

    void drawPath(Canvas canvas, float bx, float by, float ex, float ey){
        Paint paint= new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth((float) 10.0);
        canvas.drawLine(bx,by,ex,ey,paint);
    }

}
