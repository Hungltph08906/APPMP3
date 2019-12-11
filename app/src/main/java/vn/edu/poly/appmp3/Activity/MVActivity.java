package vn.edu.poly.appmp3.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.poly.appmp3.Adapter.MVAdapter;
import vn.edu.poly.appmp3.Model.MV;
import vn.edu.poly.appmp3.R;
import vn.edu.poly.appmp3.Service.APIService;
import vn.edu.poly.appmp3.Service.Dataservice;
import vn.edu.poly.appmp3.TrangCaNhan;

public class MVActivity extends AppCompatActivity {


    RecyclerView recyclerViewMV;
    MVAdapter mvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mv);
        init();
        GetData();
    }

    private void init() {
        recyclerViewMV = findViewById(R.id.recyclerViewMV);
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<MV>> callback = dataservice.GetMV();
        callback.enqueue(new Callback<List<MV>>() {
            @Override
            public void onResponse(Call<List<MV>> call, Response<List<MV>> response) {
                ArrayList<MV> mangmv = (ArrayList<MV>) response.body();
                mvAdapter = new MVAdapter(MVActivity.this,mangmv);
                recyclerViewMV.setLayoutManager(new LinearLayoutManager(MVActivity.this));
                recyclerViewMV.setAdapter(mvAdapter);

            }

            @Override
            public void onFailure(Call<List<MV>> call, Throwable t) {

            }
        });
    }

    public void trangcanhan(View view) {
        Intent intent = new Intent(MVActivity.this, TrangCaNhan.class);
        startActivity(intent);
    }

    public void nhacmoi(View view) {
        Intent intent = new Intent(MVActivity.this, AlbumActivity.class);
        startActivity(intent);
    }

    public void casi(View view) {
        Intent intent = new Intent(MVActivity.this, PlaylistActivity.class);
        startActivity(intent);
    }
}
