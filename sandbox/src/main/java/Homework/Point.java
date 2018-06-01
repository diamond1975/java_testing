package Homework;

public class Point {

  double x, y;

  Point(double xk, double yk) {
    this.x = xk;
    this.y = yk;
  }

  public double gpsX() {
    return x;
  }

  public double gpsY() {
    return y;
  }
}