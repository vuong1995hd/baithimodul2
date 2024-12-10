package model;

public class OfficialPhone extends Phone {
    private int warrantyPeriod; // Thời gian bảo hành (tháng)
    private String warrantyScope; // Phạm vi bảo hành ("Toan Quoc" hoặc "Quoc Te")

    public OfficialPhone(String id, String name, double price, int quantity, String manufacturer, int warrantyPeriod, String warrantyScope) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyScope = warrantyScope;
    }

    // Getters and Setters
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyScope() {
        return warrantyScope;
    }

    public void setWarrantyScope(String warrantyScope) {
        this.warrantyScope = warrantyScope;
    }

    // Override phương thức toString
    @Override
    public String toString() {
        return "ID: " + getId() +
                ", Tên: " + getName() +
                ", Giá: " + getPrice() +
                ", Số lượng: " + getQuantity() +
                ", Nhà sản xuất: " + getManufacturer() +
                ", Thời gian bảo hành: " + warrantyPeriod + " tháng" +
                ", Phạm vi bảo hành: " + warrantyScope;
    }
    //IDE đề xuất :))
    @Override
    public String getDetails() {
        return "";
    }
}