package com.example.languagelearningtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotostoreFront extends AppCompatActivity {

    ImageButton audio, home_button, close_home_button;
    Button go_to_title_screen, go_to_town;
    Fragment home_fragment;

    String[] pg1 = {
            " 歡迎光臨!",
            "Huānyíng guānglín!",
            "Welcome!"

    };

    String[] pg2 = {
            "你想要什麼樣的照片呢?",
            "Nǐ xiǎng yào shénme yàng de zhàopiàn ne?",
            "What kind of photo would you like?"
    };

    String[] pg3 = {
            "啊！你是不是呢個剛搬到這裡的外國人?" ,
                    "A! Nǐ  shì bùshì ne gè gāng bān dào zhèlǐ de wàiguó rén,!",
                    "Oh! Aren’t you that foreigner that just moved here?"
    };

    String[] pg4 = {
            "你會講中文嗎?",
            "Nǐ huì jiǎng zhōngwén ma?",
            "Can you speak Chinese?"
    };

    String[] pg5 = {
            "你可以說『你好』嗎？",
            "Nǐ kěyǐ shuō “nǐ hǎo” ma?",
            "Can you say \"hello\"?"
    };

    String[] pg6 = {
            "哇！說得很好",
            "Wa! Shuō dé hěn hǎo!",
            "Wow! You said that well!"
    };

    String[] pg6_alternate = {
            "哈哈，我覺得你還需要學習一點！可是，我可以看到潜力！",
            "Hāhā, wǒ juédé nǐ hái xūyào xuéxí yīdiǎn! Kěshì, wǒ kěyǐ kàn dào qiánlì!",
            "Haha, I think you still need to learn a little! But I see potential!"
    };

    String[] pg7 = {
            "你想要我幫你學中文嗎？",
            "Nǐ xiǎng yào wǒ bāng nǐ xué zhōngwén ma?",
            "Do you want me to help you learn Chinese?"
    };

    String[] pg8 = {
            "等一下回來吧！我會教你中文！",
            "Děng yīxià huílái ba! Wǒ huì jiào nǐ zhōngwén!",
            "Come back later! I’ll teach you Chinese!"

};

    String[] pg9 = {
            "你現在去隔壁的書店吧！",
            "Nǐ xiànzài qù gébì de shūdiàn ba!",
            "You should go to the bookstore next door right now!"
    };

    String[] pg10 = {
            "再見！",
            "Zàijiàn!",
            "Bye!"
    };


    int pageNumber = 1;
    int lastPage = 10;

    Button next_butt, back_butt;
    TextView english_text, chinese_text, pinyin_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photostore_front);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        go_to_title_screen = findViewById( R.id.go_to_title_screen );
        go_to_town = findViewById( R.id.go_to_fullscreen);
        close_home_button = findViewById( R.id.close_home_button);
        home_fragment = getSupportFragmentManager().findFragmentById( R.id.home_menu );
        home_fragment.getView().setVisibility( View.INVISIBLE );
        audio = findViewById( R.id.audio);
        home_button = findViewById( R.id.home_button );
        final MediaPlayer conv1 = MediaPlayer.create(this, R.raw.convo_1_1);
        final MediaPlayer conv2  = MediaPlayer.create(this, R.raw.convo_1_2);
        final MediaPlayer conv3 = MediaPlayer.create(this, R.raw.convo_1_3);
        final MediaPlayer conv4  = MediaPlayer.create(this, R.raw.convo_1_4);
        final MediaPlayer conv5  = MediaPlayer.create(this, R.raw.convo_1_5);
        final MediaPlayer conv6 = MediaPlayer.create(this, R.raw.convo_1_6);
        final MediaPlayer conv7 = MediaPlayer.create(this, R.raw.convo_1_7);
        final MediaPlayer conv8 = MediaPlayer.create(this, R.raw.convo_1_8);
        final MediaPlayer conv9 = MediaPlayer.create(this, R.raw.convo_1_9);
        final MediaPlayer conv10 = MediaPlayer.create(this, R.raw.convo_1_10);

        audio.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if ( pageNumber == 1  )
                {
                    conv1.start();
                }

                if ( pageNumber == 2  )
                {
                    conv2.start();
                }

                if ( pageNumber == 3  )
                {
                    conv3.start();
                }

                if ( pageNumber == 4  )
                {
                    conv4.start();
                }

                if ( pageNumber == 5  )
                {
                    conv5.start();
                }

                if ( pageNumber == 6  )
                {
                    conv6.start();
                }

                if ( pageNumber == 7  )
                {
                    conv7.start();
                }

                if ( pageNumber == 8  )
                {
                    conv8.start();
                }

                if ( pageNumber == 9  )
                {
                    conv9.start();
                }

                if ( pageNumber == 10  )
                {
                    conv10.start();
                }



            }
        });

        home_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent( PhotostoreFront.this, HomeButton.class );
                startActivity( intent );
            }
        });

        next_butt = findViewById( R.id.next_butt );
        back_butt = findViewById( R.id.back_butt );
        english_text = findViewById( R.id.english_text );
        chinese_text= findViewById( R.id.chinese_text);
        pinyin_text = findViewById( R.id.pinyin_text);

        back_butt.setVisibility( View.INVISIBLE );


        next_butt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                pageNumber++;
                String pageNum = "pg" + pageNumber;
                System.out.println( "pageNum: " + pageNumber );

                chinese_text.setText( getPageText( pageNum )[0] );
                pinyin_text.setText( getPageText( pageNum )[1] );
                english_text.setText( getPageText( pageNum )[2] );

                System.out.println( "getPageText( pageNum ): " + getPageText( pageNum ) );
                if ( pageNumber == 2)
                {
                    back_butt.setVisibility( View.VISIBLE );
                }
                if ( pageNumber == lastPage )
                {
                    next_butt.setVisibility( View.INVISIBLE );
                }

            }
        });

        back_butt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                pageNumber--;
                String pageNum = "pg" + pageNumber;
                System.out.println( "pageNum: " + pageNum );

                chinese_text.setText( getPageText( pageNum )[0] );
                pinyin_text.setText( getPageText( pageNum )[1] );
                english_text.setText( getPageText( pageNum )[2] );

                System.out.println( "getPageText( pageNum ): " + getPageText( pageNum ) );
                if ( pageNumber == 1)
                {
                    back_butt.setVisibility( View.INVISIBLE );
                }
                if ( pageNumber == lastPage - 1 )
                {
                    next_butt.setVisibility( View.VISIBLE );
                }

            }
        });

        home_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                home_fragment.getView().setVisibility(View.VISIBLE );
            }
        });

        go_to_title_screen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent( PhotostoreFront.this, MainActivity.class );
                startActivity( intent );
            }
        });
        go_to_town.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent( PhotostoreFront.this, FullMainScreenActivity.class );
                startActivity( intent );
            }
        });

        close_home_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                home_fragment.getView().setVisibility(View.INVISIBLE );
            }
        });

    }




    String[] getPageText( String currentPage )
    {

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
            return pg3;
        }
        if ( currentPage.equals( "pg4" ) )
        {
            return pg4;
        }
        if ( currentPage.equals( "pg5" ) )
        {
            return pg5;
        }
        if ( currentPage.equals( "pg6" ) )
        {
            return pg6;
        }
        if ( currentPage.equals( "pg7" ) )
        {
            return pg7;
        }
        if ( currentPage.equals( "pg8" ) )
        {
            return pg8;
        }
        if ( currentPage.equals( "pg9" ) )
        {
            return pg9;
        }
        if ( currentPage.equals( "pg10" ) )
        {
            return pg10;
        }


        String[] error = {"error"};
        return error;
    }
}
