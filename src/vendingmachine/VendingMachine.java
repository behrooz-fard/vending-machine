package vendingmachine;

import java.util.*;

/**
 *
 * @author Behrooz GholamHossein Fard 9413022
 */
public class VendingMachine {

    public static void main(String[] args) {

        Machine machine = new Machine(); // object of class Machine
        Vendor vendor = new Vendor(machine, 100); // object of class Vendor
        Vendee vendee = new Vendee(machine, vendor, 25000); // object of class Vendee

        machine.add("chocolate", 500, 3); // add a product calls chocolate to machine 
        machine.add("sandwich", 5000, 5); // add two products calls sandwich to machine 
        machine.add("sandise", 600, 6); // add tree products calls sandise to machine 
        machine.add("cake", 700, 1); // add four products calls cake to machine 

        boolean ques = true;  // Variable to check continue program or not
        Scanner input = new Scanner(System.in); // object to get user data from keyboard
        while (ques) {
            System.out.println("press 1 if you are vendor, press 2 if you are vendee, press 3 to set machine off");
            switch (input.next()) {
                case "1":
                    vendor.menu();
                    break;
                case "2":
                    vendee.menu();
                    break;
                case "3": {
                    ques = false;
                    System.out.println("The machine is set off.");
                    break;
                }
                default: {
                    System.out.println("Please enter an integer between 1 to 3.");
                    break;
                }
            }
        }
    }
}
