package vn.edu.poly.appmp3.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.poly.appmp3.Adapter.AlbumAdapter;
import vn.edu.poly.appmp3.AlbumTDQActivity;
import vn.edu.poly.appmp3.Model.Album;
import vn.edu.poly.appmp3.R;
import vn.edu.poly.appmp3.Service.APIService;
import vn.edu.poly.appmp3.Service.Dataservice;
import vn.edu.poly.appmp3.TrangCaNhan;

public class AlbumActivity extends AppCompatActivity {
    RecyclerView recyclerViewAlbum;
    AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        init();
        GetData();
    }

    private void init() {
        recyclerViewAlbum = findViewById(R.id.rycalbum);
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.GetAlbumHot();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> manfalbum = (ArrayList<Album>) response.body();
                albumAdapter = new AlbumAdapter(AlbumActivity.this,manfalbum);
                recyclerViewAlbum.setLayoutManager(new GridLayoutManager(AlbumActivity.this,2));
                recyclerViewAlbum.setAdapter(albumAdapter);

            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

    public void back(View view) {
        Intent intent = new Intent(AlbumActivity.this, TrangCaNhan.class);
        startActivity(intent);
    }

    public void albumtdq(View view) {
        Intent intent = new Intent(AlbumActivity.this, AlbumTDQActivity.class);
        startActivity(intent);

    }

    public void trangcanhan(View view) {
        Intent intent = new Intent(AlbumActivity.this, TrangCaNhan.class);
        startActivity(intent);
    }

    public void Playlist(View view) {
        Intent intent = new Intent(AlbumActivity.this, PlaylistActivity.class);
        startActivity(intent);
    }

    public void mv(View view) {
        Intent intent = new Intent(AlbumActivity.this, MVActivity.class);
        startActivity(intent);
    }
}
