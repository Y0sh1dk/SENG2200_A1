public class PA1 {
    public static void main(String[] args) {
        PA1 main = new PA1();
        main.run(args);
    }

    private void run(String[] args) {
        Point p = new Point(345.564, 87.111);
        System.out.println(p);
        System.out.println(p.distFromOrigin());

    }
}
