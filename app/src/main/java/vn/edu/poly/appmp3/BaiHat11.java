package vn.edu.poly.appmp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BaiHat11 extends AppCompatActivity {
    RecyclerView mRecyclerView;
    BaihatAdater mRcvAdapter;
    ArrayList<Baihatclass> data;
    List<Baihatclass> list = new ArrayList<>();
    BaihatAdater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_hat);

        mRecyclerView = (RecyclerView) findViewById(R.id.rcvbaihat);
        list.add(new Baihatclass("Simple Love","Obito","3:34",R.drawable.simplelove));
        list.add(new Baihatclass("Thất Tình","Trịnh Đình Quang","4:34",R.drawable.tdq1));
//        mRcvAdapter = new BaihatAdater(data);
//
//        mRecyclerView.setAdapter(mRcvAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(BaiHat11.this);
        adapter = new BaihatAdater(list, getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);

    }


    public void back(View view) {
        Intent intent = new Intent(BaiHat11.this, TrangCaNhan.class);
        startActivity(intent);
    }

    public void play1(View view) {
        Intent intent = new Intent(BaiHat11.this, PlayActivity.class);
        startActivity(intent);

    }
}
