package NyHome;

public class IfSamle {

    public static void main(String[] args) {
      // TODO Auto-generated method stub
      int x,y;

      x=10;
      y=20;

      if (x<y)System.out.println("x меньше y");

      x=x*2;
      if(x==y) System.out.println("x теперь равна y");

      x=x*2;
      if(x>y) System.out.println("x теперь больше y");
      // этот оператор не будет ничего отображать
      if(x==y) System.out.println("вы не увидете это");


    }

  }
