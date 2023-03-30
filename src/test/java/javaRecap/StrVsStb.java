package javaRecap;

import java.util.Random;

public class StrVsStb {

    public static void main(String[] args) {


        Random random = new Random();
        long mc_number=(long)(Math.random()*Math.pow(15,10));
        long dot_number=(long)(Math.random()*Math.pow(10,10));
        System.out.println(mc_number);
        System.out.println(dot_number);

        int num = 5;
        Integer numWrapper  = num;

        Integer numWrap = 10;
        int num2= numWrap;

        String number = "1234";
        int numInt = Integer.valueOf(number);

        //String to primitive
        String number1 = "123456";
        int number2 = Integer.valueOf(number);

        //String to wrapper class
        String numberr3 = "23455";
        Integer number4 = Integer.parseInt(numberr3);

    }
}
