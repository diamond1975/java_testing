package ru.stqa.pft.sandbox;

public class Square1    {
  public double l;

  public Square1(double l) {

    //l=len;
    this.l= l;    // это тот объект, который инициализируется в конструкторе, т.е this ссылается на конкретный атрибут,
    //а не на объект
  }

  public double area() {
    return this.l * this.l;
  }
}