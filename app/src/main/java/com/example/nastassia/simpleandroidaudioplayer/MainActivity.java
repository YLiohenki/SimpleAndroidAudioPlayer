package com.example.nastassia.simpleandroidaudioplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {
    public static MediaPlayer mp = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView list = (ListView)findViewById(R.id.listView);
        final MainActivity that = this;

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mp != null)
                    mp.stop();
                mp = null;
                switch (position)
                {
                    case 0:
                        mp = MediaPlayer.create(that, R.raw.someprodigy);
                        break;
                    case 1:
                        mp = MediaPlayer.create(that, R.raw.boxcat);
                        break;
                    default:
                        break;
                }
                if (mp != null)
                    mp.start();
            }
        });



    }
}
