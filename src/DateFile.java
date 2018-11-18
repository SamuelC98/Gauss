public class DateFile {
    // readCount表示正在读的人数，初值为0,表示还没有人读。
    private int readerCount;
    // doreading表示读信号量，当doreading=true时不能进行写操作。
    private boolean doreading;
    // dowriting表示写信号量，当dowriting=ture时不能进行读操作。
    private boolean dowriting;

    public DateFile() {
        readerCount = 0;
        doreading = false;
        dowriting = false;
    }

    // 线程睡眠，不消耗CPU资源
    public static void naps() {
        try {
            Thread.sleep((int) (4000 * Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int startRead() {
        // 开始读操作

        while (dowriting == true) {
            try {
                System.out.println(Thread.currentThread().getName()+" is waiting");
                // 等待写者发出notify
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+" begin to read!");
        readerCount++;
        if (readerCount == 1) {
            doreading = true;
        }
        return readerCount;
    }

    public synchronized int endRead() {
        // 结束读操作
        --readerCount;
        if (readerCount == 0) {
            doreading = false;
        }
        notifyAll();
        System.out.println(Thread.currentThread().getName()+" reading done!");
        return readerCount;
    }

    public synchronized void startWrite() {
        // 开始写操作

        while (doreading == true || dowriting == true) {
            try {
                System.out.println(Thread.currentThread().getName()+" is waiting");
                wait();
                // 等待写者或读者发出notify
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" begin to write!");
        dowriting = true;
    }

    public synchronized void endWrite() {
        // 结束写操作
        dowriting = false;
        notifyAll();
        System.out.println(Thread.currentThread().getName()+" writing done!");
    }
}
