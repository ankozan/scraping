package rei;


public class Item {

    private  String imgLink;
    private String brand;
    private String title;
    private String newPrice;
    private String oldPrice;
    private String savingsPercentage;


    public Item(String brand, String title, String newPrice, String oldPrice, String savingsPercentage, String imgLink) {
        this.brand = brand;
        this.title = title;
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
        this.savingsPercentage = savingsPercentage;
        this.imgLink = imgLink;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getSavingsPercentage() {
        return savingsPercentage;
    }

    public void setSavingsPercentage(String savingsPercentage) {
        this.savingsPercentage = savingsPercentage;
    }
    public String getImgLink() {
        return imgLink;
    }

}
