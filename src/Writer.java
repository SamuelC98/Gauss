public class Writer implements Runnable {

    private DateFile df;
    private int writerNum;

    public Writer(int writerNum, DateFile df) {
        this.df = df;
        this.writerNum = writerNum;

    }

    public void run() {
        //while (true) {
        System.out.println("Writer " + writerNum + " comes here");
        //df.naps();
        df.startWrite();
        //df.naps();
        df.endWrite();
        //}
    }
}