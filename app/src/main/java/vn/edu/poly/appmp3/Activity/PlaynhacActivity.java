package vn.edu.poly.appmp3.Activity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import vn.edu.poly.appmp3.Model.Baihat;
import vn.edu.poly.appmp3.R;

public class PlaynhacActivity extends AppCompatActivity {

    TextView txtTitle, txtTimeSong, txtTimeTotal;
    SeekBar skSong;
    ImageView imgHinh;
    ImageButton btnPrev, btnPlay, btnStop, btnNext;

    ArrayList<Baihat> arraySong;
    int position = 0;
    MediaPlayer mediaPlayer = new MediaPlayer();
    Animation animation;
    public static ArrayList<Baihat> mangbaihat = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Anhxa();

        GetDataFromIntent();
        SetTimTotal();
        UpdateTimeSong();
        btnPlay.setImageResource(R.drawable.pause);
//        mediaPlayer = MediaPlayer.create(MainActivity.this, arraySong.get(position).getFile());
//        txtTitle.setText(arraySong.get(position).getTitle());
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int currentPosition = mediaPlayer.getCurrentPosition();
                int duration = mediaPlayer.getDuration();
                // 5 giây.
                int ADD_TIME = 5000;

                if(currentPosition + ADD_TIME < duration) {
                    mediaPlayer.seekTo(currentPosition + ADD_TIME);
                }
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int currentPosition = mediaPlayer.getCurrentPosition();
                int duration = mediaPlayer.getDuration();

                // 5 giây.
                int SUBTRACT_TIME = 5000;

                if(currentPosition - SUBTRACT_TIME > 0 )  {
                    mediaPlayer.seekTo(currentPosition - SUBTRACT_TIME);
                }
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
                SetTimTotal();
                UpdateTimeSong();

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
//                        position++;
//                        if (position > arraySong.size() - 1){
//                            position = 0;
//                        }
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        GetDataFromIntent();
                        mediaPlayer.start();
                        btnPlay.setImageResource(R.drawable.pause);
                        SetTimTotal();
                        UpdateTimeSong();

                    }
                });
                handler.postDelayed(this, 500);
            }
        },100);
    }


    private void SetTimTotal(){

        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        txtTimeTotal.setText(dinhDangGio.format(mediaPlayer.getDuration()));
        //gán max của skSong  = MediaPlay.getDuration();
        skSong.setMax(mediaPlayer.getDuration());
    }

    private void GetDataFromIntent() {
        Intent intent = getIntent();
        mangbaihat.clear();
        if (intent!=null){
            if (intent.hasExtra("cakhuc")){
                Baihat baihat = intent.getParcelableExtra("cakhuc");;
                mangbaihat.add(baihat);

                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(baihat.getLinkBaihat());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mediaPlayer.prepare(); // might take long! (for buffering, etc)
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
                txtTitle.setText(baihat.getTenBaihat());

            }
            if (intent.hasExtra("cacbaihat")){
                ArrayList<Baihat> baihatArrayList = intent.getParcelableArrayListExtra("cacbaihat");
                mangbaihat = baihatArrayList;
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(mangbaihat.get(0).getLinkBaihat());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mediaPlayer.prepare(); // might take long! (for buffering, etc)
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
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
    }
}
