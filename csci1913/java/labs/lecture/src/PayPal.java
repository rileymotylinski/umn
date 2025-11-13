public class PayPal extends Payment{
    String email;
    boolean validAccount;

    public PayPal(String accountHolder, String email){
        super(accountHolder);
        this.email = email;
        this.validAccount = true;

    }


    @Override
    public boolean processPayment(double amount) {
        if (!validAccount) {
            System.out.println("Invalid account!");
            return false;
        } else {
            this.printReceipt(amount);
            System.out.println("Payment successful!");
            return true;
        }
    }

    public void invalidateAccount() {
        this.validAccount = false;
    }

    @Override
    public void printReceipt(double amount) {
        super.printReceipt(amount);
        System.out.println(" " + this.email);
    }
}
