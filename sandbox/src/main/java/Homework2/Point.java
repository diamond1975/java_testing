package Homework2;

public class Point {
  int x, y;
  public Point(int х, int y) {
    this.x = х;
    this.y = y;
  }

  public double distance(int х, int у) {
    int dx = this.x - х;
    int dy = this.y - у;
    return Math.sqrt(dx*dx + dy*dy);
  }

  public double distance(Point p) {
    return distance(p.x, p.y);
  }
}