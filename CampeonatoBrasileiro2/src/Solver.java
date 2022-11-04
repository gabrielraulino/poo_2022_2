import java.util.Scanner;
import java.util.Arrays;

class Solver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Equipe[] equipes = new Equipe[n];

        String nome;
        int totalPontos, totalVitorias, saldoGols, golsPro;

        for (int i = 0; i < n; i++) {
            nome = sc.next();
            totalPontos = sc.nextInt();
            totalVitorias = sc.nextInt();
            saldoGols = sc.nextInt();
            golsPro = sc.nextInt();
            equipes[i] = new Equipe(nome, totalPontos, totalVitorias, saldoGols, golsPro);
        }

        Arrays.sort(equipes, new ComparaEquipe());

        for (int i = 0; i < n; i++) {
            System.out.println(equipes[i]);
        }
      sc.close();
    }
}