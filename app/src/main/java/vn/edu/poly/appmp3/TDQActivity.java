package vn.edu.poly.appmp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TDQActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdq);
    }

    public void back(View view) {
        Intent intent = new Intent(TDQActivity.this, PlayActivity.class);
        startActivity(intent);
    }

    public void play1(View view) {
        Intent intent = new Intent(TDQActivity.this, PlayActivity.class);
        startActivity(intent);
    }
}
