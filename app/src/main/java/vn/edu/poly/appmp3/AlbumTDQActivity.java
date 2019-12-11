package vn.edu.poly.appmp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.poly.appmp3.Activity.AlbumActivity;

public class AlbumTDQActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_tdq);
    }

    public void back(View view) {
        Intent intent = new Intent(AlbumTDQActivity.this, AlbumActivity.class);
        startActivity(intent);
    }

    public void play1(View view) {
        Intent intent = new Intent(AlbumTDQActivity.this, PlayActivity.class);
        startActivity(intent);
    }
}
