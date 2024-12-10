package model;

public class DienThoaiXachTay extends DienThoai {
    private String quocGiaXachTay;
    private String trangThai;

    public DienThoaiXachTay(int id, String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat,
                            String quocGiaXachTay, String trangThai) {
        super(id, tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.quocGiaXachTay = quocGiaXachTay;
        this.trangThai = trangThai;
    }

    @Override
    public String toCSV() {
        return getId() + "," + getTenDienThoai() + "," + getGiaBan() + "," + getSoLuong() + "," +
                getNhaSanXuat() + "," + quocGiaXachTay + "," + trangThai;
    }

    @Override
    public String toString() {
        return "DienThoaiXachTay{" +
                "ID=" + getId() +
                ", Ten='" + getTenDienThoai() + '\'' +
                ", Gia=" + getGiaBan() +
                ", SoLuong=" + getSoLuong() +
                ", NhaSanXuat='" + getNhaSanXuat() + '\'' +
                ", QuocGiaXachTay='" + quocGiaXachTay + '\'' +
                ", TrangThai='" + trangThai + '\'' +
                '}';
    }
}

