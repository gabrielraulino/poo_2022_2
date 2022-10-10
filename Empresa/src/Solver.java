import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Locale;

class Solver {
  static Shell sh = new Shell();
  static Empresa empresa = new Empresa();

  public static void main(String[] args) {
    sh.setfn("addEmpregado", () -> empresa.adicionaEmpregado(
        new Empregado(sh.par(1),
            toInt(sh.par(2)),
            toDouble(sh.par(3)))));
    sh.setfn("addTerceirizado", () -> empresa.adicionaEmpregado(
        new Terceirizado(sh.par(1),
            toInt(sh.par(2)),
            toDouble(sh.par(3)),
            toDouble(sh.par(4)))));

    sh.setfn("mostra", () -> empresa.mostraEmpregado());
    sh.setfn("calculaFolha", () -> System.out.printf("Folha de pagamento: %.2f\n",
        empresa.calculaFolha()));
    sh.execute();
  }

  static int toInt(String s) {
    return Integer.parseInt(s);
  }

  static double toDouble(String s) {
    return Double.parseDouble(s);
  }
}

class Shell {
  private Scanner scanner = new Scanner(System.in);
  private HashMap<String, Runnable> chain = new HashMap<>();
  private ArrayList<String> ui = new ArrayList<>();

  public Shell() {
    Locale.setDefault(new Locale("en", "US"));
  }

  public void setfn(String key, Runnable value) {
    chain.put(key, value);
  }

  public String par(int index) {
    return ui.get(index);
  }

  public void execute() {
    while (true) {
      ui.clear();
      String line = scanner.nextLine();
      Collections.addAll(ui, line.split(" "));
      System.out.println("$" + line);
      if (ui.get(0).equals("end")) {
        break;
      } else if (chain.containsKey(ui.get(0))) {
        chain.get(ui.get(0)).run();
      } else {
        System.out.println("fail: comando invalido");
      }
    }
  }

}