public class CreditCard extends Payment {
    private String cardNumber;
    private double creditLimit;

    public CreditCard(String accountHolder, String cardNumber, double creditLimit) {
        super(accountHolder);

        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount > creditLimit) {
            System.out.println("Payment failed, over credit limit!");
            return false;
        } else {
            this.printReceipt(amount);
            System.out.println("Payment successful!");
            return true;
        }
    }

    @Override
    public void printReceipt(double amount) {
        super.printReceipt(amount);
        System.out.println("***" + cardNumber.substring(cardNumber.length()-4));
    }
}
