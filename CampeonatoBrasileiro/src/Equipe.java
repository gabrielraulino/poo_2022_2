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
    
    int pontos = Integer.compare(this.totalPontos, o.totalPontos);
    int vitorias;
    int saldo;
    int pro;
    if(pontos == 0){
      vitorias = Integer.compare(this.totalVitorias, o.totalVitorias);
      if(vitorias == 0){
        saldo = Integer.compare(this.saldoGols, o.saldoGols);
        if(saldo == 0){
          pro = Integer.compare(this.golsPro, o.golsPro);
          return pro * -1;
        }
        return saldo * -1;
      }
      return vitorias * -1;
    }
    
    return pontos * -1;
  }
  @Override
  public String toString() {
    return String.format("Equipe [nome=%s, totalPontos=%d, totalVitorias=%d, saldoGols=%d, golPro=%d]",
                        nome,
                        totalPontos,
                        totalVitorias,
                        saldoGols,
                        golsPro);
  }

  
}
 