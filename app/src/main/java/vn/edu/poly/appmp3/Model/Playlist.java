package vn.edu.poly.appmp3.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Playlist implements Serializable {

    @SerializedName("idPlaylist")
    @Expose
    private String idPlaylist;
    @SerializedName("Tenplaylist")
    @Expose
    private String tenplaylist;
    @SerializedName("Iconplaylist")
    @Expose
    private String iconplaylist;
    @SerializedName("nenPlaylist")
    @Expose
    private String nenPlaylist;

    public String getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(String idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getTenplaylist() {
        return tenplaylist;
    }

    public void setTenplaylist(String tenplaylist) {
        this.tenplaylist = tenplaylist;
    }

    public String getIconplaylist() {
        return iconplaylist;
    }

    public void setIconplaylist(String iconplaylist) {
        this.iconplaylist = iconplaylist;
    }

    public String getNenPlaylist() {
        return nenPlaylist;
    }

    public void setNenPlaylist(String nenPlaylist) {
        this.nenPlaylist = nenPlaylist;
    }
}

