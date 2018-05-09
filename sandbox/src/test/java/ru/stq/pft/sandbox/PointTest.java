package ru.stq.pft.sandbox;

import Homework2.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testdistance () {
    Point p1 = new Point(3, 7);
    Point p2 = new Point(30, 40);
    Point p3 = new Point(50, 60);

    Assert.assertEquals(p1.distance (p2),42.638011210655684);
    Assert.assertEquals(p2.distance (p3),28.284271247461902);
    Assert.assertEquals(p1.distance (p3),70.83784299369935);
  }
}
