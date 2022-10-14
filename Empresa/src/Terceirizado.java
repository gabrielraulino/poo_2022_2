public class Terceirizado extends Empregado {
  private Double despesaAdicional;

  public Terceirizado(String nome, Integer horas, Double valorPorHora, Double despesaAdicional) {
    super(nome, horas, valorPorHora);
    this.despesaAdicional = despesaAdicional;
  }

  public Double getDespesaAdicional() {
    return despesaAdicional;
  }

  public void setDespesaAdicional(Double despesaAdicional) {
    this.despesaAdicional = despesaAdicional;
  }

  @Override
  public Double pagamento() {
    return this.getHoras() * this.getValorPorHora() + this.getDespesaAdicional() * 1.1;
  }

  @Override
  public String toString() {
    return super.toString() + ", Despesa adicional: " + despesaAdicional;
  }
}