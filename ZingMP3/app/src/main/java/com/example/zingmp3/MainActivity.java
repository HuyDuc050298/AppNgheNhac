package com.example.zingmp3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public boolean statusPlaySong = false;
    public ImageView imagePlayButton;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagePlayButton = findViewById(R.id.imageViewPlay);
        imagePlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(statusPlaySong == false){
                    imagePlayButton.setImageResource(R.drawable.buttonpause);  // tu them anh vao
                    mp.stop();
                    statusPlaySong = true;
                } else {
                    imagePlayButton.setImageResource(R.drawable.buttonplay);  // tu them anh vao
                    mp.start();
                    statusPlaySong = false;
                }
            }
        });
    }
}
