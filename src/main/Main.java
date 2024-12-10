package main;

import service.PhoneService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneService phoneService = new PhoneService();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI");
            System.out.println("1. Thêm điện thoại mới");
            System.out.println("2. Xóa điện thoại");
            System.out.println("3. Xem danh sách điện thoại");
            System.out.println("4. Tìm kiếm điện thoại");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    phoneService.themDienThoaiMoi();
                    break;
                case 2:
                    phoneService.xoaDienThoai();
                    break;
                case 3:
                    phoneService.xemDanhSach();
                    break;
                case 4:
                    phoneService.timKiemDienThoai();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 5);
    }
}

