import java.util.ArrayList;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    ArrayList<Shape> lista = new ArrayList<Shape>();
    int index = 0;
    Scanner sc = new Scanner(System.in);
    while (true) {
      String line = sc.nextLine();
      System.out.println("$" + line);
      String ui[] = line.split(" ");
      if (line.equals("end")) {
        break;
      } else if (ui[0].equals("circulo")) {
        double x = Double.parseDouble(ui[1]);
        double y = Double.parseDouble(ui[2]);
        double r = Double.parseDouble(ui[3]);
        Circulo e = new Circulo(new Ponto2D(x, y), r);
        if(!lista.isEmpty())
          index++;
        lista.add(e);
      } else if (ui[0].equals("retangulo")) {
        double x1 = Double.parseDouble(ui[1]);
        double y1 = Double.parseDouble(ui[2]);
        double x2 = Double.parseDouble(ui[3]);
        double y2 = Double.parseDouble(ui[4]);
        Retangulo e = new Retangulo(new Ponto2D(x1, y1), new Ponto2D(x2, y2));
        if(!lista.isEmpty())
          index++;
        lista.add(e);
      } else if (ui[0].equals("area")) {
        double area = 0d;
        for (Shape shape : lista) {
          area += shape.area();
        }
        System.out.printf("area total: %.2f \n",area);
      } else if (ui[0].equals("perimetro")) {//value value
        double perimetro = 0d;
        for (Shape figura : lista) {
          perimetro += figura.perimeter();
        }
        System.out.printf("perimetro total: %.2f \n", perimetro);
      } else if (ui[0].equals("inside")) {//value value
        double x = Double.parseDouble(ui[1]);
        double y = Double.parseDouble(ui[2]);
        for (Shape shape: lista) {
          System.out.println(shape.inside(new Ponto2D(x, y)));
        }
      } else if (ui[0].equals("mostra")) {//value value
        System.out.println("Figura:");
        for (Shape shape:lista) {
          System.out.println(shape.toString());
        }
      } else {
        System.out.println("fail: comando invalido");
      }
    }
    sc.close();


  }
}