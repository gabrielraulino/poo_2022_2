import java.util.Scanner;

class Time {
  private int hour = 0;
  private int minute = 0;
  private int second = 0;

  public Time(int hour, int minute, int second){
    setHour(hour);
    setMinute(minute);
    setSecond(second);
  }  

  public void setHour(int hour){
    if(hour > 24 || hour < 0 ){
      System.out.println("fail: hora invalida");
    }else if(hour == 24)
      this.hour = 0;
    else  
      this.hour = hour; 
  }

  public void setMinute(int minute){
    if(minute == 60){
      setHour(getHour() + 1);
      setMinute(0);
    }else if(minute > 59 || minute < 0 ){
        System.out.println("fail: minuto invalido");
      }
      else
        this.minute = minute;
      
    }


  public void setSecond(int second){
    if(second == 60){
      setMinute(getMinute() + 1);
      setSecond(0);
    }else if(second > 59 || second < 0 ){
        System.out.println("fail: segundo invalido");
      }
      else
        this.second = second;
  
    }

  public int getHour(){
    return hour;
  }

  public int getMinute(){
    return minute;
  }  

  public int getSecond(){
    return second;
  } 

  //avança o tempo em um segundo
  public void nextSecond(){
    setSecond(getSecond() + 1);
  } // todo 

  public String toString() {
      return String.format("%02d", hour) + ":" + 
              String.format("%02d", minute) + ":" + 
              String.format("%02d", second);
  }
}


class Solver {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Time time = new Time(0, 0, 0);
      while (true) {
          String line = scanner.nextLine();
          System.out.println("$" + line);

          String[] ui = line.split(" ");
          String cmd = ui[0];

          if (cmd.equals("end")) {
              break;
          } else if (cmd.equals("set")) {
              time.setHour(Integer.parseInt(ui[1]));
              time.setMinute(Integer.parseInt(ui[2]));
              time.setSecond(Integer.parseInt(ui[3]));
          } else if (cmd.equals("show")) {
              System.out.println(time);
          } else if (cmd.equals("next")) {
              time.nextSecond();
          } else {
              System.out.println("fail: comando inválido");
          }
      }

      scanner.close();
  }
}