package com.example.languagelearningtime;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;


public class FullMainScreenActivity extends AppCompatActivity {


    ImageButton home, photostore, bookstore, topleft, park, restaurant, grocerystore, movietheater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_full_main_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        home = findViewById(R.id.home );
        home.setBackgroundResource( R.drawable.home);

        photostore = findViewById(R.id.photostore );
        photostore.setBackgroundResource( R.drawable.photostore);

        bookstore = findViewById(R.id.bookstore );
        bookstore.setBackgroundResource( R.drawable.bookstore);

        topleft = findViewById(R.id.topleft);
        topleft.setBackgroundResource( R.drawable.cafe);

        park = findViewById(R.id.park );
        park.setBackgroundResource( R.drawable.park);

        restaurant = findViewById(R.id.restaurant );
        restaurant.setBackgroundResource( R.drawable.restaurant);

        grocerystore= findViewById(R.id.grocerystore );
        grocerystore.setBackgroundResource( R.drawable.grocery_store);

        movietheater = findViewById(R.id.movietheater );
        movietheater.setBackgroundResource( R.drawable.movie_theater);

        photostore.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(FullMainScreenActivity.this, PhotostoreFront.class);

                // start the activity connect to the specified class
                startActivity(intent);

            }
        });

    }

//    // This snippet hides the system bars.
//    private void hideSystemUI() {
//        // Set the IMMERSIVE flag.
//        // Set the content to appear under the system bars so that the content
//        // doesn't resize when the system bars hide and show.
//        mDecorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
//                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
//    }
//
//    // This snippet shows the system bars. It does this by removing all the flags
//// except for the ones that make the content appear under the system bars.
//    private void showSystemUI() {
//        mDecorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//    }
}
