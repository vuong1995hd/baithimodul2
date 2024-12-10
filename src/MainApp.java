import controller.PhoneManager;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        PhoneManager phoneManager = new PhoneManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMENU CHỨC NĂNG:");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự xuống dòng

            switch (choice) {
                case 1:
                    // Thêm mới điện thoại
                    phoneManager.addNewPhone();
                    break;

                case 2:
                    // Xóa điện thoại
                    System.out.print("Nhập ID điện thoại muốn xóa: ");
                    String idToDelete = scanner.nextLine();
                    phoneManager.deletePhoneById(idToDelete);
                    break;

                case 3:
                    // Xem danh sách điện thoại
                    phoneManager.displayPhones();
                    break;

                case 4:
                    // Tìm kiếm điện thoại
                    System.out.print("Nhập từ khóa tìm kiếm (ID hoặc Tên điện thoại): ");
                    String keyword = scanner.nextLine();
                    phoneManager.displaySearchResults(phoneManager.searchPhones(keyword));
                    break;

                case 5:
                    // Thoát chương trình
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
