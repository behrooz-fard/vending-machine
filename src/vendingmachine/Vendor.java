package vendingmachine;

import java.util.Scanner;

/**
 *
 * @author Behrooz GholamHossein Fard 9413022
 */
public class Vendor implements MenuInterface {

    private int password = 1234; // Default vendor password
    private String username = "username"; // Default vendor username

    Machine machine;
    BankAccount vendorAccount = new BankAccount();

    /*
     * Constructor
     */
    public Vendor(Machine m, double t) {
        this.machine = m;
        vendorAccount.setCash(t);
    }

    /*
     * Control that user is vendor or not
     */
    public boolean logIn() {
        Scanner input = new Scanner(System.in);
        int counter = 0;
        System.out.println("Enter your username");
        if (!this.username.equals(input.next())) {
            System.out.println("The username is not correct.");
            return false;
        }

        System.out.println("Enter your password");
        while (counter < 4) {
            if (this.password == input.nextInt()) {
                return true;
            }
            counter++;
            System.out.println("The password is not correct. Try again:");
        }
        return false;
    }

    /*
     * Show vendee's menu
     */
    @Override
    public void menu() {
        if (this.logIn() == false) {
            return;
        }
        boolean ques = true;
        Scanner input = new Scanner(System.in);

        while (ques) {
            System.out.println("press 1 to show products list, 2 to increase, 3 to add, 4 to decrease, "
                    + "5 to delete, 6 to replace," + "\n"
                    + " 7 to update price," + " 8 to show account," + " 9 to change username"
                    + " 10 to change password" + " 11 to back.");
            switch (input.next()) {
                case "1":
                    machine.menu();
                    break;
                case "2":
                    this.increaseProduct();
                    break;
                case "3":
                    this.addProduct();
                    break;
                case "4":
                    this.decreaseProduct();
                    break;
                case "5":
                    this.deleteProduct();
                    break;
                case "6":
                    this.replaceProduct();
                    break;
                case "7":
                    this.updatePrice();
                    break;
                case "8":
                    this.showAccount();
                    break;
                case "9":
                    this.changeUsername();
                    break;
                case "10":
                    this.changePassword();
                    break;
                case "11":
                    ques = false;
                    break;
                default: {
                    System.out.println("Please enter an integer between 1 to 11.");
                    break;
                }

            }
        }
    }

    /*
     * Increase number of product in a row
     */
    public void increaseProduct() {
        int productIndex, number;
        Scanner input = new Scanner(System.in);
        System.out.println("please enter index of product:");
        productIndex = input.nextInt();
        System.out.println("please enter number to add");
        number = input.nextInt();
        machine.increase(productIndex, number);
    }

    /*
     * Add a new product
     */
    public void addProduct() {
        String productName;
        double productPrice;
        int productNumber;
        Scanner input = new Scanner(System.in);

        System.out.println("please enter name:");
        productName = input.next();
        System.out.println("please enter price:");
        productPrice = input.nextDouble();
        System.out.println("please enter number:");
        productNumber = input.nextInt();

        machine.add(productName, productPrice, productNumber);
    }

    /*
     * Decrease number of a product in a row
     */
    public void decreaseProduct() {
        int productIndex, newNumber;
        Scanner input = new Scanner(System.in);

        System.out.println("please enter index of product:");
        productIndex = input.nextInt();
        System.out.println("please enter number to decrease");
        newNumber = input.nextInt();

        machine.decrease(productIndex, newNumber);
    }

    /*
     * Delete a  of product from a row
     */
    public void deleteProduct() {
        int productIndex;
        Scanner input = new Scanner(System.in);

        System.out.println("please enter index:");
        productIndex = input.nextInt();

        machine.delete(productIndex);
    }

    /*
     * Replace a row of product with a new product
     */
    public void replaceProduct() {
        int lastProductIndex;
        String newProductName;
        double newProductPrice;

        Scanner input = new Scanner(System.in);
        System.out.println("please enter index of last product:");
        lastProductIndex = input.nextInt();
        System.out.println("please enter name of new product:");
        newProductName = input.next();
        System.out.println("please enter price:");
        newProductPrice = input.nextDouble();

        machine.replace(lastProductIndex, newProductName, newProductPrice);
    }

    /*
     * Show account of vendor
     */
    public void showAccount() {
        System.out.println("your account remaining: " + vendorAccount.getCash());
    }

    /*
     * Increase vendor money
     */
    public void incomeMoney(double t) {
        vendorAccount.income(t);
    }

    /*
     * Change price of a specific product
     */
    public void updatePrice() {
        int index;
        double price;
        Scanner input = new Scanner(System.in);

        System.out.println("please enter index:");
        index = input.nextInt();
        System.out.println("please enter new price:");
        price = input.nextDouble();

        machine.setProductPrice(index, price);
    }

    /*
     * Change username
     */
    public void changeUsername() {
        Scanner input = new Scanner(System.in);

        if (this.logIn() != true) {
            System.out.println("You don't have permission to change username.");
            return;
        } else {
            System.out.println("Enter new username.");
            this.username = input.next();
        }
    }

    /*
     * Change password
     */
    public void changePassword() {
        
        int temp;
        Scanner input = new Scanner(System.in);

        if (this.logIn() != true) {
            System.out.println("You don't have permission to change password.");
            return;
        } else {
            System.out.println("Enter new password.");
            temp = input.nextInt();
            System.out.println("Enter new password again.");
            if (temp == input.nextInt()) {
                this.password = temp;
            } else {
                System.out.println("Your password was not changed! Please try again.");
            }
        }
    }
}
