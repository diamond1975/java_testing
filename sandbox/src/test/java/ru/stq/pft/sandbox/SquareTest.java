package ru.stq.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Square;
import ru.stqa.pft.sandbox.Square1;

public class SquareTest {

  @Test
  public void testarea () {

    Square1 s = new Square1(5);
    Assert.assertEquals(s.area(),25.0);
  }
}
