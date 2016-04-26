package com.example.nastassia.simpleandroidaudioplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {
    public static Integer currentSongIndex = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_description);

        final SoundsDescriptions soundsDescriptions = new SoundsDescriptions();

        Sound sound = soundsDescriptions.getSound(currentSongIndex);
        TextView songNamelabel = (TextView) findViewById(R.id.descName);
        songNamelabel.setText(sound.Name);
        TextView songLengthlabel = (TextView) findViewById(R.id.descrLength);
        songLengthlabel.setText(sound.LengthMinutes + ":" + sound.LengthSeconds);
        TextView songCountrylabel = (TextView) findViewById(R.id.descrCountry);
        songCountrylabel.setText(sound.Country);

        final DescriptionActivity that = this;
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(that, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
