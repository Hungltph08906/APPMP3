package vn.edu.poly.appmp3.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.poly.appmp3.R;
import vn.edu.poly.appmp3.TrangCaNhan;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view) {
        Intent intent = new Intent(MainActivity.this, TrangCaNhan.class);
        startActivity(intent);
    }
}
