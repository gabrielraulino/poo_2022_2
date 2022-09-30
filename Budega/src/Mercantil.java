import java.util.ArrayList;
import java.util.LinkedList;

public class Mercantil {
  LinkedList<Pessoa> espera = new LinkedList<>();
  ArrayList<Pessoa> caixa;
  int length;
  Mercantil(int qtdCaixas) {
    caixa = new ArrayList<>(qtdCaixas);
    for (int index = 0; index < qtdCaixas; index++) {
      caixa.add(null);
    }
    length = qtdCaixas;
  }

  public void chegar(Pessoa p) {
    espera.addLast(p);
  }

  public boolean chamarNoCaixa(int indice) {
    if(espera.isEmpty()){
      System.out.println("fail: fila vazia");
      return false;
    }
    caixa.set(indice, espera.removeFirst());
    return true;
  }

  public Pessoa finalizarAtendimento(int indice) {
    Pessoa finish =  caixa.get(indice);
    caixa.set(indice, null);
    return finish;
  }

  public String toString() {
    String show = "";
    String nulo = "-----";
    for (int index = 0; index < length; index++) {
      if(caixa.get(index) == null)
        show += "|" + index + ":" + nulo;
      else  
        show += "|" + index + ":" + caixa.get(index);
    }
    show += "|\nEspera: " + espera.toString();
    return show;
  }
}