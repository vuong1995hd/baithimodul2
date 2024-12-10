package model;

public class DienThoaiChinhHang extends DienThoai {
    private int thoiGianBaoHanh;
    private String phamViBaoHanh;

    public DienThoaiChinhHang(int id, String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat,
                              int thoiGianBaoHanh, String phamViBaoHanh) {
        super(id, tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }



    @Override
    public String toCSV() {
        return getId() + "," + getTenDienThoai() + "," + getGiaBan() + "," + getSoLuong() + "," +
                getNhaSanXuat() + "," + thoiGianBaoHanh + "," + phamViBaoHanh;
    }

    @Override
    public String toString() {
        return "DienThoaiChinhHang{" +
                "ID=" + getId() +
                ", Ten='" + getTenDienThoai() + '\'' +
                ", Gia=" + getGiaBan() +
                ", SoLuong=" + getSoLuong() +
                ", NhaSanXuat='" + getNhaSanXuat() + '\'' +
                ", ThoiGianBaoHanh=" + thoiGianBaoHanh +
                ", PhamViBaoHanh='" + phamViBaoHanh + '\'' +
                '}';
    }
}

