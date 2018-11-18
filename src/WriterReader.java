public class WriterReader {
    public static void main(String[] args) {
        DateFile df = new DateFile();
        Reader r1 = new Reader(1, df);
        Reader r2 = new Reader(2, df);
        Reader r3 = new Reader(3, df);
        Reader r4 = new Reader(4, df);
        Writer w1 = new Writer(1, df);
        Writer w2 = new Writer(2, df);
        Writer w3 = new Writer(3, df);
        new Thread(r1, "读者线程 r1").start();
        new Thread(r2, "读者线程r2").start();
        new Thread(r3, "读者线程r3").start();
        new Thread(r4, "读者线程r4").start();
        new Thread(w1, "写者线程w1").start();
        new Thread(w2, "写者线程w2").start();
        new Thread(w3, "写者线程w3").start();
    }
}