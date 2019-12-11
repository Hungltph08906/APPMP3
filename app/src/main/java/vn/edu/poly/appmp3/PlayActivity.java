package vn.edu.poly.appmp3;

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

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    TextView txtTitle, txtTimeSong, txtTimeTotal;
    SeekBar skSong;
    ImageView imgHinh;
    ImageButton btnPrev, btnPlay, btnStop, btnNext;

    ArrayList<Song> arraySong;
    int position = 0;
    MediaPlayer mediaPlayer;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Anhxa();
        AddSong();

        KhoiTaoMediaPlayr();
//        mediaPlayer = MediaPlayer.create(MainActivity.this, arraySong.get(position).getFile());
//        txtTitle.setText(arraySong.get(position).getTitle());
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
                KhoiTaoMediaPlayr();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.pause);
                SetTimTotal();
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
                KhoiTaoMediaPlayr();
                mediaPlayer.start();

                btnPlay.setImageResource(R.drawable.pause);
                SetTimTotal();
                UpdateTimeSong();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                btnPlay.setImageResource(R.drawable.play1);
                KhoiTaoMediaPlayr();
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
                        position++;
                        if (position > arraySong.size() - 1){
                            position = 0;
                        }
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        KhoiTaoMediaPlayr();
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

    private void KhoiTaoMediaPlayr(){
        mediaPlayer = MediaPlayer.create(PlayActivity.this, arraySong.get(position).getFile());
        txtTitle.setText(arraySong.get(position).getTitle());
    }

    private void AddSong() {
        arraySong = new ArrayList<>();
        arraySong.add(new Song("Chuyện Ba Người",R.raw.chuyen_ba_nguoi));
        arraySong.add(new Song("I dont believe in you", R.raw.i_dont_believe_in_you));
        arraySong.add(new Song("Lặng Lẽ Buông", R.raw.lang_le_buong));
        arraySong.add(new Song("Em Giấu Anh Điều GÌ", R.raw.lem_giau_anh_dieu_gi));
        arraySong.add(new Song("Em Về Đi Em", R.raw.lem_ve_di_em));
        arraySong.add(new Song("Giá Như", R.raw.lgia_nhu));
        arraySong.add(new Song("Nếu Không Thể Đến Với Nhau", R.raw.neu_khong_the_den_voi_nhau));
        arraySong.add(new Song("Quay Lưng Về Nhau", R.raw.quay_lung_ve_nhau));
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
