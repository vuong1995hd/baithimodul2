package model;

public abstract class DienThoai {
    private int id;
    private String tenDienThoai;
    private double giaBan;
    private int soLuong;
    private String nhaSanXuat;

    public DienThoai(int id, String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat) {
        this.id = id;
        this.tenDienThoai = tenDienThoai;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getId() { return id; }
    public String getTenDienThoai() { return tenDienThoai; }
    public double getGiaBan() { return giaBan; }
    public int getSoLuong() { return soLuong; }
    public String getNhaSanXuat() { return nhaSanXuat; }

    public abstract String toCSV();

    @Override
    public abstract String toString();
}

