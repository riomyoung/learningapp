package com.example.languagelearningtime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button next_Activity_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.ukulele);
        ring.start();

        next_Activity_button = (Button)findViewById(R.id.start);

        next_Activity_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(MainActivity.this, FullMainScreenActivity.class);

                // start the activity connect to the specified class
                startActivity(intent);

            }
        });
    }
}
