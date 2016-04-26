package com.example.nastassia.simpleandroidaudioplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.AsyncTask;

public class MyPlayer {
    protected static MediaPlayer mp = null;
    protected static PlayingStatusListener listener = null;
    protected static PlayingTask task = null;
    public static void playSomeFile(Context context, int FileId, PlayingStatusListener Listener)
    {
        if (mp != null) {
            mp.stop();
        }
        if (listener != null) {
            listener.onStopPlaying();
        }
        if (task != null) {
            task.cancel(true);
        }

        mp = MediaPlayer.create(context, FileId);
        listener = Listener;
        task = new PlayingTask();
        if (mp != null)
            task.execute(0, 0, 0);
    }

    public static void stop()
    {
        if (mp != null)
            mp.stop();
        if (listener != null)
            listener.onStopPlaying();
        if (task != null) {
            task.cancel(true);
        }
        mp = null;
        listener = null;
        task = null;
    }

    public static void pause()
    {
        if (mp != null)
            mp.pause();
    }

    public static void play()
    {
        if (mp != null)
            mp.start();
    }

    private static class PlayingTask extends AsyncTask<Integer, Integer, Integer> {
        protected Integer doInBackground(Integer... params) {
            mp.start();
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    listener.onStopPlaying();
                }
            });
            return 0;
        }
    }
}

interface PlayingStatusListener {
    void onStopPlaying();
}

