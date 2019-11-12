package vn.edu.poly.appmp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Baihatdatai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baihatdatai);
    }
    public void back(View view) {
        Intent intent = new Intent(Baihatdatai.this, TrangCaNhan.class);
        startActivity(intent);
    }
}
