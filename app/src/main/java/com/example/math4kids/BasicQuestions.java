package com.example.math4kids;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class BasicQuestions extends AppCompatActivity {
    public int timer_counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.Theme_Math4Kids);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_questions);
        timer_counter = 60;
        int millisec = 60 * 1000;

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //if (timer_counter !=0 ) {
//
//                try {
//                    //sleep(1000);
////                    TextView countdown = (TextView) findViewById(R.id.timer);
////                    String timerString = String.valueOf(timer_counter);
//                    //countdown.setText(timerString);
//                    timer_counter--;
//                    Log.d("Timer Counter",timerString);
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                //}
//            }
//        });
//        thread.start();


        Timer timerObj = new Timer();
        TimerTask timerTaskObj = new TimerTask() {
            @Override
            public void run() {
                if (timer_counter !=0 ) {

                    String timerString = String.valueOf(timer_counter);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            counter();
                        }
                    });

                    Log.d("Timer Counter",timerString);
                    timer_counter--;
                }

            }
        };
        timerObj.schedule(timerTaskObj, 0, 1000);
//        TextView countdown = (TextView) findViewById(R.id.timer);
//        String timerString = String.valueOf(timer_counter);
//        countdown.setText(timerString);
    }

    private void counter(){
        TextView countdown = (TextView) findViewById(R.id.timer);
        String timerString = String.valueOf(timer_counter);
        countdown.setText(timerString);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
}