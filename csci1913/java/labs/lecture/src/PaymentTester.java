public class PaymentTester {
    public static void main(String[] args) {
        CreditCard c = new CreditCard("John Doe", "1234567890123456",5000);
        PayPal p = new PayPal("Jane Smith","jane@email.com");

        c.processPayment(300);
        p.processPayment(300);

        p.invalidateAccount();

        p.processPayment(300);
    }
}
