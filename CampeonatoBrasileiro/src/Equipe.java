import java.lang.Comparable;

class Equipe implements Comparable<Equipe> {
  private String nome;
  private int totalPontos;
  private int totalVitorias;
  private int saldoGols;
  private int golsPro;


  public Equipe(String nome, int totalPontos, int totalVitorias, int saldoGols, int golsPro) {
    this.nome = nome;
    this.totalPontos = totalPontos;
    this.totalVitorias = totalVitorias;
    this.saldoGols = saldoGols;
    this.golsPro = golsPro;
  }



  @Override
  public int compareTo(Equipe o) {
    // TODO Auto-generated method stub
    return 0;
  }
}
 