package vn.edu.poly.appmp3.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.poly.appmp3.Model.Baihat;
import vn.edu.poly.appmp3.R;

public class PlaynhacActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playnhac);
        Intent intent = getIntent();
        if (intent.hasExtra("cakhuc")){
            Baihat baihat = intent.getParcelableExtra("cakhuc");
            Toast.makeText(this,baihat.getTenBaihat(),Toast.LENGTH_SHORT).show();;
        }
    }
}
