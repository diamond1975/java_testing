package ru.stqa.pft.sandbox;

public class Rectangle1 {
  public double a;
  public double b;

  public Rectangle1 (double a, double b){
    this.a = a;
    this.b = b;
  }

  public  double area() {
    return this.a*this.b;
  }

}