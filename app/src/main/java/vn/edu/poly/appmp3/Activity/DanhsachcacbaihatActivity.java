package vn.edu.poly.appmp3.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.poly.appmp3.Adapter.DanhsachbaihatAdapter;
import vn.edu.poly.appmp3.Model.Album;
import vn.edu.poly.appmp3.Model.Baihat;
import vn.edu.poly.appmp3.Model.Playlist;
import vn.edu.poly.appmp3.R;
import vn.edu.poly.appmp3.Service.APIService;
import vn.edu.poly.appmp3.Service.Dataservice;

public class DanhsachcacbaihatActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView rycdanhsachcacbaihat;
    FloatingActionButton floatingActionButton;
    Album album;
    Playlist playlist;
    ImageView imgdanhsachbaihat;
    DanhsachbaihatAdapter danhsachbaihatAdapter;
    ArrayList<Baihat> mangbaihat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachcacbaihat);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        anhxa();
        init();
        DataIntent();
        if (album != null && !album.getTenAlbum().equals("")){
            setValueInView(album.getTenAlbum(),album.getIconAlbum());
            GetDataAlbum(album.getIdAlbum());
        }

        if (playlist != null && !playlist.getTenplaylist().equals("")){
            setValueInView(playlist.getTenplaylist(),playlist.getIconplaylist());
            GetDataPlaylist(playlist.getIdPlaylist());
        }

    }

    private void GetDataAlbum(String idAlbum) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDanhsachbaihatAlbum(idAlbum);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(DanhsachcacbaihatActivity.this,mangbaihat);
                rycdanhsachcacbaihat.setLayoutManager(new LinearLayoutManager(DanhsachcacbaihatActivity.this));
                rycdanhsachcacbaihat.setAdapter(danhsachbaihatAdapter);
                eventCLick();

            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }
    private void GetDataPlaylist(String idPlaylist) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDanhsachbaihatPlaylist(idPlaylist);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(DanhsachcacbaihatActivity.this,mangbaihat);
                rycdanhsachcacbaihat.setLayoutManager(new LinearLayoutManager(DanhsachcacbaihatActivity.this));
                rycdanhsachcacbaihat.setAdapter(danhsachbaihatAdapter);
                eventCLick();

            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }


    private void setValueInView(String ten, String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try {
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(hinh).into(imgdanhsachbaihat);
    }

    private void init() {
//        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        floatingActionButton.setEnabled(false);
    }

    

    private void DataIntent() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("album")){
                album = (Album) intent.getSerializableExtra("album");
            }
            if(intent.hasExtra("playlist")){
                playlist = (Playlist) intent.getSerializableExtra("playlist");
            }
        }


    }

    private void anhxa() {
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        collapsingToolbarLayout = findViewById(R.id.collapsimgtoolbar);
        toolbar = findViewById(R.id.toolbardanhsach);
        rycdanhsachcacbaihat = findViewById(R.id.rycdanhsachcacbaihat);
        floatingActionButton = findViewById(R.id.floatingactionbutton);
        imgdanhsachbaihat = findViewById(R.id.imgdanhsachbaihat);
    }
    private void eventCLick(){
        floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhsachcacbaihatActivity.this,PlaynhacActivity.class);
                intent.putExtra("cacbaihat",mangbaihat);
                startActivity(intent);
            }
        });

    }
}
