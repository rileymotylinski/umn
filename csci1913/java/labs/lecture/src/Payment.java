public abstract class Payment {
    private String accountHolder;

    public Payment(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public abstract boolean processPayment(double amount);

    protected void printReceipt(double amount) {
        System.out.print(this.accountHolder + " paid $" + amount + " using " + this.getClass().getName());
    }
}
