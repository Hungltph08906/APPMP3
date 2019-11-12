package vn.edu.poly.appmp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TrangCaNhan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_ca_nhan);
    }

    public void baihat(View view) {
        Intent intent = new Intent(TrangCaNhan.this, BaiHat.class);
        startActivity(intent);
    }

    public void playlist(View view) {
        Intent intent = new Intent(TrangCaNhan.this, Playlist.class);
        startActivity(intent);
    }

    public void album(View view) {
        Intent intent = new Intent(TrangCaNhan.this, Album.class);
        startActivity(intent);
    }

    public void baihatdatai(View view) {
        Intent intent = new Intent(TrangCaNhan.this, Baihatdatai.class);
        startActivity(intent);
    }

    public void nhacmoi(View view) {
        Intent intent = new Intent(TrangCaNhan.this, NhacMoi.class);
        startActivity(intent);
    }

    public void casi(View view) {
        Intent intent = new Intent(TrangCaNhan.this, Casi.class);
        startActivity(intent);
    }

    public void mv(View view) {
        Intent intent = new Intent(TrangCaNhan.this, MV.class);
        startActivity(intent);
    }

    public void mymv(View view) {
        Intent intent = new Intent(TrangCaNhan.this, MyMV.class);
        startActivity(intent);
    }
}
