package vendingmachine;

import java.util.*;

/**
 *
 * @author Behrooz GholamHossein Fard 9413022
 */
public class Vendee implements MenuInterface {

    Machine machine;
    Vendor vendor;
    BankAccount vendeeAccount = new BankAccount();

    /*
     * Constructor
     */
    public Vendee(Machine m, Vendor v, double t) {
        this.machine = m;
        vendor = v;
        vendeeAccount.setCash(t);
    }

    /*
     * Show vendee's menu
     */
    @Override
    public void menu() {
        boolean a = true;
        Scanner input = new Scanner(System.in);
        while (a) {
            System.out.println("press 1 to see products list, 2 to buying, 3 to back");

            switch (input.next()) {
                case "1":
                    machine.menu();
                    break;
                case "2":
                    this.buy();
                    break;
                case "3":
                    a = false;
                    break;
                default: {
                    System.out.println("Please enter an integer between 1 to 3.");
                    break;
                }
            }
        }
    }

    /*
     * Methode to handle buying
     * It can buy more than one product by one transaction
     */
    public void buy() {
        int index, number;
        boolean ques = true;
        Scanner input = new Scanner(System.in);

        while (ques) {
            System.out.println("please enter index:");
            index = input.nextInt();
            System.out.println("please enter number to buy:");
            number = input.nextInt();

            double temp = machine.getProductsPrice(index, number);
            if ((machine.decrease(index, number)) == true) {
                if ((this.costMoney(temp)) == true) {
                    vendor.incomeMoney(temp);
                }
            }
            System.out.println("Do you want to continue your buying? (yes/no)");

            switch (input.next()) {
                case "yes":
                    ques = true;
                    break;
                case "no":
                    ques = false;
                    break;
                default:
                    ques = false;
                    break;
            }
        }
    }

    /*
     * Decrease vendee money
     */
    public boolean costMoney(double t) {
        return vendeeAccount.cost(t);
    }
}
