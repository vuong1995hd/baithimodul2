package storage;

import model.Phone;
import model.OfficialPhone;
import model.ImportedPhone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    private static final String FILE_PATH = "mobiles.csv";

    /**
     * Đọc dữ liệu từ file CSV và trả về danh sách điện thoại
     * @return danh sách điện thoại
     */
    public static List<Phone> readFromCSV() {
        List<Phone> phones = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals("Official")) {
                    // Điện thoại chính hãng
                    phones.add(new OfficialPhone(
                            data[1], // ID
                            data[2], // Tên
                            Double.parseDouble(data[3]), // Giá bán
                            Integer.parseInt(data[4]), // Số lượng
                            data[5], // Nhà sản xuất
                            Integer.parseInt(data[6]), // Thời gian bảo hành
                            data[7]  // Phạm vi bảo hành
                    ));
                } else if (data[0].equals("Imported")) {
                    // Điện thoại xách tay
                    phones.add(new ImportedPhone(
                            data[1], // ID
                            data[2], // Tên
                            Double.parseDouble(data[3]), // Giá bán
                            Integer.parseInt(data[4]), // Số lượng
                            data[5], // Nhà sản xuất
                            data[6], // Quốc gia xách tay
                            data[7]  // Trạng thái
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file CSV: " + e.getMessage());
        }
        return phones;
    }

    /**
     * Ghi danh sách điện thoại vào file CSV
     * @param phoneList danh sách điện thoại cần ghi
     */
    public static void writeToCSV(List<Phone> phoneList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Phone phone : phoneList) {
                if (phone instanceof OfficialPhone) {
                    OfficialPhone officialPhone = (OfficialPhone) phone;
                    writer.write("Official," +
                            officialPhone.getId() + "," +
                            officialPhone.getName() + "," +
                            officialPhone.getPrice() + "," +
                            officialPhone.getQuantity() + "," +
                            officialPhone.getManufacturer() + "," +
                            officialPhone.getWarrantyPeriod() + "," +
                            officialPhone.getWarrantyScope()
                    );
                } else if (phone instanceof ImportedPhone) {
                    ImportedPhone importedPhone = (ImportedPhone) phone;
                    writer.write("Imported," +
                            importedPhone.getId() + "," +
                            importedPhone.getName() + "," +
                            importedPhone.getPrice() + "," +
                            importedPhone.getQuantity() + "," +
                            importedPhone.getManufacturer() + "," +
                            importedPhone.getCountry() + "," +
                            importedPhone.getStatus()
                    );
                }
                writer.newLine(); // Xuống dòng cho mỗi điện thoại
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file CSV: " + e.getMessage());
        }
    }
}