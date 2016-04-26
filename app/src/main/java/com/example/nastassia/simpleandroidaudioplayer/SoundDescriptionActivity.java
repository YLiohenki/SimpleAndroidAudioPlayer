package com.example.nastassia.simpleandroidaudioplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SoundDescriptionActivity extends AppCompatActivity {
    public static Integer currentSongIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_description);

        final SoundsDescriptions soundsDescriptions = new SoundsDescriptions();

        Sound sound = soundsDescriptions.getSound(currentSongIndex);
        TextView songNamelabel = (TextView) findViewById(R.id.descName);
        songNamelabel.setText(sound.Name);
        TextView songLengthlabel = (TextView) findViewById(R.id.descrLength);
        songLengthlabel.setText(sound.LengthMinutes + ":" + sound.LengthSeconds);
        TextView songCountrylabel = (TextView) findViewById(R.id.descrCountry);
        songCountrylabel.setText(sound.Country);
        TextView songDescrlabel = (TextView) findViewById(R.id.descrDescription);
        songDescrlabel.setText(sound.Description);

        final SoundDescriptionActivity that = this;
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
