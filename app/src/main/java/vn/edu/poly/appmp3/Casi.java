package vn.edu.poly.appmp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import vn.edu.poly.appmp3.Activity.MVActivity;

public class Casi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casi);
    }

    public void trangcanhan(View view) {
        Intent intent = new Intent(Casi.this, TrangCaNhan.class);
        startActivity(intent);

    }

    public void nhacmoi(View view) {
        Intent intent = new Intent(Casi.this, NhacMoi.class);
        startActivity(intent);
    }

    public void mv(View view) {
        Intent intent = new Intent(Casi.this, MVActivity.class);
        startActivity(intent);
    }
}
