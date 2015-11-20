package com.nataliajastrzebska.besetupcheckpoints;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    BeaconsView beaconsView;
    boolean placed = false;
    BeaconLocation currBeacon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beaconsView = (BeaconsView) findViewById(R.id.beView);

        beaconsView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(!placed){
                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        placed = true;
                        currBeacon = new BeaconLocation("dd", event.getX(), event.getY());
                        beaconsView.addBeaconLocation(currBeacon);
                       // textView.setText("Touch coordinates : " +
                               // String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
                        beaconsView.invalidate();
                    }
                }
                if(placed) {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        placed = false;
                    } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                        Log.d("natalia", "dragging");
                        //currBeacon.setRadius(Math.abs(event.getX() - currBeacon.getX()));
                        currBeacon.setRadius((float)
                                Math.sqrt(
                                        Math.pow((double) (event.getX() - currBeacon.getX()), 2.0)
                                                + Math.pow((double) (event.getY() - currBeacon.getY()), 2.0)));
                        beaconsView.invalidate();
                    }
                }
                return true;
            }
        });


        beaconsView.setOnDragListener(new View.OnDragListener() {

            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d("natalia", "dragging");
                if (placed) {
                    Log.d("natalia", "dragging");
                    currBeacon.setRadius(Math.abs(event.getX() - event.getX()));
                }
                return false;
            }
        });

    }
}
