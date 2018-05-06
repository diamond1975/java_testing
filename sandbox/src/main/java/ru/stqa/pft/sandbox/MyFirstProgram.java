package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    System.out.println("Hello, world!");

    String somebody = "world";
    String bolder = "Hello";
    String touch = "!";
    System.out.println (bolder + somebody + touch);

    int l = 8;
    int s = l*l;
    System.out.println("Площадь квадрата со стороной " + l + " = "+s);

    double j = 8;
    double k = j*j;
    System.out.println("Площадь квадрата со стороной " + j + " = "+k);

    System.out.println(2+2);
    System.out.println(2*2);
    System.out.println(2/2);
    System.out.println(2-2);
    System.out.println(1/2);
    System.out.println(1.0/2);
    System.out.println(1/3.0);
    System.out.println(2.0/3);
    System.out.println("2"+"4");//Делить, умножать, вычитать нельзя. Только можно сложить.
    System.out.println("2"+4);
    System.out.println(2+"4");
    System.out.println(2+2*5);
    System.out.println((2+2)*5);
    System.out.println("2+2="+2+4);
    System.out.println("2+2="+(2+4));

  }

}
