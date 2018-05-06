package ru.stqa.pft.sandbox;

public class MyFirstProgram4 {
  public static void main(String[] args) {
    Monkey("Send");
    Monkey("Diamond");
    Monkey("Katy");

    Square1 s = new Square1(5);
    //s.l = 5;
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle1 r= new Rectangle1(4,6);
    //r.a= 4;
    //r.b = 100;

    System.out.println("Площадь прямоугольника со стронами " + r.a + " и " + r.b + " =" + r.area());
  }

  public static void Monkey(String Moskow) {
    System.out.println("Hello, " + Moskow + "!");
  }

}

