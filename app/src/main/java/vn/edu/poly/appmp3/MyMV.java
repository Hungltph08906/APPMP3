package vn.edu.poly.appmp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyMV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_mv);
    }

    public void back(View view) {
        Intent intent = new Intent(MyMV.this, TrangCaNhan.class);
        startActivity(intent);
    }
}
