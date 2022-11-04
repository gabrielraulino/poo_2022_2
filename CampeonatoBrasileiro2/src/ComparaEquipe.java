import java.util.Comparator;

class ComparaEquipe implements Comparator<Equipe> {
  public int compare(Equipe t1, Equipe t2) {
    int pontos = Integer.compare(t1.getTotalPontos(), t2.getTotalPontos()) * -1;
    if(pontos != 0)
      return pontos;
    int vitorias = Integer.compare(t1.getTotalVitorias(), t2.getTotalVitorias()) * -1;
    if(vitorias != 0)
      return vitorias;
    int saldo = Integer.compare(t1.getSaldoGols(), t2.getSaldoGols()) * -1;
    if(saldo != 0)
      return saldo;
    int gols = Integer.compare(t1.getGolsPro(), t2.getGolsPro()) * -1;
    return gols;
      
  }
  
}




