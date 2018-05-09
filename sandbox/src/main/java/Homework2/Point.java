package Homework2;

public class Point {
  int x, y;
  Point(int х, int y) {
    this.x = х;
    this.y = y;
  }

  double distance(int х, int у) {
    int dx = this.x - х;
    int dy = this.y - у;
    return Math.sqrt(dx*dx + dy*dy);
  }

  double distance(Point p) {
    return distance(p.x, p.y);
  }
}