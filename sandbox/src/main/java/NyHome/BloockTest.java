package NyHome;

public class BloockTest {

    public static void main (String args []) {
      int x,y;
      y=20;
      // телом этого цикла является блок
      for (x=0; x<10; x++) {
        System.out.println("Значение x: " +x);
        System.out.println("Значение y: " +y);
        y=y-3;
      }
    }
  }
