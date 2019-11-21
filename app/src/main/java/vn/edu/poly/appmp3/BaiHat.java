package vn.edu.poly.appmp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class BaiHat extends AppCompatActivity {
    RecyclerView mRecyclerView;
    BaihatAdater mRcvAdapter;
    ArrayList<Baihatclass> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_hat);

//        mRecyclerView = (RecyclerView) findViewById(R.id.rcvbathat);
//        data.add(new Baihatclass("Simple Love","Obito","3:34",R.drawable.simplelove));
//        mRcvAdapter = new BaihatAdater(data);
//
//        mRecyclerView.setAdapter(mRcvAdapter);

    }


    public void back(View view) {
        Intent intent = new Intent(BaiHat.this, TrangCaNhan.class);
        startActivity(intent);
    }

    public void play1(View view) {
        Intent intent = new Intent(BaiHat.this, PlayActivity.class);
        startActivity(intent);

    }
}
