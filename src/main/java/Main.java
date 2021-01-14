public class Main {
    public static void main(String[] args) {
        int a = 5 % 2;
//        System.out.println(a);

        System.out.println(Math.ceil(customLog(2,4)));



    }

    public static double customLog(int base, int logNumber) {
        return (Math.log(logNumber) / Math.log(base));
    }
}
