class Equipe {
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

  public String getNome() {
    return nome;
  }

  public int getTotalPontos() {
    return totalPontos;
  }

  public int getTotalVitorias() {
    return totalVitorias;
  }

  public int getSaldoGols() {
    return saldoGols;
  }

  public int getGolsPro() {
    return golsPro;
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
