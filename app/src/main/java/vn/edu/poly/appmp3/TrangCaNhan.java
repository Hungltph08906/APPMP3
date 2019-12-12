package vn.edu.poly.appmp3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import vn.edu.poly.appmp3.Activity.AlbumActivity;
import vn.edu.poly.appmp3.Activity.DanhsachcacbaihatActivity;
import vn.edu.poly.appmp3.Activity.MVActivity;
import vn.edu.poly.appmp3.Activity.PlaylistActivity;
import vn.edu.poly.appmp3.Activity.PlaynhacActivity;

public class TrangCaNhan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_ca_nhan);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông Báo!!!!");
        builder.setMessage("Ưng dụng hơi chậm nên quý khách vui lòng kiên nhẫn đợi, không nhấn lên tục, xin lỗi vì sự bất tiện này");
        builder.setCancelable(false);

        builder.setNegativeButton("Đã Hiểu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void baihat(View view) {
        Intent intent = new Intent(TrangCaNhan.this, BaiHat11.class);
        startActivity(intent);
    }

    public void playlist(View view) {
        Intent intent = new Intent(TrangCaNhan.this, PlaylistActivity.class);
        startActivity(intent);
    }

    public void album(View view) {
        Intent intent = new Intent(TrangCaNhan.this, AlbumActivity.class);
        startActivity(intent);
    }

    public void baihatdatai(View view) {
        Intent intent = new Intent(TrangCaNhan.this, Baihatdatai.class);
        startActivity(intent);
    }

    public void nhacmoi(View view) {
        Intent intent = new Intent(TrangCaNhan.this, AlbumActivity.class);
        startActivity(intent);
    }

    public void casi(View view) {
        Intent intent = new Intent(TrangCaNhan.this, PlaylistActivity.class);
        startActivity(intent);
    }

    public void mv(View view) {
        Intent intent = new Intent(TrangCaNhan.this, MVActivity.class);
        startActivity(intent);
    }

    public void mymv(View view) {
        Intent intent = new Intent(TrangCaNhan.this, MyMV.class);
        startActivity(intent);
    }

    public void danhsachbaihat(View view) {
        Intent intent = new Intent(TrangCaNhan.this, DanhsachcacbaihatActivity.class);
        startActivity(intent);
    }

    public void playnhac(View view) {
        Intent intent = new Intent(TrangCaNhan.this, PlaynhacActivity.class);
        startActivity(intent);

    }
}
