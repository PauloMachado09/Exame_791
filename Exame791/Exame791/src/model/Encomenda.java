package model;

public class Encomenda {

    private String ProductID;
    private String ProductName;
    private String UnitPrice;
    private String Quantity;

    public Encomenda(String productID, String productName, String unitPrice, String quantity) {
        ProductID = productID;
        ProductName = productName;
        UnitPrice = unitPrice;
        Quantity = quantity;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        UnitPrice = unitPrice;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }


}