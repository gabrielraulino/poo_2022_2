import java.util.Scanner;

class Lead {
  private float thickness; //calibre
  private String hardness; //dureza
  private int size; //tamanho em mm
  public Lead(float thickness, String hardness, int size){
    this.thickness = thickness;
    this.hardness = hardness;
    this.size = size;
  }
   public String toString(){
    return "[" + thickness  + ":" + hardness + ":" + getSize() + "]"; 
  }
  public float getThickness(){
    return thickness;
  }
  public String getHardness(){
    return hardness;
  }
  public int getSize(){
    return size;
  }
  public void setSize(int size){
    this.size = size;
  }
  public int usagePerSheet(){
    switch (hardness) {
      case "HB":
        return 1;
      case "2B":
        return 2;
      case "4B":
        return 4;
      case "6B":
        return 6;
      default:
        return 0;
    }
  }
}
class Pencil {
  private float thickness;
  private Lead tip = null;
  public Pencil(float thickness){
    this.thickness = thickness;
  }
  public String toString(){
    if(tip == null)
      return "calibre " + thickness + ", grafite: " + null;
    else  
      return "calibre " + thickness + ", grafite: " + tip.toString();
  }
  public float getThickness(){
    return thickness;
  }
  public boolean hasGrafite(){
    return tip != null;
  }
  public boolean insert(Lead grafite){
    if(hasGrafite()){
      System.out.println("fail: ja existe grafite");
      return false;
    }
    if(grafite.getThickness() != thickness){
      System.out.println("fail: calibre incompatível");
      return false;
    }
    tip = grafite;
    return true;
    }
  
  public Lead remove(){
    tip = null;
    return tip;
  }
  public void writePage(){
    if(!hasGrafite()){
      return;
    }
    if(tip.getSize() <= 10){
      System.out.println("warning: grafite com tamanho insuficiente para escrever");
      return;
    }
    if(tip.getSize() - tip.usagePerSheet() < 10 ){
      System.out.println("fail: folha incompleta");
      tip.setSize(10);
      return;
    }
    tip.setSize(tip.getSize() - tip.usagePerSheet());

  }
}
class Solver{
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Pencil lapiseira = new Pencil(0.5f);
      while(true) {
          String line = scanner.nextLine();
          System.out.println("$" + line);
          String ui[] = line.split(" ");
          if(ui[0].equals("end")) {
              break;
          } else if(ui[0].equals("help")) {
              System.out.println("init _calibre; insert _calibre _dureza _tamanho; remove; write");
          } else if(ui[0].equals("init")) { //thickness
              lapiseira = new Pencil(Float.parseFloat(ui[1]));
          } else if(ui[0].equals("insert")) {//thickness hardness size
              float thickness = Float.parseFloat(ui[1]);
              String hardness  = ui[2];
              int size = Integer.parseInt(ui[3]);
              lapiseira.insert(new Lead(thickness, hardness, size));
          } else if(ui[0].equals("remove")) {
              lapiseira.remove();
          } else if(ui[0].equals("show")) {
              System.out.println(lapiseira);
          } else if (ui[0].equals("write")) {
              lapiseira.writePage();
          } else {
              System.out.println("fail: comando invalido");
          }
      }
      scanner.close();
  }
}