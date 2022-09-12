import java.util.Scanner;
import java.util.Locale;

class Jogo {
  private static int index = 0;
  private int numJogadores;
  private int[] armadilha;
  private int[] posicao;
  private boolean[] podeJogar;
  private int numArmadilha = 0;
  private int numCasas;
  private int prox;
  private boolean fimDoJogo = false;

  public Jogo(int numJogadores, int numCasas) {
    this.numJogadores = numJogadores;
    this.numCasas = numCasas;
    posicao = new int[numJogadores];
    for (int i = 0; i < posicao.length; i++) {
      posicao[i] = 0;
    }
    numArmadilha = 3;
    armadilha = new int[numArmadilha];
  }

  public void addArmadilha(int t) {
    armadilha[index] = t;
    index++;
  }

  public void addMove(int d1, int d2) {

  }

  public String toString(){
    String retorno = "";
    for(int i = 0; i < numJogadores; i++){
      retorno += "PosJogador[" + (i + 1) +"] = " + posicao[i]+"\n";
    }
    
    return retorno;
    }

}

class Solver {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Locale.setDefault(Locale.US);
    Jogo jogo = new Jogo(0, 0);

    while (true) {
      String line = scanner.nextLine();
      String ui[] = line.split(" ");
      System.out.println("$" + line);
      if (ui[0].equals("init")) {
        jogo = new Jogo(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
      } else if (ui[0].equals("end")) {
        break;
      } else if (ui[0].equals("addArmadilha")) {
        jogo.addArmadilha(Integer.parseInt(ui[1]));
      } else if (ui[0].equals("addMove")) {
        int d1 = Integer.parseInt(ui[1]);
        int d2 = Integer.parseInt(ui[2]);
        jogo.addMove(d1, d2);
      } else if (ui[0].equals("show")) {
        System.out.println(jogo);
      } else {
        System.out.println("fail: comando invalido");
      }
    }
    scanner.close();
  }
}