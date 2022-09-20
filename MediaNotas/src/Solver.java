import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

class MediaNotas {
  private ArrayList<Double> notas = new ArrayList<Double>();

  public void addNota(double nota) {
    notas.add(nota);
  }

  public void removeNota(int index) {
    notas.remove(index);
  }

  private void mudaNota(int index, double valor) {
    notas.set(index, valor);
  }

  public double maiorNota() {
    return Collections.max(notas);
  }

  public double menorNota() {
    return Collections.min(notas);
  }

  double media() {
    Double media = 0.0;
    for (Double double1 : notas) {
      media += double1;
    }
    return media / notas.size();
  }

  void parametriza() {
    int index = 0;
    Double maior = maiorNota();

    for (Double double1 : notas) {
      double m = 0.0;
      m = (double1 / maior) * 10;
      mudaNota(index, m);
      index++;
    }
  }

  public String toString() {
    StringBuilder show = new StringBuilder();
    for (Double double1 : notas) {
      if (show.toString().equals(""))
        show.append(String.format("%.2f", double1));
      else
        show.append(", ").append(String.format("%.2f", double1));
    }
    return "[" + show + "]";
  }
}

class Solver {
  public static void main(String[] args) {
    Locale.setDefault ( Locale.US ) ;
    Scanner scanner = new Scanner(System.in);
    MediaNotas m = new MediaNotas();
    label: while (true) {
      String line = scanner.nextLine();
      String[] ui = line.split(" ");
      System.out.println("$" + line);
      switch (ui[0]) {
        case "end":
          break label;
        case "addNota":
          m.addNota(Double.parseDouble(ui[1]));
          break;
        case "removeNota":
          m.removeNota(Integer.parseInt(ui[1]));
          break;
        case "maiorNota":
          System.out.println(m.maiorNota());
          break;
        case "menorNota":
          System.out.println(m.menorNota());
          break;
        case "media":
          System.out.printf(Locale.US, "%.2f\n", m.media());
          break;
        case "parametriza":
          m.parametriza();
          break;
        case "show":
          System.out.println(m);
          break;
        default:
          System.out.println("fail: comando invalido");
          break;
      }
    }
    scanner.close();
  }
}
