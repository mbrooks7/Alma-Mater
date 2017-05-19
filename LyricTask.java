package lutz.ggc.edu.ggctarsosdspandroid;

/**
 * Created by Mario on 11/29/2016.
 */

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.value;

public class LyricTask extends AsyncTask<Void, Integer, Void> {

    private MediaPlayer player;
    private TextView tvResult;

    private ArrayList<LyricLine> lyrics;
    private int nextLyricNumber = 0;


    @Override
    protected void onCancelled() {
        super.onCancelled();
        tvResult.setText("");
        Log.i("alma", "onCancelled() called");
    }

    public LyricTask(MediaPlayer player, TextView tvResult) {
        this.player = player;
        this.tvResult = tvResult;
        lyrics = new ArrayList<>();

        int delay = -4;
        lyrics.add(new LyricLine(0, "(Music)"));
        lyrics.add(new LyricLine(12+delay, "We have gained wisdom and honor"));
        lyrics.add(new LyricLine(17+delay, "From our home of green and grey"));
        lyrics.add(new LyricLine(20+delay, "We will go forth and remember"));
        lyrics.add(new LyricLine(25+delay, "How we’ve learned along the way"));
        lyrics.add(new LyricLine(29+delay, "And with knowledge and compassion"));
        lyrics.add(new LyricLine(32+delay, "We will build communities"));
        lyrics.add(new LyricLine(38+delay, "Leading by example"));
        lyrics.add(new LyricLine(42+delay, "And with dignity"));
        lyrics.add(new LyricLine(46+delay, "Georgia Gwinnett"));
        lyrics.add(new LyricLine(50+delay, "We’ll nv’r forget"));
        lyrics.add(new LyricLine(54+delay, "How we have grown"));
        lyrics.add(new LyricLine(57+delay, "and those that we met"));
        lyrics.add(new LyricLine(62+delay, "Georgia Gwinnett"));
        lyrics.add(new LyricLine(66+delay, "With love and respect"));
        lyrics.add(new LyricLine(70+delay, "Our alma mater"));
        lyrics.add(new LyricLine(74+delay, "Georgia Gwinnett"));
        lyrics.add(new LyricLine(78+delay, "Our alma mater"));
        lyrics.add(new LyricLine(83+delay, "Georgia Gwinnett"));

    }

    @Override
    protected Void doInBackground(Void... voids) {
        while (!isCancelled()) {
            int elapsed = player.getCurrentPosition();
            if (elapsed/1000 > lyrics.get(nextLyricNumber).getSeconds()) {
                Log.i("alma", "" + nextLyricNumber);
                publishProgress(new Integer[] {nextLyricNumber});
                if (nextLyricNumber < (lyrics.size()-1) )
                    nextLyricNumber++;
                else
                    return null;
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        tvResult.setText(lyrics.get(values[0]).getLyric());
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //tvResult.setText("Done!");
    }
}