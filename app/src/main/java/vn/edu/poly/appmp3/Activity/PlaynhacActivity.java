package vn.edu.poly.appmp3.Activity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import vn.edu.poly.appmp3.Adapter.ViewPagerPlaylistnhac;
import vn.edu.poly.appmp3.Model.Baihat;
import vn.edu.poly.appmp3.R;
import vn.edu.poly.appmp3.Song;

public class PlaynhacActivity extends AppCompatActivity {

    TextView txtTitle, txtTimeSong, txtTimeTotal;
    SeekBar skSong;
    ImageView imgHinh;
    ViewPager viewPagerPlaynhac;
    public static ArrayList<Baihat> mangbaihat = new ArrayList<>();
    public static ViewPagerPlaylistnhac adapternhac;
    ImageButton btnPrev, btnPlay, btnStop, btnNext;

    ArrayList<Song> arraySong;
    int position = 0;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playnhac);
        Anhxa();
        GetDataFromIntent();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                position++;
                if (position > arraySong.size() - 1){
                    position = 0;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.pause);
                TimeSong();
                UpdateTimeSong();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                position--;
                if (position < 0){
                    position = arraySong.size() - 1;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer.start();

                btnPlay.setImageResource(R.drawable.pause);
                TimeSong();
                UpdateTimeSong();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                btnPlay.setImageResource(R.drawable.play1);
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                    //nếu đang phát --> pause --> đổi hình play
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.play1);
                }else {
                    //đang ngừng --> phát --> đổi hình pause
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.pause);
                }
                TimeSong();

            }
        });

        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                mediaPlayer.seekTo(skSong.getProgress());
            }
        });
    }

    private void GetDataFromIntent() {
        Intent intent = getIntent();
        mangbaihat.clear();
        if(intent != null){

            if (intent.hasExtra("cakhuc")){
                Baihat baihat = intent.getParcelableExtra("cakhuc");
                mangbaihat.add(baihat);
            }
            if (intent.hasExtra("cacbaihat")){
                ArrayList<Baihat> baihatArrayList = intent.getParcelableArrayListExtra("cacbaihat");
                mangbaihat = baihatArrayList;
            }
        }
    }

    private void Anhxa() {
        txtTimeSong  = (TextView) findViewById(R.id.textViewTimesong);
        txtTimeTotal = (TextView) findViewById(R.id.textTimetotal);
        txtTitle     = (TextView) findViewById(R.id.textviewTitle);
        skSong       = (SeekBar) findViewById(R.id.seekBar);
        btnNext      = (ImageButton) findViewById(R.id.imageButtonnext);
        btnPrev      = (ImageButton) findViewById(R.id.imageButtonpre);
        btnPlay      = (ImageButton) findViewById(R.id.imageButtonplay);
        btnStop      = (ImageButton) findViewById(R.id.imageButtonstop);
        if(mangbaihat.size()>0){
            getSupportActionBar().setTitle(mangbaihat.get(0).getTenBaihat());
            new PlayMp3().execute(mangbaihat.get(0).getLinkBaihat());
        }
//        adapternhac = new ViewPagerPlaylistnhac(getSupportFragmentManager());
//        adapternhac.AddFragment();
    }
    class PlayMp3 extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];

        }

        @Override
        protected void onPostExecute(String baihat) {
            super.onPostExecute(baihat);
            try {
            mediaPlayer= new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            });

                mediaPlayer.setDataSource(baihat);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            TimeSong();
        }
    }

    private void TimeSong() {
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        txtTimeTotal.setText(dinhDangGio.format(mediaPlayer.getDuration()));
        //gán max của skSong  = MediaPlay.getDuration();
        skSong.setMax(mediaPlayer.getDuration());
    }
    private void UpdateTimeSong(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                txtTimeSong.setText(dinhDangGio.format(mediaPlayer.getCurrentPosition()));
                //update progress skSong
                skSong.setProgress(mediaPlayer.getCurrentPosition());

                //kiểm tra thời gian bài hát --> nếu kết thúc --> next

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if (position > arraySong.size() - 1){
                            position = 0;
                        }
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        mediaPlayer.start();
                        btnPlay.setImageResource(R.drawable.pause);
                        TimeSong();
                        UpdateTimeSong();

                    }
                });
                handler.postDelayed(this, 500);
            }
        },100);
    }
}
