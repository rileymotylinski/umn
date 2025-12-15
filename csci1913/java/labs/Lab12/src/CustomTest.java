public class CustomTest {

    public static void main(String[] args) {
        CacheBlockQueue<String> rq = new CacheBlockQueue<>();
        rq.enqueue("banana");
        System.out.println(rq.front());
        //Tester.doTest("banana", rq.front(), "queue front");
    }
}
