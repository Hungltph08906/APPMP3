package vn.edu.poly.appmp3.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import vn.edu.poly.appmp3.Model.Album;
import vn.edu.poly.appmp3.Model.Baihat;
import vn.edu.poly.appmp3.Model.MV;
import vn.edu.poly.appmp3.Model.Playlist;

public interface Dataservice {

    @GET("playlist.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("album.php")
    Call<List<Album>> GetAlbumHot();

    @GET("MV.php")
    Call<List<MV>> GetMV();

    @FormUrlEncoded
    @POST("baihat.php")
    Call<List<Baihat>> GetDanhsachbaihatAlbum(@Field("idAlbum") String idAlbum);

    @FormUrlEncoded
    @POST("baihat.php")
    Call<List<Baihat>> GetDanhsachbaihatPlaylist(@Field("idPlaylist") String idPlaylist);
}
