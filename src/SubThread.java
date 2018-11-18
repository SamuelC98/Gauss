/**
 * Created by apple on 2018/6/21.
 */
public class SubThread extends Thread{
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("run..." + i);

        }
    }
}
