package vn.edu.poly.appmp3.Activity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.io.IOException;
import java.util.ArrayList;

import vn.edu.poly.appmp3.Adapter.ViewPagerPlaylistnhac;
import vn.edu.poly.appmp3.Fragment.Fragment_Dianhac;
import vn.edu.poly.appmp3.Fragment.Fragment_Playdanhsachbaihat;
import vn.edu.poly.appmp3.Model.Baihat;
import vn.edu.poly.appmp3.R;

public class PlaynhacActivity extends AppCompatActivity {

    TextView tvtimesong,tvtataltimesong;
    SeekBar sktime;
    ImageButton imgplay,imgpre,imgnext,imgrepeat,imgsuffer;
    ViewPager viewPagerplaynhac;
    public static ArrayList<Baihat> mangbaihat = new ArrayList<>();
    public static ViewPagerPlaylistnhac adapternhac;
    Fragment_Dianhac fragment_dianhac;
    Fragment_Playdanhsachbaihat fragment_playdanhsachbaihat;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playnhac);
        init();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        GetDataFromIntent();
        enventClick();



    }

    private void enventClick() {
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (adapternhac.getItem(1)!= null){
//                    if(mangbaihat.size()>0){
//                        mediaPlayer.start();
//                    }
//                }
//
//            }
//        },500);
        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    imgplay.setImageResource(R.drawable.play);

                }else {
                    mediaPlayer.start();
                    imgplay.setImageResource(R.drawable.stop);
                }
            }
        });
    }

    private void GetDataFromIntent() {
        Intent intent = getIntent();
        mangbaihat.clear();
        enventClick();
        if (intent!=null){
            if (intent.hasExtra("cakhuc")){
                Baihat baihat = intent.getParcelableExtra("cakhuc");;
                mangbaihat.add(baihat);
                MediaPlayer mediaPlayer = new MediaPlayer();
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
            }
            if (intent.hasExtra("cacbaihat")){
                ArrayList<Baihat> baihatArrayList = intent.getParcelableArrayListExtra("cacbaihat");
                mangbaihat = baihatArrayList;
            }
        }

    }

    private void init() {
        sktime = findViewById(R.id.seekBar);
        tvtimesong = findViewById(R.id.tvtimesong);
        tvtataltimesong = findViewById(R.id.tvtotaltimesong);
        imgplay = findViewById(R.id.imgplay);
        imgpre = findViewById(R.id.imgpre);
        imgnext = findViewById(R.id.imgnext);
        imgrepeat = findViewById(R.id.imgrepeat);
        imgsuffer = findViewById(R.id.imgsuffle);
        fragment_dianhac = new Fragment_Dianhac();
        fragment_playdanhsachbaihat = new Fragment_Playdanhsachbaihat();
        viewPagerplaynhac = findViewById(R.id.viewpagerplaynhac);
        adapternhac = new ViewPagerPlaylistnhac(getSupportFragmentManager());
//        adapternhac.AddFragment(fragment_dianhac);
//        adapternhac.AddFragment(fragment_playdanhsachbaihat);
        viewPagerplaynhac.setAdapter(adapternhac);
//        if (mangbaihat.size()>0){
//            getSupportActionBar().setTitle(mangbaihat.get(0).getTenBaihat());
//            new PlayMp3().execute(mangbaihat.get(0).getLinkBaihat());
//            imgplay.setImageResource(R.drawable.stop);
//            fragment_dianhac = (Fragment_Dianhac) adapternhac.getItem(1);
//        }
    }
//    class PlayMp3 extends AsyncTask<String, Void, String>{
//
//        @Override
//        protected String doInBackground(String... strings) {
//            return strings[0];
//
//        }
//
//        @Override
//        protected void onPostExecute(String baihat) {
//
//            super.onPostExecute(baihat);
//            try {
//            mediaPlayer = new MediaPlayer();
//            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mp) {
//                    mediaPlayer.stop();
//                    mediaPlayer.reset();
//                }
//            });
//            mediaPlayer.setDataSource(baihat);
//            mediaPlayer.prepare();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            mediaPlayer.start();
//            TimeSong();
//        }
//    }
//
//    private void TimeSong() {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
//        tvtataltimesong.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
//        sktime.setMax(mediaPlayer.getDuration());
//    }
}
