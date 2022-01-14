import java.io.*;

public class Product implements Serializable{
    //----------------------------------\\
    @Serial
    private static final long serialVersionUID = 1L;
    //----------------------------------\\
    private String productName;
    private String description;
    private Double price;
    private int stockCount;
    private int salesCount;
    private String[] reviews;
    private Boolean bestSelling;
    private String category;

    private String ownerName;
    //----------------------------------\\
    public Product(String productName, String description, Double price, int stockCount, int salesCount,String category, String ownerName) {
        this.productName = productName;

        this.description = description;
        this.price = price;
        this.stockCount = stockCount;
        this.salesCount = salesCount;
        setCategory(category);

        this.ownerName = ownerName;
     //   this.reviews = reviews;
    //    this.bestSelling = bestSelling;
    }
    //saveToFile

    public static void SaveToFile(Product product){   //add filepath as a parameter
        try{
            FileOutputStream fileOut = new FileOutputStream("Testu\\PRODUCTS\\"+product.productName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(product);
            objectOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Product ReadFromFile(String filepath){
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Product obj = (Product) objectIn.readObject();
            objectIn.close();
            return obj;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //----------------------------------\\

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    public String[] getReviews() {
        return reviews;
    }
    //the getter and setter for reviews has to be changed later.
    public void setReviews(String[] reviews) {
        this.reviews = reviews;
    }

    public Boolean getBestSelling() {
        return bestSelling;
    }

    public void setBestSelling(Boolean bestSelling) {
        this.bestSelling = bestSelling;
    }
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    //Category
    public void setCategory(String choice){
        switch (choice) {
            case "1":
                this.category = "Sports and Outdoor";
            break;
            case "2":
                this.category = "Games and Hobbies";
            break;
            case "3":
                this.category = "Machines and Gadgets";
            break;
            case "4":
                this.category = "Fashion and Accessories (men)";
            break;
            case "5":
                this.category = "Fashion and Accessories (women)";
            break;
            case "6":
                this.category = "Home and Living";
            break;
            case "0":
                this.category = "Other";
            break;
            default:
                this.category = "Other";
            break;
        }
    }
    public String getCategory() {
        return category;
    }
    //----------------------------------\\
}
