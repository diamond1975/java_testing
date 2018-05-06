package NyHome;

public class Example4 {
  public static void main(String[] args) {
    // TODO Auto-generated method stub
		/*
		Эта программа демонстрирует отличия между типами int и double.
		Присвоить ее исходному файлу имя Example3.java.
		*/
    int var; // объявить целочисленную переменную
    double x; // объявить переменную с плавающей точкой
    var = 10; // присвоить переменной var значение 10
    x = 10.0; // присвоить переменной x значение 10.0
    System.out.println("Original value of var: " + var);
    System.out.println("Original value of x: " + x);
    System.out.println(); // вывести пустую строку
    // а теперь разделить значения обеих переменных на 4 var = var / 4;
    x = x / 4;
    System.out.println("var after division: " + var);
    System.out.println("x after division: " + x);


  }

}
