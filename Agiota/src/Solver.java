import java.util.Scanner;

public class Solver {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Agiota ag = new Agiota(0);

    while (true) {
      try {
        String line = sc.nextLine();
        System.out.println("$" + line);
        String[] ui = line.split(" ");
        if (ui[0].equals("init")) {
          int balance = Integer.parseInt(ui[1]);
          ag = new Agiota(balance);
        } else if (ui[0].equals("end")) {
          break;
        } else if (ui[0].equals("addCli")) {
          String codenome = ui[1];
          int value = Integer.parseInt(ui[2]);
          ag.addClient(codenome, value);
        } else if (ui[0].equals("lend")) {
          String codinome = ui[1];
          int value = Integer.parseInt(ui[2]);
          ag.lends(codinome, value);
        } else if (ui[0].equals("show")) {
          System.out.println(ag.toString());
        } else if (ui[0].equals("receive")) {
          String codename = ui[1];
          int value = Integer.parseInt(ui[2]);
          ag.receive(codename, value);
        } else if (ui[0].equals("kill")) {
          String codename = ui[1];
          ag.kill(codename);
        } else {
          System.out.println("comando invalido");
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Erro na digitação");
      }
    }

    sc.close();

  }
}
