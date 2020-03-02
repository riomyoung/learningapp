package com.example.languagelearningtime;
//WORKING ON SHARED PREFERENCES, https://chinesepod.com/tools/pronunciation/section/17, https://www.misspandachinese.com/resources/tones-in-chinese/

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class FullMainScreenActivity extends AppCompatActivity {

    Fragment intro_to_pinyin, home_fragment;
    ImageButton close_home_button, home_button, xbutt, home, photostore, bookstore, topleft, park, restaurant, grocerystore, movietheater;
    TextView explanation;
    Button back_butt, next_butt, go_to_title_screen, go_to_town, first_tone, second_tone, third_tone,fourth_tone, fifth_tone;
    CheckBox checkBox;
    ImageView tone_graphs;

    ArrayList<String> home_list = new ArrayList<>();
//    String[] home_list = {"Main Menu", "Town", "Options" };

    int page = 1;
    String pg1 = "";
    String pg2 = "Pinyin is the romanization of the Chinese characters based on their pronunciation. The symbols above characters show how each word should be pronounced. Depending on your tone, the meaning changes. For example, 'Yes?' and 'Yes!' have different tones and meanings. ";
    String pg3 = "The graphs below show a visual representation of tones.";
    String pg4 = "Click on the words to hear the different sounds";
    String pg5 = "Don't worry if you don't fully understand now, you'll be able to get plenty of practice later on!";

//    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE ); // 0 - for private mode
//    SharedPreferences.Editor editor = pref.edit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_full_main_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        home_list.add("Main Menu");
        home_list.add("Town");
        home_list.add("Options");




        intro_to_pinyin = getSupportFragmentManager().findFragmentById( R.id.intro_to_pinyin );
        home_fragment = getSupportFragmentManager().findFragmentById( R.id.home_menu );
        home_fragment.getView().setVisibility( View.GONE );

//        if ( pref.getBoolean("key_name", false ) )
//        {
//            intro_to_pinyin.getView().setVisibility(View.GONE);
//        }

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

//        addListenerOnChkIos( );

//        startActivity( new Intent( FullMainScreenActivity.this, IntroToPinyin.class ) );

        explanation = findViewById( R.id.explanation );
        pg1 = (String ) explanation.getText();

        go_to_title_screen = findViewById( R.id.go_to_title_screen);
        go_to_town = findViewById( R.id.go_to_fullscreen);
        close_home_button = findViewById( R.id.close_home_button);
        home_button = findViewById( R.id.home_button);
        next_butt = findViewById( R.id.next_butt );
        back_butt = findViewById( R.id.back_butt );
        tone_graphs = findViewById( R.id.tone_graphs);
        xbutt = findViewById( R.id.xbutt );
        first_tone = findViewById( R.id.first_tone );
        second_tone= findViewById( R.id.second_tone );
        third_tone = findViewById( R.id.third_tone);
        fourth_tone= findViewById( R.id.fourth_tone );
        fifth_tone = findViewById( R.id.fifth_tone);


        intro_to_pinyin = getSupportFragmentManager().findFragmentById( R.id.intro_to_pinyin );

        back_butt.setVisibility( View.INVISIBLE );
        tone_graphs.setVisibility( View.INVISIBLE );

        first_tone.setVisibility( View.INVISIBLE );
        second_tone.setVisibility( View.INVISIBLE );
        third_tone.setVisibility( View.INVISIBLE );
        fourth_tone.setVisibility( View.INVISIBLE );
        fifth_tone.setVisibility( View.INVISIBLE );

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
        bookstore.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(FullMainScreenActivity.this, Bookstore.class);

                // start the activity connect to the specified class
                startActivity(intent);

            }
        });

        next_butt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                page++;
                String pageNum = "pg" + page;
                System.out.println( "pageNum: " + pageNum );

                explanation.setText( getPageText( pageNum ) );
                System.out.println( "getPageText( pageNum ): " + getPageText( pageNum ) );
                if ( page == 2)
                {
                    back_butt.setVisibility( View.VISIBLE );
                }
                if ( page == 5 )
                {
                    next_butt.setVisibility( View.INVISIBLE );
                }

            }
        });

        back_butt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                page--;
                String pageNum = "pg" + page;
                System.out.println( "pageNum: " + pageNum );

                explanation.setText( getPageText( pageNum ) );
                System.out.println( "getPageText( pageNum ): " + getPageText( pageNum ) );
                if ( page == 1)
                {
                    back_butt.setVisibility( View.INVISIBLE );
                }
                if ( page == 4 )
                {
                    next_butt.setVisibility( View.VISIBLE );
                }

            }
        });

        xbutt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                intro_to_pinyin.getView().setVisibility(View.GONE);
            }
        });

        home_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                home_fragment.getView().setVisibility(View.VISIBLE );
            }
        });

        close_home_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                home_fragment.getView().setVisibility(View.INVISIBLE );
            }
        });

        first_tone.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                System.out.println( "FIRST TONE PLAYING");
                final MediaPlayer mp = MediaPlayer.create(FullMainScreenActivity.this, R.raw.tone_1);
                mp.setVolume( 100, 100 );
                mp.start();
            }
        });


        second_tone.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                final MediaPlayer mp = MediaPlayer.create(FullMainScreenActivity.this, R.raw.tone_2);
                mp.start();
            }
        });

        third_tone.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                final MediaPlayer mp = MediaPlayer.create(FullMainScreenActivity.this, R.raw.tone_3);
                mp.start();
            }
        });

        fourth_tone.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                final MediaPlayer mp = MediaPlayer.create(FullMainScreenActivity.this, R.raw.tone_4);
                mp.start();
            }
        });


        fifth_tone.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                final MediaPlayer mp = MediaPlayer.create(FullMainScreenActivity.this, R.raw.tone_5);
                mp.start();
            }
        });




        go_to_title_screen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent( FullMainScreenActivity.this, MainActivity.class );
                startActivity( intent );
            }
        });
        go_to_town.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                home_fragment.getView().setVisibility( View.INVISIBLE );
            }
        });


    }



    String getPageText( String currentPage )
    {
        tone_graphs.setVisibility( View.INVISIBLE );

        first_tone.setVisibility( View.INVISIBLE );
        second_tone.setVisibility( View.INVISIBLE );
        third_tone.setVisibility( View.INVISIBLE );
        fourth_tone.setVisibility( View.INVISIBLE );
        fifth_tone.setVisibility( View.INVISIBLE );

        if ( currentPage.equals( "pg1" ) )
        {
            return pg1;
        }
        if ( currentPage.equals( "pg2" ) )
        {
            return pg2;
        }
        if ( currentPage.equals( "pg3" ) )
        {
            tone_graphs.setVisibility( View.VISIBLE );
            return pg3;
        }
        if ( currentPage.equals( "pg4" ) )
        {
            first_tone.setVisibility( View.VISIBLE );
            second_tone.setVisibility( View.VISIBLE );
            third_tone.setVisibility( View.VISIBLE );
            fourth_tone.setVisibility( View.VISIBLE );
            fifth_tone.setVisibility( View.VISIBLE );
            return pg4;
        }
        if ( currentPage.equals( "pg5" ) )
        {
            return pg5;
        }

        return "error";
    }

//    public void addListenerOnChkIos( ) {
//
//        checkBox = (CheckBox) findViewById(R.id.checkbox);
//        checkBox.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                //is chkIos checked?
//                if (((CheckBox) v).isChecked()) {
//                    //shared preferences to stop shpwing tutorial
//                    editor.putBoolean("key_name", false);
//                    editor.commit();
//                }
//
//            }
//        });

//    }
}
