package vn.edu.poly.appmp3.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MV implements Serializable {

    @SerializedName("IdMV")
    @Expose
    private String idMV;
    @SerializedName("TenMV")
    @Expose
    private String tenMV;
    @SerializedName("TenCasiMV")
    @Expose
    private String tenCasiMV;
    @SerializedName("HinhnenMV")
    @Expose
    private String hinhnenMV;
    @SerializedName("LinhMV")
    @Expose
    private String linhMV;
    @SerializedName("iconCasiMV")
    @Expose
    private String iconCasiMV;

    public String getIdMV() {
        return idMV;
    }

    public void setIdMV(String idMV) {
        this.idMV = idMV;
    }

    public String getTenMV() {
        return tenMV;
    }

    public void setTenMV(String tenMV) {
        this.tenMV = tenMV;
    }

    public String getTenCasiMV() {
        return tenCasiMV;
    }

    public void setTenCasiMV(String tenCasiMV) {
        this.tenCasiMV = tenCasiMV;
    }

    public String getHinhnenMV() {
        return hinhnenMV;
    }

    public void setHinhnenMV(String hinhnenMV) {
        this.hinhnenMV = hinhnenMV;
    }

    public String getLinhMV() {
        return linhMV;
    }

    public void setLinhMV(String linhMV) {
        this.linhMV = linhMV;
    }

    public String getIconCasiMV() {
        return iconCasiMV;
    }

    public void setIconCasiMV(String iconCasiMV) {
        this.iconCasiMV = iconCasiMV;
    }

}