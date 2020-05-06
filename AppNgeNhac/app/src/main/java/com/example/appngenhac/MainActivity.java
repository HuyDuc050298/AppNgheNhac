package com.example.appngenhac;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ImageView playbutton, nextbutton, previousbutton;
    public TextView namesong;
    public List<Song> listsong = new ArrayList<>();
    public MediaPlayer media;
    public int positionsong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playbutton = findViewById(R.id.ic_play);
        nextbutton = findViewById(R.id.ic_next);
        previousbutton = findViewById(R.id.ic_previous);
        namesong = findViewById(R.id.name_song);
        createlistsong();
        changesong();
        media = MediaPlayer.create(MainActivity.this, listsong.get(positionsong).getFilemp3());
        media.start();
        namesong.setText(listsong.get(positionsong).getNamesong());

        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (media.isPlaying()) {
                    media.pause();
                    playbutton.setImageResource(R.drawable.icon_pause);
                } else {
                    media.start();
                    playbutton.setImageResource(R.drawable.icon_play);
                }
            }
        });
    }

    public void createlistsong() {
        Song emsairoi = new Song("Em sai rồi anh xin lỗi em đi", R.raw.emsairoianhxinloixemdi);
        Song moianhvaoteamem = new Song("Mời anh vào team em", R.raw.moianhvaoteamem);
        Song tuhomnay = new Song("Từ hôm nay", R.raw.tuhomnay);
        listsong.add(emsairoi);
        listsong.add(moianhvaoteamem);
        listsong.add(tuhomnay);
    }

    public void changesong() {
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((positionsong + 1) < listsong.size()) {
                    positionsong++;
                    controlchangesong();
                } else {
                    positionsong = 0;
                    controlchangesong();
                }
            }
        });

        previousbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positionsong > 0) {
                    positionsong--;
                    controlchangesong();
                } else {
                    positionsong = 0;
                    controlchangesong();
                }
            }
        });
    }

    public void controlchangesong() {
        if (media.isPlaying()) {
            media.stop();
        }
        media = MediaPlayer.create(MainActivity.this, listsong.get(positionsong).getFilemp3());
        media.start();
        namesong.setText(listsong.get(positionsong).getNamesong());
    }
}
