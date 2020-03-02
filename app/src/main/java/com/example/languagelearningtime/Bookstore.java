package com.example.languagelearningtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Bookstore extends AppCompatActivity {

    Fragment home_fragment;
    ImageButton home_button, close_home_button, book1, book2;
    Button go_to_town, go_to_titlescreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookstore);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        book1 = findViewById( R.id.book1 );
        book2 = findViewById( R.id.book2 );

        go_to_titlescreen = findViewById( R.id.go_to_title_screen );
        go_to_town = findViewById( R.id.go_to_fullscreen);
        close_home_button = findViewById( R.id.close_home_button);
        home_button = findViewById( R.id.home_button );

        home_fragment = getSupportFragmentManager().findFragmentById( R.id.home_menu );
        home_fragment.getView().setVisibility( View.INVISIBLE );





        home_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                home_fragment.getView().setVisibility(View.VISIBLE );
            }
        });

        go_to_titlescreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent( Bookstore.this, MainActivity.class );
                startActivity( intent );
            }
        });
        go_to_town.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent( Bookstore.this, FullMainScreenActivity.class );
                startActivity( intent );
            }
        });

        close_home_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                home_fragment.getView().setVisibility(View.INVISIBLE );
            }
        });

        book1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent( Bookstore.this, Book.class );
                intent.putExtra("bookNum", 1);
                startActivity( intent );
            }
        });

        book2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent( Bookstore.this, Book.class );
                intent.putExtra("bookNum", 2);
                startActivity( intent );
            }
        });
    }
}
