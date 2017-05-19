package lutz.ggc.edu.ggctarsosdspandroid;

/**
 * Created by Mario on 11/29/2016.
 */

public class LyricLine {

        private int seconds;
        private String lyric;

        public LyricLine(int _i, String _s) {
            seconds = _i;
            lyric = _s;
        }

        public String getLyric() {
            return lyric;
        }

        public void setLyric(String lyric) {
            this.lyric = lyric;
        }

        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }




}
