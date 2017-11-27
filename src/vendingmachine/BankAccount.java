package vendingmachine;

/**
 *
 * @author Behrooz GholamHossein Fard 9413022
 */
public class BankAccount {

    private double cash; // person money in his/her bank account

    /*
     * Set cash
     */
    public void setCash(double t) {
        this.cash = t;
    }

    /*
     * Add income to cash
     */
    public void income(double t) {
        this.cash += t;
    }

    /*
     * Reduce cost from cash
     */
    public boolean cost(double t) {
        if ((this.cash - t) >= 0) {
            this.cash -= t;
            return true;
        } else {
            System.out.println("you don't have enough money");
        }
        return false;
    }

    /*
     * Get cash
     * @return cash
     */
    public double getCash() {
        return this.cash;
    }
}
