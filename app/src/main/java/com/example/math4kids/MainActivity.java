package com.example.math4kids;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String welcome_message = "Hi! \n Welcome to Math for kids. To learn mathematics and take basic test," +
            "  click the blue button. For intermediate, click red. For advance, click green. To listen" +
            " again, press the speaker icon in the action bar.";
    String instruction = "Hi! \n Welcome to Math for kids. To learn mathematics and take basic test," +
            "click the blue button. For intermediate, click red. For advance, click green.";
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button basic = (Button) findViewById(R.id.basic);
        Button intermediate = (Button) findViewById(R.id.intermediate);
        Button advance = (Button) findViewById(R.id.advance);
        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent basicIntent = new Intent(getApplicationContext(), BasicActivity.class);
                startActivity(basicIntent);
            }
        });
        intermediate.setOnClickListener(v -> {
            Intent intermediateIntent = new Intent(getApplicationContext(), IntermediateActivity.class);
            startActivity(intermediateIntent);
        });
        advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent advanceIntent = new Intent(getApplicationContext(), AdvanceActivity.class);
                startActivity(advanceIntent);
            }
        });
        speak(welcome_message);
    }

    @Override
    protected void onStart() {
        super.onStart();
        int speech = R.string.main_activity;

    }

    private void speak(String speech){
        t1 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    t1.setLanguage(Locale.ENGLISH);
                    //t1.setPitch(2);
                    //t1.setSpeechRate(3);
                    t1.speak(speech, TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menu1 = getMenuInflater();
        menu1.inflate(R.menu.app_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.speak:
                speak(instruction);
                return true;
            case  R.id.settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}