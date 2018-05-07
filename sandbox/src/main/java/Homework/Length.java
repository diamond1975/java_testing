package Homework;

public class Length {

  Point p1, p2;

  Length(Point Point1, Point Point2) {
    this.p1 = Point1;
    this.p2 = Point2;
  }

  public double Distance() {
    return Math.sqrt
            ((p1.gpsX() - p2.gpsX()) * (p1.gpsX() - p2.gpsX()) + (p1.gpsY() - p2.gpsY()) * (p1.gpsY() - p2.gpsY()));
  }

  public static void main(String args[]) {
    Length l = new Length(new Point(3.0, 4.0), new Point(7.0, 11.0));
    double al = l.Distance();
    System.out.println("Distance - 'Расстояние между двумя точками'  = " + al);
  }
}
