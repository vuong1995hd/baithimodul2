package model;

public class ImportedPhone extends Phone {
    private String country;  // Quốc gia xách tay
    private String status;   // Trạng thái ("Da sua chua" hoặc "Chua sua chua")

    public ImportedPhone(String id, String name, double price, int quantity, String manufacturer, String country, String status) {
        super(id, name, price, quantity, manufacturer);
        this.country = country;
        this.status = status;
    }

    // Getters and Setters
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Override phương thức toString
    @Override
    public String toString() {
        return "ID: " + getId() +
                ", Tên: " + getName() +
                ", Giá: " + getPrice() +
                ", Số lượng: " + getQuantity() +
                ", Nhà sản xuất: " + getManufacturer() +
                ", Quốc gia xách tay: " + country +
                ", Trạng thái: " + status;
    }
    //IDE đề xuất :))
    @Override
    public String getDetails() {
        return "";
    }
}
