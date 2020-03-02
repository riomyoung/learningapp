package com.example.languagelearningtime;

//textView.setMovement( new ScrollingMovementMethod() );


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Book extends AppCompatActivity {

    int pageNumber = 0;
    int lastPage = 12;
    ArrayList<ArrayList<String>> currentBook;
    ArrayList<String> chinese_arraylist;
    ArrayList<String> pinyin_arraylist;
    ArrayList<String> english_arraylist;
//    Intent intent = getIntent();
    int bookNum;


    TextView chinese_text, english_text, pinyin_text;
    Button next_button, back_button;
    ImageButton home_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        getWindow().setLayout((int) (width * .8), (int) (.6 * height));


        currentBook = new ArrayList<>();
        chinese_arraylist = new ArrayList<>();
        pinyin_arraylist = new ArrayList<>();
        english_arraylist = new ArrayList<>();

        currentBook.add( chinese_arraylist );
        currentBook.add( pinyin_arraylist );
        currentBook.add( english_arraylist );
//        want_to_buy.add( new ArrayList<String>("abc","def","ghi"));


        Intent intent = getIntent();
        bookNum = intent.getIntExtra("bookNum", 1);





        chinese_text = findViewById( R.id.book_text_chinese );
        pinyin_text = findViewById( R.id.book_text_pinyin);
        english_text= findViewById( R.id.book_text_english );

        next_button = findViewById( R.id.book_next_button);
        back_button = findViewById( R.id.book_back_button );

        Resources res = getResources();
        String[] book1 = res.getStringArray( whichBook() );
//        System.out.println( arrayToString( book1 ) );
        populateDoubleArray( book1 );
        System.out.println( "CHINESE ARRAYLIST");
        System.out.println( chinese_arraylist);
        System.out.println( "PINYIN ARRAYLIST");
        System.out.println( pinyin_arraylist);
        System.out.println( "ENGLISH ARRAYLIST");
        System.out.println( english_arraylist );

        chinese_text.setText( currentBook.get(0).get(0) );
        pinyin_text.setText( currentBook.get(1).get(0) );
        english_text.setText( currentBook.get(2).get(0) );


        next_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                pageNumber++;
                String pageNum = "pg" + pageNumber;
                System.out.println( "pageNum: " + pageNumber );

                chinese_text.setText( chinese_arraylist.get( pageNumber ) );
                pinyin_text.setText( pinyin_arraylist.get( pageNumber ) );
                english_text.setText( english_arraylist.get( pageNumber ) );

                if ( pageNumber == 2)
                {
                    back_button.setVisibility( View.VISIBLE );
                }
                if ( pageNumber == lastPage )
                {
                    next_button.setVisibility( View.INVISIBLE );
                }

            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                pageNumber--;
                String pageNum = "pg" + pageNumber;
                System.out.println( "pageNum: " + pageNum );

                chinese_text.setText( chinese_arraylist.get( pageNumber ) );
                pinyin_text.setText( pinyin_arraylist.get( pageNumber ) );
                english_text.setText( english_arraylist.get( pageNumber ) );

                if ( pageNumber == 1)
                {
                    back_button.setVisibility( View.INVISIBLE );
                }
                if ( pageNumber == lastPage - 1 )
                {
                    next_button.setVisibility( View.VISIBLE );
                }

            }
        });
    }

    public int whichBook()
    {
        if ( bookNum == 1 )
        {
            return R.array.book1;
        }
        if ( bookNum == 2 )
        {
            return R.array.book2;
        }

        else return 0;
    }

    public String arrayToString( String[] array )
    {
        String stringResult = "";

        for ( int i = 0; i < array.length; i++ )
        {
            stringResult += array[ i ] + "\n";
        }
        return stringResult;
    }
    public String arrayListToString( ArrayList<String> arrayList )
    {
        String stringResult = "";

        for ( int i = 0; i < arrayList.size(); i++ )
        {
            stringResult += arrayList.get( i )+ "\n";
        }
        return stringResult;
    }

    public void populateDoubleArray( String[] array )
    {
        System.out.println( "ARRAY: " + arrayToString( array ) );
        int i = 0;
        int x = 0;
        while ( i < 3 )
        {
            while ( x < array.length - 1 )
            {
                if ( array[ x ].equals( "xxx" ) )
                {
                    i++;
                    x++;
                    System.out.println( "NEXT ARRAYLIST");
                }
                currentBook.get( i ).add( array[x] );
                x++;
                System.out.println( "NEW LINE: " + array[x] );
//                System.exit(0);
            }
            if ( x >= array.length - 1 )
            {
                i++;
            }

        }

        System.out.println( "FINISED POPULATING");

    }
}
