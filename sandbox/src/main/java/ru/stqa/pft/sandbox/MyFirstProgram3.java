package ru.stqa.pft.sandbox;

public class MyFirstProgram3 {
  public static void main(String[] args) {
    Monkey("Send");
    Monkey("Diamond");
    Monkey("Katy");

    Square s = new Square(5);
    //s.l = 5;
    System.out.println("Площада квадрата со стороной " + s.l + " = " + area(s));

    Rectangle r= new Rectangle(4,6);
    //r.a= 4;
    //r.b = 100;

    System.out.println("Площада прямоугольника со стронами " + r.a + " и " + r.b + " =" + area(r));
  }

  public static void Monkey(String Moskow) {
    System.out.println("Hello, " + Moskow + "!");
  }

  public static double area(Square s) {
    return s.l* s.l;

  }

  public static double area(Rectangle r) {
    return r.a*r.b;
  }
}
