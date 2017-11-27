package vendingmachine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Behrooz GholamHossein Fard 9413022
 */
public class Machine implements MenuInterface {

    private static int productsNum = 0; // number of different product that exist in machine
    private static final int maxProductsNum = 10; // maximume of different product that exist in machine
    private ArrayList<Products> product = new ArrayList<Products>(); // array list of products

    /*
     * Increase number of a pruduct
     */
    public void increase(int index, int number) {
        if (index < 0 || index > productsNum) {
            System.out.println("this product is not exist.");
        }
        index--;
        if (number + product.get(index).getNumber() <= product.get(index).getMaxNumber()) {
            product.get(index).updateNumber(number);
        } else {
            System.out.println("there is not enough space to add " + number + " " + product.get(index).getName());
        }
    }

    /*
     * Add a pruduct
     */
    public void add(String name, double price, int number) {
        if (productsNum < maxProductsNum) {
            product.add(new Products(name, price, number));
            productsNum++;
        } else {
            System.out.println("there is not enough space to add a new differet product.");
        }
    }

    /*
     * Decrease number of a pruduct
     */
    public boolean decrease(int index, int number) {
        index--;
        if (index < 0 || index > productsNum) {
            System.out.println("this product is not exist.");
            return false;
        }

        if (product.get(index).getNumber() - number == 0) {
            this.delete(index + 1);
            return true;
        }
        if (number < product.get(index).getNumber()) {
            product.get(index).updateNumber(-1 * number);
            return true;
        } else {
            System.out.println("there is not enough " + product.get(index).getName() + " to decrease.");
            return false;
        }
    }

    /*
     * Delete a row of pruducts
     */
    public void delete(int index) {
        index--;
        if (index >= 0 && index < productsNum) {
            product.remove(index);
        } else {
            System.out.println("this product is not exist.");
        }
    }

    /*
     * Replace a row of pruducts
     */
    public void replace(int index, String name, double price) {
        index--;
        if (index >= 0 && index < productsNum) {
            product.set(index, new Products(name, price, 1));
        } else {
            System.out.println("this product is not exist.");
        }
    }

    /*
     * Show all of products
     */
    @Override
    public void menu() {
        for (int i = 0; i < product.size(); i++) {
            System.out.println("#" + (i + 1) + " " + product.get(i).getName() + "\t\t"
                    + product.get(i).getPrice() + " Rial" + "\t\t"
                    + product.get(i).getNumber() + " exist");
        }
    }

    /*
     * Get price of a specific product
     * @return price
     */
    public double getProductsPrice(int index, int number) {
        index--;
        if (index < 0 || index > productsNum) {
            return 0;
        }
        return (product.get(index).getPrice()) * number;
    }

    /*
     * Set price of a specific product
     */
    public void setProductPrice(int index, double price) {
        index--;
        product.get(index).setPrice(price);
    }
}
