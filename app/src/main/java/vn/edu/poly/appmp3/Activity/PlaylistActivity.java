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
import vn.edu.poly.appmp3.Adapter.PlaylistAdapter;
import vn.edu.poly.appmp3.Model.Playlist;
import vn.edu.poly.appmp3.R;
import vn.edu.poly.appmp3.Service.APIService;
import vn.edu.poly.appmp3.Service.Dataservice;
import vn.edu.poly.appmp3.TDQActivity;
import vn.edu.poly.appmp3.TrangCaNhan;

public class PlaylistActivity extends AppCompatActivity {


    RecyclerView recyclerViewPlaylist;
    PlaylistAdapter playlistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        init();
        GetData();
    }

    private void init() {
        recyclerViewPlaylist = findViewById(R.id.recyclerViewPlaylist);
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Playlist>> callback = dataservice.GetPlaylistCurrentDay();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                ArrayList<Playlist> mangplaylist = (ArrayList<Playlist>) response.body();
                playlistAdapter = new PlaylistAdapter(PlaylistActivity.this,mangplaylist);
                recyclerViewPlaylist.setLayoutManager(new LinearLayoutManager(PlaylistActivity.this));
                recyclerViewPlaylist.setAdapter(playlistAdapter);

            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }


    public void back(View view) {
        Intent intent = new Intent(PlaylistActivity.this, TrangCaNhan.class);
        startActivity(intent);
    }

    public void trinhdinhquang(View view) {
        Intent intent = new Intent(PlaylistActivity.this, TDQActivity.class);
        startActivity(intent);

    }

    public void mv(View view) {
        Intent intent = new Intent(PlaylistActivity.this, MVActivity.class);
        startActivity(intent);

    }

    public void Album(View view) {
        Intent intent = new Intent(PlaylistActivity.this, AlbumActivity.class);
        startActivity(intent);

    }

    public void trangcanhan(View view) {
        Intent intent = new Intent(PlaylistActivity.this, TrangCaNhan.class);
        startActivity(intent);

    }
}
