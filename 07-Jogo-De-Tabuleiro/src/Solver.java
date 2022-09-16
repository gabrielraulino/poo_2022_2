import java.util.Scanner;
import java.util.Locale;

class Jogo {

  private int numJogadores;
  private int numCasas;
  private int[] posJogador;
  private int proximoJogador;
  private int[] armadilhas;
  private boolean[] podeJogar;
  private int qtdArmadilhas = 0;
  private boolean fimJogo = false;

  public Jogo(int numJogadores, int numCasas) {
    this.numJogadores = numJogadores;
    this.numCasas = numCasas;
    posJogador = new int[numJogadores];
    podeJogar = new boolean[numJogadores];
    for (int i = 0; i < numJogadores; i++) {
      posJogador[i] = 0;
      podeJogar[i] = true;
    }
    proximoJogador = 0;
    armadilhas = new int[3];

  }

  public void addArmadilha(int t) {
    if (qtdArmadilhas < 3) {
      armadilhas[qtdArmadilhas] = t;
      qtdArmadilhas++;
    }
  }

  public void addMove(int d1, int d2) {
    if (fimJogo) {
      System.out.println("O jogo acabou");
      return;
    }
    if (podeJogar[proximoJogador] == false) {
      System.out.printf
      ("O jogador %d passa a vez\n",
      proximoJogador + 1);
      podeJogar[proximoJogador] = true;
      proximoJogador = (proximoJogador + 1) % numJogadores;

    }
    posJogador[proximoJogador] += d1 + d2;
    System.out.printf
    ("O jogador %d vai para a casa %d\n", 
    proximoJogador + 1, 
    posJogador[proximoJogador]);
    if(posJogador[proximoJogador] > numCasas){
      System.out.printf("O jogador %d venceu o jogo\n", proximoJogador + 1);
      fimJogo = true;
      return;
    }
    boolean caiu = false;
    for (int i = 0; i < 3; i++) {
      if (posJogador[proximoJogador] == armadilhas[i]) {
        caiu = true;
        podeJogar[proximoJogador] = false;
        break;
      }
    }
    if (caiu) {
      System.out.printf("O jogador %d caiu em um armadilha\n", proximoJogador + 1);
    }
    proximoJogador = (proximoJogador + 1) % numJogadores;

  }

  public String toString() {
    String retorno = "";
    for (int i = 0; i < numJogadores; i++) {
      retorno += String.format("PosJogador[%d] = %d\n", i + 1, posJogador[i]);
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