package javaRecap;

public class MethodOverloding {

    public void getSum(int num1, int num2){
        System.out.println(num1+num2);
    }

    public int getSum(int num1, int num2, int num3){
       return num1+num2+num3;
    }

    public static void main(String[] args) {

        MethodOverloding overloding = new MethodOverloding();
        overloding.getSum(5,5);
        System.out.println(overloding.getSum(5,5,5));

        Parent parent = new Child();
        System.out.println(parent.myMethod()) ;
    }
}
