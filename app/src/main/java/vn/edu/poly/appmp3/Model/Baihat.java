package vn.edu.poly.appmp3.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Baihat implements Parcelable{

@SerializedName("idBaihat")
@Expose
private String idBaihat;
@SerializedName("idPlaylist")
@Expose
private String idPlaylist;
@SerializedName("idAlbum")
@Expose
private String idAlbum;
@SerializedName("TenBaihat")
@Expose
private String tenBaihat;
@SerializedName("TenCasi")
@Expose
private String tenCasi;
@SerializedName("Iconbaihat")
@Expose
private String iconbaihat;
@SerializedName("LinkBaihat")
@Expose
private String linkBaihat;

    protected Baihat(Parcel in) {
        idBaihat = in.readString();
        idPlaylist = in.readString();
        idAlbum = in.readString();
        tenBaihat = in.readString();
        tenCasi = in.readString();
        iconbaihat = in.readString();
        linkBaihat = in.readString();
    }

    public static final Creator<Baihat> CREATOR = new Creator<Baihat>() {
        @Override
        public Baihat createFromParcel(Parcel in) {
            return new Baihat(in);
        }

        @Override
        public Baihat[] newArray(int size) {
            return new Baihat[size];
        }
    };

    public String getIdBaihat() {
return idBaihat;
}

public void setIdBaihat(String idBaihat) {
this.idBaihat = idBaihat;
}

public String getIdPlaylist() {
return idPlaylist;
}

public void setIdPlaylist(String idPlaylist) {
this.idPlaylist = idPlaylist;
}

public String getIdAlbum() {
return idAlbum;
}

public void setIdAlbum(String idAlbum) {
this.idAlbum = idAlbum;
}

public String getTenBaihat() {
return tenBaihat;
}

public void setTenBaihat(String tenBaihat) {
this.tenBaihat = tenBaihat;
}

public String getTenCasi() {
return tenCasi;
}

public void setTenCasi(String tenCasi) {
this.tenCasi = tenCasi;
}

public String getIconbaihat() {
return iconbaihat;
}

public void setIconbaihat(String iconbaihat) {
this.iconbaihat = iconbaihat;
}

public String getLinkBaihat() {
return linkBaihat;
}

public void setLinkBaihat(String linkBaihat) {
this.linkBaihat = linkBaihat;
}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idBaihat);
        dest.writeString(idPlaylist);
        dest.writeString(idAlbum);
        dest.writeString(tenBaihat);
        dest.writeString(tenCasi);
        dest.writeString(iconbaihat);
        dest.writeString(linkBaihat);
    }
}