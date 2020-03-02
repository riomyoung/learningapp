package com.example.languagelearningtime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Debug extends AppCompatActivity {

    Button photostore_front, bookstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        photostore_front = findViewById( R.id.photostore_front_interaction1 );
        bookstore = findViewById( R.id.bookstore );

        photostore_front.setOnClickListener( new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Debug.this, PhotostoreFront.class);
                startActivity( intent );
            }
        });
        bookstore.setOnClickListener( new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Debug.this, Bookstore.class);
                startActivity( intent );
            }
        });
    }
}

