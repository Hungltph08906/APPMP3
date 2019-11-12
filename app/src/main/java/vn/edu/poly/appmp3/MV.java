package vn.edu.poly.appmp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mv);
    }

    public void trangcanhan(View view) {
        Intent intent = new Intent(MV.this, TrangCaNhan.class);
        startActivity(intent);
    }

    public void nhacmoi(View view) {
        Intent intent = new Intent(MV.this, NhacMoi.class);
        startActivity(intent);
    }

    public void casi(View view) {
        Intent intent = new Intent(MV.this, Casi.class);
        startActivity(intent);
    }
}
