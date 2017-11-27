package vendingmachine;

/**
 *
 * @author Behrooz GholamHossein Fard 9413022
 */
public class Products {

    private String name; // Name of product
    private int number; // Number of same products in a row
    final private int maxNumber = 20; // Maximum number of smae product can be exist in a row
    private double price; // Price of a product

    /*
     * Constructor
     */
    public Products(String a, double b, int n) {
        this.setName(a);
        this.setPrice(b);
        this.setNumber(n);
    }

    /*
     * Set name of product
     */
    public void setName(String a) {
        this.name = a;
    }

    /*
     * Set number of product
     */
    public void setNumber(int a) {
        this.number = a;
    }

    /*
     * Set price of product
     */
    public void setPrice(double a) {
        this.price = a;
    }

    /*
     * Update number of product
     */
    public void updateNumber(int a) {
        this.setNumber(this.getNumber() + a);
    }

    /*
     * Get name of a specific product
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /*
     * Get number of a specific product
     * @return number
     */
    public int getNumber() {
        return this.number;
    }

    /*
     * Get maximum number of a specific product
     * @return price
     */
    public int getMaxNumber() {
        return this.maxNumber;
    }

    /*
     * Get price of a specific product
     * @return price
     */
    public double getPrice() {
        return this.price;
    }
}
