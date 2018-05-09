package Homework2;
//В класс Point добавлены два метода distance. Функция distance возвращает расстояние между двумя точками.
// Одному из совмещенных методов в качестве параметров передаются координаты точки х и у,
// другому же эта информация передается в виде параметра-объекта Point.
// К тому же задачу немного усложнил:
// Рассчитал длину (расстояние) всех 3-х сторон треугльника
// стороны Р1 и р2, р2 и р3, р1 и з3
public class Distance {
  public static void main(String args[]) {

    Point p1 = new Point(3, 7);
    Point p2 = new Point(30, 40);
    Point p3 = new Point(50, 60);

    System.out.println("p1 = " + p1.x + ", " + p1.y);
    System.out.println("p2 = " + p2.x + ", " + p2.y);
    System.out.println("p3 = " + p3.x + ", " + p3.y);
    System.out.println("Расстояние между Р1 и Р2 = " + p1.distance(p2)); // функцию distance используется как метод
    // в класее Point
    System.out.println("Расстояние между Р2 и Р3 " + p2.distance(p3));
    System.out.println("Расстояние между Р1 и Р3 " + p1.distance(p3));
  }
}
