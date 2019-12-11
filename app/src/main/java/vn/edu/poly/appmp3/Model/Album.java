package vn.edu.poly.appmp3.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Album implements Serializable {

@SerializedName("idAlbum")
@Expose
private String idAlbum;
@SerializedName("TenAlbum")
@Expose
private String tenAlbum;
@SerializedName("TenCasiAlbum")
@Expose
private String tenCasiAlbum;
@SerializedName("IconAlbum")
@Expose
private String iconAlbum;

public String getIdAlbum() {
return idAlbum;
}

public void setIdAlbum(String idAlbum) {
this.idAlbum = idAlbum;
}

public String getTenAlbum() {
return tenAlbum;
}

public void setTenAlbum(String tenAlbum) {
this.tenAlbum = tenAlbum;
}

public String getTenCasiAlbum() {
return tenCasiAlbum;
}

public void setTenCasiAlbum(String tenCasiAlbum) {
this.tenCasiAlbum = tenCasiAlbum;
}

public String getIconAlbum() {
return iconAlbum;
}

public void setIconAlbum(String iconAlbum) {
this.iconAlbum = iconAlbum;
}

}