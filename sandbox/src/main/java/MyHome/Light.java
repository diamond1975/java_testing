package NyHome;

public class Light {
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int lightspeed;
    long days;
    long seconds;
    long distanse;
    //аппроксимация скорости света в мили в секунду
    lightspeed=186000;
    days=1000;                               //задать количество дней
    seconds=days*24*60*60;                   //преобразовать в секунды
    distanse=lightspeed*seconds;             // вычеслить расстояние
    System.out.print("За " +days);
    System.out.print(" дней световой сигнал пройдет около ");
    System.out.println(distanse + " миль.");
  }

}