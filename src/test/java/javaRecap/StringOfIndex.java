package javaRecap;

public class StringOfIndex {

    public static void main(String[] args) {
        String myStr = "Hello planet earth, you are a great planet.";
        System.out.println(myStr.length());
        System.out.println(myStr.lastIndexOf("planet"));
        int num = 1234;
        int rev = 0;

        while (num != 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        System.out.println(rev);
        swap(3,5);

    }
        public static void swap(int x, int y){
            x = x+y;
            y = x-y;
            x = x-y;
            System.out.println("x: " + x + " y: "+ y);
        }

}