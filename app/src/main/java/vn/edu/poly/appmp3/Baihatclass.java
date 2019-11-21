package vn.edu.poly.appmp3;

public class Baihatclass {
    private String Tenbaihat;
    private String Tencasi;
    private String Thoigian;
    private int Img;

    public Baihatclass(String tenbaihat, String tencasi, String thoigian, int img) {
        Tenbaihat = tenbaihat;
        Tencasi = tencasi;
        Thoigian = thoigian;
        Img = img;
    }

    public String getTenbaihat() {
        return Tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        Tenbaihat = tenbaihat;
    }

    public String getTencasi() {
        return Tencasi;
    }

    public void setTencasi(String tencasi) {
        Tencasi = tencasi;
    }

    public String getThoigian() {
        return Thoigian;
    }

    public void setThoigian(String thoigian) {
        Thoigian = thoigian;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }
}
