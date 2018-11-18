/**
 * Created by apple on 2018/6/21.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new SubThread();
        Thread t2 = new SubThread();
        t1.start();
        t2.start();
        for (int i = 0; i < 50; i++) {
            System.out.println("main....." + i);
        }
    }
}
