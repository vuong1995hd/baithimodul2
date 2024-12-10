package service;

import model.DienThoai;
import model.DienThoaiChinhHang;
import model.DienThoaiXachTay;
import util.CSVUtils;

import java.util.List;
import java.util.Scanner;

public class PhoneService {
    private static final String FILE_PATH = "data/mobiles.csv";

    // Thêm điện thoại
    public void themDienThoaiMoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chọn loại điện thoại (1: Chính Hãng, 2: Xách Tay): ");
        int loai = Integer.parseInt(scanner.nextLine());

        System.out.print("Tên điện thoại: ");
        String ten = scanner.nextLine();
        System.out.print("Giá bán: ");
        double gia = Double.parseDouble(scanner.nextLine());
        System.out.print("Số lượng: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhà sản xuất: ");
        String nhaSanXuat = scanner.nextLine();

        List<String> data = CSVUtils.read(FILE_PATH);
        int id = data.size() + 1;

        DienThoai dienThoai;
        if (loai == 1) {
            System.out.print("Thời gian bảo hành (ngày): ");
            int baoHanh = Integer.parseInt(scanner.nextLine());
            System.out.print("Phạm vi bảo hành (Toàn Quốc/Quốc Tế): ");
            String phamVi = scanner.nextLine();
            dienThoai = new DienThoaiChinhHang(id, ten, gia, soLuong, nhaSanXuat, baoHanh, phamVi);
        } else {
            System.out.print("Quốc gia xách tay: ");
            String quocGia = scanner.nextLine();
            System.out.print("Trạng thái (Da sua chua/Chua sua chua): ");
            String trangThai = scanner.nextLine();
            dienThoai = new DienThoaiXachTay(id, ten, gia, soLuong, nhaSanXuat, quocGia, trangThai);
        }

        CSVUtils.write(FILE_PATH, dienThoai.toCSV());
        System.out.println("Thêm điện thoại thành công!");
    }

    // Xóa điện thoại
    public void xoaDienThoai() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID điện thoại cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        List<String> data = CSVUtils.read(FILE_PATH);
        boolean found = false;

        for (String line : data) {
            String[] parts = line.split(",");
            int currentId = Integer.parseInt(parts[0]);

            if (currentId == id) {
                found = true;
                System.out.print("Bạn có chắc chắn muốn xóa? (Yes/No): ");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("Yes")) {
                    data.remove(line);
                    CSVUtils.writeAll(FILE_PATH, data);
                    System.out.println("Xóa điện thoại thành công!");
                } else {
                    System.out.println("Hủy thao tác xóa.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("ID điện thoại không tồn tại.");
        }
    }

    // Xem danh sách điện thoại
    public void xemDanhSach() {
        List<String> data = CSVUtils.read(FILE_PATH);
        for (String line : data) {
            System.out.println(line);
        }
    }

    // Tìm kiếm điện thoại
    public void timKiemDienThoai() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID hoặc tên điện thoại để tìm: ");
        String keyword = scanner.nextLine().toLowerCase();

        List<String> data = CSVUtils.read(FILE_PATH);
        boolean found = false;

        for (String line : data) {
            if (line.toLowerCase().contains(keyword)) {
                System.out.println(line);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy điện thoại.");
        }
    }
}
