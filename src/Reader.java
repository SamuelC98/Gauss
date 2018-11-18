public class Reader implements Runnable {
    private int readerNum;
    private DateFile df;

    public Reader(int readerNum, DateFile df) {
        this.readerNum = readerNum;
        this.df = df;
    }

    public void run() {
        //while (true) {
        System.out.println("reader " + readerNum + " comes here");
        df.naps();
        df.startRead();
        df.naps();
        df.endRead();
        //}
    }
}