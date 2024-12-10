package controller;

import model.ImportedPhone;
import model.OfficialPhone;
import model.Phone;
import storage.CSVUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneManager {
    private List<Phone> phoneList;

    public PhoneManager() {
        this.phoneList = CSVUtils.readFromCSV();
    }

    // Tạo ID tự động tăng
    private String getNextId() {
        if (phoneList.isEmpty()) {
            return "1"; // Bắt đầu từ ID 1 nếu danh sách trống
        }
        int maxId = phoneList.stream()
                .mapToInt(phone -> Integer.parseInt(phone.getId()))
                .max()
                .orElse(0);
        return String.valueOf(maxId + 1);
    }

    // Phương thức thêm mới điện thoại
    public void addNewPhone() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chọn loại điện thoại muốn thêm:");
        System.out.println("1. Điện thoại chính hãng");
        System.out.println("2. Điện thoại xách tay");
        System.out.print("Lựa chọn: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ ký tự xuống dòng

        if (choice == 1) {
            // Thêm điện thoại chính hãng
            System.out.println("Nhập thông tin điện thoại chính hãng:");
            System.out.print("Tên điện thoại: ");
            String name = scanner.nextLine();
            System.out.print("Giá bán: ");
            double price = scanner.nextDouble();
            System.out.print("Số lượng: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự xuống dòng
            System.out.print("Nhà sản xuất: ");
            String manufacturer = scanner.nextLine();
            System.out.print("Thời gian bảo hành (tháng): ");
            int warrantyPeriod = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự xuống dòng
            System.out.print("Phạm vi bảo hành (Toan Quoc/Quoc Te): ");
            String warrantyScope = scanner.nextLine();

            // Tạo và thêm điện thoại chính hãng
            String id = getNextId();
            OfficialPhone officialPhone = new OfficialPhone(id, name, price, quantity, manufacturer, warrantyPeriod, warrantyScope);
            phoneList.add(officialPhone);
            CSVUtils.writeToCSV(phoneList); // Ghi lại danh sách vào file CSV
            System.out.println("Đã thêm mới điện thoại chính hãng thành công!");

        } else if (choice == 2) {
            // Thêm điện thoại xách tay
            System.out.println("Nhập thông tin điện thoại xách tay:");
            System.out.print("Tên điện thoại: ");
            String name = scanner.nextLine();
            System.out.print("Giá bán: ");
            double price = scanner.nextDouble();
            System.out.print("Số lượng: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự xuống dòng
            System.out.print("Nhà sản xuất: ");
            String manufacturer = scanner.nextLine();
            System.out.print("Quốc gia xách tay: ");
            String country = scanner.nextLine();
            System.out.print("Trạng thái (Da sua chua/Chua sua chua): ");
            String status = scanner.nextLine();

            // Tạo và thêm điện thoại xách tay
            String id = getNextId();
            ImportedPhone importedPhone = new ImportedPhone(id, name, price, quantity, manufacturer, country, status);
            phoneList.add(importedPhone);
            CSVUtils.writeToCSV(phoneList); // Ghi lại danh sách vào file CSV
            System.out.println("Đã thêm mới điện thoại xách tay thành công!");

        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    // Hiển thị danh sách điện thoại
    public void displayPhones() {
        if (phoneList.isEmpty()) {
            System.out.println("Danh sách điện thoại trống.");
        } else {
            System.out.println("Danh sách điện thoại:");
            for (Phone phone : phoneList) {
                System.out.println(phone.toString()); // Sử dụng toString() để hiển thị thông tin
            }
        }
    }


    // Xóa điện thoại theo ID
    public void deletePhoneById(String id) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Tìm kiếm điện thoại với ID tương ứng
            Phone phoneToDelete = null;
            for (Phone phone : phoneList) {
                if (phone.getId().equals(id)) {
                    phoneToDelete = phone;
                    break;
                }
            }

            // Nếu không tìm thấy, ném ngoại lệ
            if (phoneToDelete == null) {
                throw new NotFoundProductException("ID điện thoại không tồn tại.");
            }

            // Xác nhận từ người dùng trước khi xóa
            System.out.println("Bạn có chắc chắn muốn xóa điện thoại này? (Yes/No)");
            String confirmation = scanner.nextLine().trim();

            if (confirmation.equalsIgnoreCase("Yes")) {
                phoneList.remove(phoneToDelete);
                CSVUtils.writeToCSV(phoneList); // Cập nhật lại file CSV
                System.out.println("Đã xóa điện thoại thành công!");
                displayPhones(); // Hiển thị lại danh sách sau khi xóa
            } else if (confirmation.equalsIgnoreCase("No")) {
                System.out.println("Hủy thao tác xóa. Quay lại menu chính.");
            } else {
                System.out.println("Lựa chọn không hợp lệ. Quay lại menu chính.");
            }

        } catch (NotFoundProductException e) {
            System.out.println(e.getMessage());
        }
    }
    // tìm kiếm
    public List<Phone> searchPhones(String keyword) {
        List<Phone> result = new ArrayList<>();
        if (keyword == null || keyword.trim().isEmpty()) {
            System.out.println("Từ khóa tìm kiếm không được để trống.");
            return result;
        }

        for (Phone phone : phoneList) {
            // Kiểm tra từ khóa có xuất hiện trong ID hoặc Tên điện thoại (không phân biệt hoa thường)
            if (phone.getId().toLowerCase().contains(keyword.toLowerCase()) ||
                    phone.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(phone);
            }
        }

        return result;
    }

    public void displaySearchResults(List<Phone> results) {
        if (results.isEmpty()) {
            System.out.println("Không tìm thấy điện thoại nào phù hợp với từ khóa.");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (Phone phone : results) {
                System.out.println(phone.toString()); // Sử dụng phương thức toString để hiển thị thông tin
            }
        }
    }
}