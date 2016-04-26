package com.example.nastassia.simpleandroidaudioplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PlayingStatusListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView list = (ListView)findViewById(R.id.listView);
        final MainActivity that = this;
        final SoundsDescriptions soundsDescriptions = new SoundsDescriptions();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyPlayer.playSomeFile(that, soundsDescriptions.getSound(position).FileId, that);
                TextView songlabel = (TextView) findViewById(R.id.currentSongLabel);
                songlabel.setText(soundsDescriptions.getSound(position).Name);
                SoundDescriptionActivity.currentSongIndex = position;
            }
        });
        Button stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlayer.pause();
            }
        });
        Button resumeButton = (Button) findViewById(R.id.resumeButton);
        resumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlayer.play();
            }
        });

        TextView songlabel = (TextView) findViewById(R.id.currentSongLabel);
        songlabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(that.getBaseContext(), SoundDescriptionActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onStopPlaying()
    {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView songlabel = (TextView) findViewById(R.id.currentSongLabel);
                songlabel.setText("Select song");
            }
        });
    }

}
